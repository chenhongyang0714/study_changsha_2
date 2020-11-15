<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/index.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/index.js"></script>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>音乐搜搜</title>
</head>

<body>
<p class="title">听音乐 好心情</p>
<div class="center-text">
    <form class="search_form" action="musicList" method="get">
        <label>
            <input type="text" class="input_text" id="input_text"
                   placeholder="搜索音乐/MV/歌单/歌手" name="searchName"
                   autocomplete="off" oninput="searchKey();" onfocus="suggest()">
        </label>
        <input type="submit" value="搜索一下" class="input_sub">
    </form>
    <div class="song_item">
        <ul id="ul">
            <!-- 动态添加数据 -->
        </ul>
    </div>
</div>

</body>
</html>