<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>
    <style>
        body {
            background: url("<%=contextPath%>/assets/img/backgrounds/1.jpg");
        }
    </style>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>点名系统教师界面</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="<%=contextPath%>/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=contextPath%>/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=contextPath%>/assets/css/form-elements.css">
    <link rel="stylesheet" href="<%=contextPath%>/assets/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="<%=contextPath%>/assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="<%=contextPath%>/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="<%=contextPath%>/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72"
          href="<%=contextPath%>/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="<%=contextPath%>/assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top menu -->
<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">Bootstrap Multi Step Registration Form Template</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="top-navbar-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
							<span class="li-text">
								Put some text or
							</span>
                    <a href="#"><strong>links</strong></a>
                    <span class="li-text">
								here, or some icons:
							</span>
                    <span class="li-social">
								<a href="#"><i class="fa fa-facebook"></i></a>
								<a href="#"><i class="fa fa-twitter"></i></a>
								<a href="#"><i class="fa fa-envelope"></i></a>
								<a href="#"><i class="fa fa-skype"></i></a>
                                <a href="/teacher/logout" class="btn btn-danger">退出登录</a>

							</span>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>${sessionScope.user}</strong> 老师请假管理界面</h1>
                    <div class="description">
                        <p>
                            点击下方按钮进行请假的管理
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">

                    <fieldset>

                        <a href="/teacher/callName?teacher=${sessionScope.user}" class="btn btn-success">点名系统
                        </a>


                    </fieldset>


                </div>

            </div>

            <br>
            <br>
            <div class="row">
                <table class="table">
                    <tr bgcolor="#f0f8ff">
                        <td>编号</td>
                        <td>上课时间</td>
                        <td>课程名</td>
                        <td>请假原因</td>
                        <td>学生</td>
                        <td>是否同意</td>
                        <td>操作</td>
                    </tr>
                    <c:if test="${requestScope.leaveList != null}">
                        <c:forEach items="${requestScope.leaveList}" var="leaveList">
                            <tr bgcolor="#f0f8ff">
                                <td>${leaveList.id}</td>
                                <td>${leaveList.take_time}</td>
                                <td>${leaveList.courseName}</td>
                                <td>${leaveList.reason}</td>
                                <td>${leaveList.studentName}</td>
                                <td>${leaveList.isAgree}</td>
                                <td>
                                    <button type="button"  class="btn btn-default agree">同意</button>
                                    <button type="button"  class="btn btn-default denied">不同意</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>

            </div>

        </div>
    </div>
</div>

</div>
More Templates <a href="http://www.cssmoban.com/" target="_blank" title="IFOX">IFOX</a> - Collect from <a
        href="http://www.cssmoban.com/" title="IFOX" target="_blank">IFOX</a>

<!-- Javascript -->
<script src="<%=contextPath%>/assets/js/jquery-1.11.1.js"></script>
<script src="<%=contextPath%>/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=contextPath%>/assets/js/jquery.backstretch.min.js"></script>
<script src="<%=contextPath%>/assets/js/retina-1.1.0.min.js"></script>
<script src="<%=contextPath%>/assets/js/scripts.js"></script>


<script>
    $(".agree").click(function () {
        let id = $(this).parent().parent().children(":first").text();
        let status = "1";
        $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"/teacher/updateLeaveRecord",
            //提交的数据
             data:{id:id,status:status},
            //返回数据的格式
            dataType: "json",//"xml", "html", "script", "json", "jsonp", "text".
            success:function(data) {
                alert("操作成功");
                window.location.reload();
            },
            error: function(){
                //请求出错处理
                alert("请求出错");
            }
        });
    });
    $(".denied").click(function () {
        let status = "2";
        let id = $(this).parent().parent().children(":first").text();
        $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"/teacher/updateLeaveRecord",
            //提交的数据
            data:{id:id,status:status},
            //返回数据的格式
            dataType: "json",//"xml", "html", "script", "json", "jsonp", "text".
            success:function(data) {
                alert("操作成功");
                window.location.reload();

            },
            error: function(){
                //请求出错处理
                alert("请求出错");
            }
        });
    });
</script>

</body>

</html>