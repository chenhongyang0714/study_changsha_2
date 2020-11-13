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

@WebServlet("/musicList")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchName = req.getParameter("searchName");
        String page = req.getParameter("page");
        System.out.println("page:" + page);
        if(page==null) {
            page = "1";
        }
        System.out.println(searchName);
//        System.out.println(page);

        String musicListJson = Utils.musicList(searchName, page);
//        System.out.println("----------------------");
//        System.out.println("musicListJson:" + musicListJson);

        List<Music> musicList = Utils.parseJson(musicListJson);

        System.out.println("解析完毕!");
        req.setAttribute("musicList", musicList);
        req.setAttribute("page", page);
        req.setAttribute("searchName", searchName);

        req.getRequestDispatcher("musicList.jsp").forward(req, resp);

    }
}
