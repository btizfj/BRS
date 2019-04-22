<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <title>注册界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <style type="text/css">
        #grad {
            background: -webkit-linear-gradient(left, #155997, #15925E); /* Safari 5.1 - 6.0 */
            background: -o-linear-gradient(right, #155997, #15925E); /* Opera 11.1 - 12.0 */
            background: -moz-linear-gradient(right, #155997, #15925E); /* Firefox 3.6 - 15 */
            background: linear-gradient(to right, #155997, #15925E); /* 标准的语法（必须放在最后） */
        }
    </style>
</head>

<body id="grad">
<div class="login-wrapper open dowebok">
    <form action="${pageContext.request.contextPath}/registerAccount" method="post">
    <div class="login-left">
        <img src="${pageContext.request.contextPath}/images/bg-login.png">
    </div>
    <div class="login-right">
        <div class="h2">注册</div>
        <div class="form-group">
            <input type="text" id="username" name="username" placeholder="用户名">
            <label for="username">用户名</label>
        </div>
        <div class="form-group">
            <input type="text" id="email" name="email" placeholder="邮箱">
            <label for="Email">邮箱</label>
        </div>
        <div class="form-group">
            <input type="password" id="password" name="password" placeholder="密码">
            <label for="Password">密码</label>
        </div>
        <div class="checkbox-container">
            <input type="checkbox" id="agree">
            <div class="text-checkbox"><label for="agree">同意注册协议</label></div>
        </div>
        <div class="button-area">
            <button class="btn btn-secondary" style="visibility: collapse">登录</button>
            <button class="btn btn-primary" type="submit">注册</button>
        </div>
    </div>
    </form>
</div>
</body>
</html>