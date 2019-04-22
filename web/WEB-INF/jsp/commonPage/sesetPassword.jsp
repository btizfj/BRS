<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <title>修改密码</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
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
<div class="container">
    <h1 align="center" style="color: white;margin-top: 80px;margin-bottom: 40px">修改密码</h1>
    <div class="card">
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/resetPassword">
                <div class="form-group">
                    <label for="username">用户名:</label>
                    <input id="username" name="username" placeholder="用户名" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="oldpassword">旧密码:</label>
                    <input id="oldpassword" name="oldpassword" placeholder="旧密码" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="newpassword">新密码:</label>
                    <input id="newpassword" name="newpassword" placeholder="新密码" type="text" class="form-control">
                </div>
                <div align="center">
                    <input type="submit" value="确认修改">
                </div>
            </form>
        </div>
    </div>

</div>

</body>

</html>