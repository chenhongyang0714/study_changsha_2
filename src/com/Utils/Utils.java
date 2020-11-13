package com.Utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.study.vo.Music;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    /**
     * 获取 token
     *
     * @return token值
     */
    public static String getToken() {
        String token = "";
        try {
//            方法一
            URL url = new URL("http://www.kuwo.cn");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            String setCookies = httpURLConnection.getHeaderField("Set-Cookie");
            System.out.println("setCookies:" + setCookies);
            String[] splits = setCookies.split(";");
            for (int i = 0; i < splits.length; i++) {
                if (splits[i].contains("kw_token")) {
                    token = splits[i].split("=")[1];
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * searchName   查询该歌手的歌曲JSON数据
     *
     * @param searchName 歌手的名字
     * @param page       查询的页数
     */
    public static String musicList(String searchName, String page) {
        int rn = 5;  // 默认每页歌曲数量
        String urlString = "https://kuwo.cn/api/www/search/searchMusicBykeyWord?" +
                "key=" + searchName + "&pn=" + page + "&rn=" + rn + "&httpsStatus=1&" +
                "reqId=f94cbc40-2488-11eb-bdad-1b8a24fee8b5";

//        System.out.println("urlString:" + urlString);
        Response response = null;
        String result = null;
        try {
            String token = Utils.getToken();  // 获取 token
            System.out.println("token:" + token);

            response = Jsoup.connect(urlString)
                    .cookie("kw_token", token)
                    .header("csrf", token)
                    .header("Referer", "http://www.kuwo.cn/search/list?key=%E5%91%A8%E6%9D%B0%E4%BC%A6")
                    .method(Connection.Method.GET)
                    .ignoreContentType(true)
                    .execute();

//            URL url = new URL(urlString);
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setRequestProperty("Cookie", "kw_token=" + token);
//            httpURLConnection.setRequestProperty("csrf", token);
//            httpURLConnection.setRequestProperty("Referer", "https://kuwo.cn/search/list?key=%E5%91%A8%E6%9D%B0%E4%BC%A6");
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
//            result = bufferedReader.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }

        assert response != null;
//        System.out.println("response.body():" + response.body());
//        System.out.println("result:" + result);
        return response.body();
//        return result;
    }

    /**
     * 对 歌曲的信息 进行解析
     *
     * @param musicListJson 歌曲的信息
     * @return 存放 music对象 的列表
     */
    public static List<Music> parseJson(String musicListJson) {
        //        对 JSON 数据进行解析
        JSONObject jsonObject = JSONObject.parseObject(musicListJson);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray listJson = data.getJSONArray("list");
        List<Music> list = new ArrayList<Music>();
        System.out.println("parseJson  start ");
        for (Object j : listJson) {
            JSONObject musicJson = (JSONObject) j;

            Music music = new Music(musicJson.getString("album"),
                    musicJson.getString("albumpic"), musicJson.getString("name"),
                    musicJson.getString("artist"), musicJson.getString("duration"),
                    Utils.get_url_by_rid(musicJson.getString("rid")));

            System.out.println(music.toString());
            list.add(music);
        }
        return list;
    }

    /**
     * 根据 rid 获取歌曲下载链接
     *
     * @param rid 歌曲对应的 rid
     * @return 歌曲下载链接
     */
    public static String get_url_by_rid(String rid) {
        String urlString = "http://kuwo.cn/url?format=mp3&rid=" + rid + "&response=url&type=convert_url3&br=320kmp3&from=web&t=1604991207945&httpsStatus=1&reqId=6fad66a1-2321-11eb-beba-c93a68b45841";
        BufferedReader bufferedReader = null;
        String result = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            result = bufferedReader.readLine();
            JSONObject jsonObject = JSONObject.parseObject(result);
            result = jsonObject.getString("url");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
//        System.out.println(musicList("周杰伦", 1));
        System.out.println("token:" + getToken());
    }
}
