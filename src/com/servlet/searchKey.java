package com.servlet;

import com.Utils.Utils;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于搜索框的联想搜索
 */
@WebServlet("/searchKey")
public class searchKey extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("value");
        String requestUrl = "https://kuwo.cn/api/www/search/searchKey?key=" + value + "&httpsStatus=1&reqId=91f026d0-26f5-11eb-a729-d3d9e252a503";
//        List<String> list = new ArrayList<String>();

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
                String[] split1 = split.split("SNUM");
                String[] split2 = split1[0].split("=");
                String s = split2[1].substring(0, split2[1].length() - 4);
//                list.add(s);
                jsonReturn.put(String.valueOf(i), s);
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
