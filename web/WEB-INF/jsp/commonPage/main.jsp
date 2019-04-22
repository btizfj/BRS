<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>主界面</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="../js/login.js"></script>
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
        .my_btn {
            width: 100%;
            height: 50px;
            background: transparent;
            border: 1px solid #558FAA;
            border-radius: 3px;
            color: #BFD5DF;
        }
        .my_btn:hover {
            background: #40839F;
        }
    </style>
    <script language="JavaScript">
        function onClickAcccess() {
            window.open("${pageContext.request.contextPath}/login");
        }
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="row" id="grad" style="height: 650px">
        <div class="container-fluid" align="center">
            <div class="row">
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <h1 style="color: white;margin-top: 140px" align="center">理发店预约系统</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <h5 style="color: #B8D4D8;margin-top: 50px;margin-bottom: 50px" align="center">你就是最亮的仔！</h5>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <button type="button" class="my_btn" onclick="onClickAcccess()">登录注册</button>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <h5 style="color: #B8D4D8;margin-top: 50px;margin-bottom: 20px" align="center">版本号：1.0</h5>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <h1 style="color: #159957;margin-top: 30px">致谢</h1>
                        <hr style="color: green">
                        <h6 style="color: gray;margin-top: 20px;margin-bottom: 20px">感谢腾讯云服务器提供技术支持。</h6>
                        <h6 style="color: gray;margin-top: 20px;margin-bottom: 20px">感谢GitHub提供技术支持。</h6>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <h1 style="color: #159957;margin-top: 30px">联系作者</h1>
                        <hr style="color: green">
                        <h6 style="color: gray;margin-top: 20px;margin-bottom: 20px">邮箱：1490785540@qq.com</h6>
                        <h6 style="color: gray;margin-top: 20px;margin-bottom: 20px">电话：18580451667</h6>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <h1 style="color: #159957;margin-top: 30px">版权所有</h1>
                        <hr style="color: green">
                        <h6 style="color: gray;margin-top: 20px;margin-bottom: 20px">
                            此项目为本人的本科毕业设计，未经本人允许，不得参与以营利目的活动。</h6>
                        <h6 style="color: gray;margin-top: 20px;margin-bottom: 20px">项目已提交至GitHub：<a
                                class="text-primary"
                                href="https://github.com/btizfj/BRS">https://github.com/btizfj/BRS</a></h6>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>