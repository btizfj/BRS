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
            <a class="nav-link" href="#" style="color: #1f6f4a">消息管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/reservationPage">预约管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/userReservation">我要预约</a>
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
    <div class="row" style="margin-top: 10px">
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>内容</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${messages}" var="message" varStatus="stat">
                    <tr>
                        <td>${stat.index+1}</td>
                        <td>${message.content}</td>
                        <td><a href="${pageContext.request.contextPath}/deleteMessageById?id=${message.id}" class="text-primary">删除</a></td>
                    </tr>
                </c:forEach>
                <!-- 分页标签 -->
                <tr valign="top">
                    <td align="center" colspan="12" rowspan="2">
                        <fkjava:pager
                                pageIndex="${requestScope.pageModel.pageIndex}"
                                pageSize="${requestScope.pageModel.pageSize}"
                                recordCount="${requestScope.pageModel.recordCount}"
                                submitUrl="${pageContext.request.contextPath}/messagePage?pageIndex={0}"/>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
