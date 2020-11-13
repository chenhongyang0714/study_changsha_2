<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>搜搜</title>
</head>
<style>
  .center-text {
    text-align: center;
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    width: 50%;
    height: 30%;
    margin: auto;
  }
</style>
<body>
<div class="center-text">
  <form action="musicList" method="get">
    <input type="text" name="searchName" />
    <input type="submit" value="Submit" />
  </form>
</div>
</body>
</html>
