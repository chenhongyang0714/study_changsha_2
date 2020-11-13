<%@ page import="com.study.vo.Music" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>歌曲清单展示</title>
</head>
<body>
<%
    ArrayList<Music> list = null;
    if (request.getAttribute("musicList") != null) {
        list = (ArrayList) request.getAttribute("musicList");
    }
%>
<table align="center">
    <tr>
        <th>歌曲名</th>
        <th>专辑名</th>
        <th>歌手名</th>
        <th>歌曲时长</th>
        <th>专辑图片</th>
    </tr>
    <% if (list != null) {
        for (Music music : list) {
    %>
    <tr align="center">
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
            <audio src="<%=music.getPlayUrl()%>" controls="controls"></audio>
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
