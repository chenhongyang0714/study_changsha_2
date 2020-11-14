<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>搜搜</title>
    <style>
        .center-text {
            text-align: center;
            position: absolute;
            top: 0;
            bottom: 0;
            left: 260px;
            right: 0;
            width: 50%;
            height: 30%;
            margin: auto;
        }

        .search_form {
            width: 602px;
            height: 42px;
        }

        /*左边输入框设置样式*/
        .input_text {
            width: 400px;
            height: 40px;
            border: 1px solid green;
            /*清除掉默认的padding*/
            padding: 0;

            /*提示字首行缩进*/
            text-indent: 10px;

            /*去掉蓝色高亮框*/
            outline: none;

            /*用浮动解决内联元素错位及小间距的问题*/
            float: left;
        }

        .input_sub {
            width: 100px;
            height: 40px;
            background: green;
            /*去掉submit按钮默认边框*/
            border: 0;
            /*改成右浮动也是可以的*/
            float: left;
            color: white; /*搜索的字体颜色为白色*/
            cursor: pointer; /*鼠标变为小手*/
        }

        .title {
            width: 300px;
            height: 200px;
            position: absolute;
            left: 50%;
            top: 100px;
            margin-left: -150px;
            background-image: -webkit-linear-gradient(left, blue, #66ffff 10%, #cc00ff 20%, #CC00CC 30%, #CCCCFF 40%, #00FFFF 50%, #CCCCFF 60%, #CC00CC 70%, #CC00FF 80%, #66FFFF 90%, blue 100%);
            -webkit-text-fill-color: transparent; /* 将字体设置成透明色 */
            -webkit-background-clip: text; /* 裁剪背景图，使文字作为裁剪区域向外裁剪 */
            -webkit-background-size: 200% 100%;
            -webkit-animation: masked-animation 4s linear infinite;
            font-size: 35px;
        }

        @keyframes masked-animation {
            0% {
                background-position: 0 0;
            }
            100% {
                background-position: -100% 0;
            }
        }
    </style>
</head>
<body>
<p class="title">听音乐 好心情</p>
<div class="center-text">
    <form class="search_form" action="musicList" method="get">
        <input type="text" class="input_text" placeholder="搜索音乐/MV/歌单/歌手" name="searchName">
        <input type="submit" value="搜索一下" class="input_sub">
    </form>
</div>

</body>
</html>