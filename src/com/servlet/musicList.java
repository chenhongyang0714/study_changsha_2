package com.servlet;

import java.util.List;

import com.Utils.Utils;
import com.study.vo.Music;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取音乐列表
 */
@WebServlet("/musicList")
public class musicList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchName = req.getParameter("searchName");
        String page = req.getParameter("page");

        // 如果 searchName==null, 则重新请求 index.jsp
        if ("".equals(searchName)) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {

//          如果没有显式的请求第几页的数据,则默认请求第一页
            if (page == null) {
                page = "1";
            }

            System.out.println("searchName:" + searchName);
            System.out.println("page:" + page);

            String musicListJson = Utils.musicList(searchName, page);
            System.out.println("musicListJson:" + musicListJson);

            List<Music> musicList = Utils.parseJson(musicListJson);

            System.out.println("解析完毕!");
            req.setAttribute("musicList", musicList);
            req.setAttribute("page", page);
            req.setAttribute("searchName", searchName);

            req.getRequestDispatcher("musicList.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
