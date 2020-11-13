<%@ page import="com.study.vo.Music" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=request.getAttribute("searchName")%>的歌单</title>
</head>

<style type="text/css">
    table.hovertable {
        font-family: verdana, arial, sans-serif;
        font-size: 11px;
        color: #333333;
        border-width: 1px;
        border-color: #999999;
        border-collapse: collapse;
    }

    table.hovertable th {
        background-color: #c3dde0;
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #a9c6c9;
    }

    table.hovertable tr {
        background-color: #d4e3e5;
    }

    table.hovertable td {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #a9c6c9;
    }
</style>
<body>

<%
    ArrayList<Music> list = null;
    if (request.getAttribute("musicList") != null) {
        list = (ArrayList) request.getAttribute("musicList");
    }
%>
<table align="center" class="hovertable">
    <tr>
        <th>歌曲名</th>
        <th>专辑名</th>
        <th>歌手名</th>
        <th>歌曲时长</th>
        <th>专辑图片</th>
        <th>播放区域</th>
    </tr>
    <% if (list != null) {
        for (Music music : list) {
    %>
    <tr align="center" onmouseover="this.style.backgroundColor='#d4d3e5';"
        onmouseout="this.style.backgroundColor='#d4e3e5';">
        <td align="center"><%=music.getName()%>
        </td>
        <td align="center"><%=music.getAlbum()%>
        </td>
        <td align="center"><%=music.getArtist()%>
        </td>
        <td align="center"><%=music.getDuration()%>
        </td>
        <td align="center"><img src="<%=music.getAlbumpic()%>" width="100px" height="100px"/></td>
        <td align="center">
            <audio src="<%=music.getPlayUrl()%>" controls="controls" style="width: 280px"></audio>
        </td>
    </tr>
    <%
            }
        }
    %>

    <tr>
        <td colspan="6" align="center">
            <%
                int pageNum = Integer.parseInt(request.getAttribute("page").toString());
                if (pageNum > 1) {
            %>
            <a href="musicList?page=<%=pageNum-1%>&searchName=<%=request.getAttribute("searchName") %>">上一页</a>
            <%
            } else {
            %>
            <a href="#">上一页</a>
            <%
                }
            %>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="musicList?page=<%=pageNum+1%>&searchName=<%=request.getAttribute("searchName") %>">下一页</a>
        </td>
    </tr>

</table>
</body>
</html>
