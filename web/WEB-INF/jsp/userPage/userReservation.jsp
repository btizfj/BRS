<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fkjava" uri="/pager-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: XiaoMi
  Date: 2019/4/19
  Time: 20:37
  To change this template use File | Settings | File Templates.
  用户和理发师的“消息管理界面”
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>消息管理界面</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-light">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/welcome">欢迎登陆</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/messagePage">消息管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/reservationPage">预约管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#" style="color: #1f6f4a">我要预约</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/showBarber">查看理发师</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/logout">退出登录</a>
        </li>
    </ul>
</nav>
<br>

<div class="container">
    <h1 align="center" style="margin-top: 40px">欢迎预约！</h1>
    <div class="card">
        <div class="card-body">
            <form id= "uploadForm" action="${pageContext.request.contextPath}/submitOrderByParams" method="post">
                <div class="row" align="center">
                    <div class="col">
                        <h3>选择信息</h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label for="r_price">选择理发师:</label>
                        <select class="form-control" id="barber_id" name="barber_id">
                            <option value="-1">选择理发师</option>
                            <c:forEach items="${users}" var="user" varStatus="stat">
                                <option value="${user.id}">${user.b_name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label for="r_price">选择时间段:</label>
                        <select class="form-control" id="r_time" name="r_time">
                            <option value="-1">选择时间段</option>
                            <option value="0">8:00-10:00</option>
                            <option value="1">10:00-12:00</option>
                            <option value="2">14:00-16:00</option>
                            <option value="3">16:00-18:00</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="r_price">预约价格:</label>
                            <input type="number" class="form-control" id="r_price" name="r_price">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col" align="center">
                        <input type="submit" class="btn btn-info" value="提交">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
