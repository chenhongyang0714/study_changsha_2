package com.servlet;

import com.Utils.Utils;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.io.PrintWriter;
import org.jsoup.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/suggest")
public class suggest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestUrl = "https://kuwo.cn/api/www/search/searchKey?key=&httpsStatus=1&reqId=21da97f0-2721-11eb-bd92-5755b40fda07";

//        用于响应
        resp.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
        resp.setCharacterEncoding("UTF-8");// setContentType与setCharacterEncoding的顺序不能调换，否则无法解决中文乱码的问题
        PrintWriter write = resp.getWriter();
        JSONObject jsonReturn = new JSONObject();

        try {
            String token = Utils.getToken();
            Connection.Response response = Jsoup.connect(requestUrl)
                    .cookie("kw_token", token)
                    .header("csrf", token)
                    .header("Referer", "https://kuwo.cn/")
                    .method(Connection.Method.GET)
                    .ignoreContentType(true)
                    .execute();

            /* 解析请求结果 */
            JSONObject jsonObject = JSONObject.parseObject(response.body());
            String data = jsonObject.get("data").toString();
            data = data.replace("[", "");
            data = data.replace("]", "");
            String[] splits = data.split(",");

            int i = 0;
            for (String split : splits) {
                split = split.substring(1, split.length() - 1);
//                System.out.println(split);
                jsonReturn.put(String.valueOf(i), split);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 响应
        write.print(jsonReturn);
        write.flush();
        write.close();
    }
}
