<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fkjava" uri="/pager-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: XiaoMi
  Date: 2019/4/19
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加理发师</title>
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
            <a class="nav-link" href="${pageContext.request.contextPath}/adminUserManagement">用户管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/adminBarberManagement">理发师管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/adminOrderManagement">订单管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#" style="color: #1f6f4a">添加理发师</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/logout">退出登录</a>
        </li>
    </ul>
</nav>
<br>

<div class="container">
    <h1 align="center" style="margin-top: 40px">添加理发师</h1>
    <div class="card">
        <div class="card-body">
            <form id= "uploadForm" action="${pageContext.request.contextPath}/addBarberToDB" method="post">
                <div class="row" align="center">
                    <div class="col">
                        <h3>填写信息</h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="username">用户名:</label>
                            <input type="text" class="form-control" id="username" name="username">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="password">密码:</label>
                            <input type="text" class="form-control" id="password" name="password">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="b_name">理发师姓名:</label>
                            <input type="text" class="form-control" id="b_name" name="b_name">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label for="usertype">用户类型:</label>
                        <select class="form-control" id="usertype" name="usertype">
                            <option value="-1">选择类型</option>
                            <option value="0">用户</option>
                            <option value="1">理发师</option>
                            <option value="2">管理员</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="phonenumber">电话号码:</label>
                            <input type="number" class="form-control" id="phonenumber" name="phonenumber">
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
