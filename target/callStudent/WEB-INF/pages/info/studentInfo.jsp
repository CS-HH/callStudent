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
    <title>点名系统管理员界面</title>

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
                                <a href="/admin/logout" class="btn btn-danger">退出登录</a>
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
                    <h1><strong>${sessionScope.user}</strong> 信息添加界面</h1>
                    <div class="description">
                        <p>
                            点击下方六个按钮进行信息的管理
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">

                    <fieldset>


                        <button type="button" class="btn btn-default" data-toggle="modal"
                                data-target=".bs-example-modal-md">学生信息添加
                        </button>
                        <button type="button" class="btn btn-warning" data-toggle="modal"
                                data-target=".bs-example3-modal-md">教师信息添加
                        </button>
                        <button type="button" class="btn btn-warning" data-toggle="modal"
                                data-target=".bs-example2-modal-md" id="course">课程信息添加
                        </button>

                        <div class="modal fade bs-example-modal-md" tabindex="-1" role="dialog"
                             aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-md" role="document">
                                <div class="modal-content">

                                    <br>
                                    <form action="/admin/addStudent" method="post" class="form-horizontal"
                                          id="insertStudent">

                                        <br>
                                        <div class="form-group">
                                            <label for="name" class="col-md-3 control-label">姓名</label>
                                            <div class="col-md-6">
                                                <input type="text" name="name" id="name" class="form-control input-sm">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="number" class="col-md-3 control-label">学号</label>
                                            <div class="col-md-6">
                                                <input type="number" name="number" id="number"
                                                       class="form-control input-sm">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label for="clazz" class="col-md-3 control-label">班级</label>
                                            <div class="col-md-6">
                                                <input type="text" name="clazz" id="clazz" class="form-control">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="password" class="col-md-3 control-label">密码</label>
                                            <div class="col-md-6">
                                                <input type="password" name="password" id="password"
                                                       class="form-control">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <div class="col-md-5 col-md-offset-3">
                                                <button type="submit" class="btn btn-success ">提交</button>
                                                <button type="reset" class="btn btn-success">重置</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>


                        <div class="modal fade bs-example3-modal-md" tabindex="-1" role="dialog"
                             aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-md" role="document">
                                <div class="modal-content">
                                    <br>
                                    <form action="/admin/addTeacher" method="post" class="form-horizontal"
                                          id="insertTeacher">
                                        <div class="form-group">
                                            <label for="name" class="col-md-3 control-label">姓名</label>
                                            <div class="col-md-6">
                                                <input type="text" name="name" class="form-control input-sm">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="account" class="col-md-3 control-label">账号</label>
                                            <div class="col-md-6">
                                                <input type="text" name="account" id="account" class="form-control">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="password" class="col-md-3 control-label">密码</label>
                                            <div class="col-md-6">
                                                <input type="password" name="password" class="form-control">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <div class="col-md-5 col-md-offset-3">
                                                <button type="submit" class="btn btn-success ">提交</button>
                                                <button type="reset" class="btn btn-success">重置</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>


                        <div class="modal fade bs-example2-modal-md" tabindex="-1" role="dialog"
                             aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-md" role="document">
                                <div class="modal-content">

                                    <br>
                                    <form action="/admin/addCourse" method="post" class="form-horizontal" id="insertCourse">

                                        <div class="form-group">
                                            <label for="name" class="col-md-3 control-label">课程名</label>
                                            <div class="col-md-6">
                                                <input type="text" name="name" class="form-control input-sm">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="take_time" class="col-md-3 control-label">上课时间</label>
                                            <div class="col-md-6">
                                                <input type="date" name="take_time" id="take_time" class="form-control input-sm">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label for="teacherId" class="col-md-3 control-label">任课教师</label>
                                            <div class="col-md-6">
                                                <select class="form-control" id="teacherId" name="teacherId">

                                                </select>
                                            </div>
                                        </div>



                                        <div class="form-group">
                                            <div class="col-md-5 col-md-offset-3">
                                                <button type="submit" class="btn btn-success ">提交</button>
                                                <button type="reset" class="btn btn-success">重置</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="modal fade bs-example4-modal-md" tabindex="-1" role="dialog"
                             aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-md" role="document">
                                <div class="modal-content">

                                    <br>
                                    <form action="/admin/updateStudent" method="post" class="form-horizontal" id="updateStudent">

                                        <div class="form-group">
                                            <div class="col-md-6">
                                                <input type="hidden" name="id" id="updateId" class="form-control input-sm">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="name" class="col-md-3 control-label">学生名</label>
                                            <div class="col-md-6">
                                                <input type="text" name="name" id="updateName" class="form-control input-sm">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="number" class="col-md-3 control-label">学号</label>
                                            <div class="col-md-6">
                                                <input type="number" name="number" id="updateNumber" class="form-control input-sm">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label for="clazz" class="col-md-3 control-label">班级</label>
                                            <div class="col-md-6">
                                                <input type="text" name="clazz" id="updateClazz" class="form-control input-sm">
                                            </div>
                                        </div>



                                        <div class="form-group">
                                            <div class="col-md-5 col-md-offset-3">
                                                <button type="submit" class="btn btn-success ">提交</button>
                                                <button type="reset" class="btn btn-success">重置</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>



                        <br>
                        <br>
                        <a href="/admin/queryStudent" class="btn btn-warning">学生信息查看
                        </a>
                        <a href="/admin/queryTeachers" class="btn btn-warning">教师信息查看
                        </a>
                        <a href="/admin/queryCourse" class="btn btn-warning">课程信息查看
                        </a>
                        <br>
                        <br>
                        <button type="button" class="btn btn-success" data-toggle="modal"
                                data-target=".bs-example5-modal-md" id="audioUpload">点名音频上传</button>
                        <div class="modal fade bs-example5-modal-md" tabindex="-1" role="dialog"
                             aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-md" role="document">
                                <div class="modal-content">

                                    <br>
                                    <form action="/admin/addAudio" method="post" class="form-horizontal" id="insertAudio" enctype="multipart/form-data">


                                        <div class="form-group">
                                            <label for="teacher" class="col-md-3 control-label">任课教师</label>
                                            <div class="col-md-6">
                                                <select class="form-control" id="teacher" name="teacher">

                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="file" class="col-md-3 control-label">选择音频</label>
                                            <div class="col-md-6">
                                                <input type="file" name="file" id="file" class="form-control input-sm">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <div class="col-md-5 col-md-offset-3">
                                                <button type="submit" class="btn btn-success ">提交</button>
                                                <button type="reset" class="btn btn-success">重置</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>


                    </fieldset>


                </div>

            </div>

            <br>
            <br>
            <div class="row">
                <table class="table">
                   <tr bgcolor="#f0f8ff">
                       <td>编号</td>
                       <td>姓名</td>
                       <td>学号</td>
                       <td>班级</td>
                       <td>操作</td>
                   </tr>
                    <c:if test="${requestScope.studentList != null}">
                        <c:forEach items="${requestScope.studentList}" var="student">
                            <tr bgcolor="#f0f8ff">
                                <td>${student.id}</td>
                                <td>${student.name}</td>
                                <td>${student.number}</td>
                                <td>${student.clazz}</td>
                                <td>
                                    <button type="button" class="btn btn-default updateTr"  data-toggle="modal"
                                            data-target=".bs-example4-modal-md " >修改</button>

                                    <button type="button" class="btn btn-default deleteTr" >删除</button>
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
    $(".deleteTr").click(function () {
        let id =$(this).parent().parent().children(":first").text();
        $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"/admin/deleteStudent",
            //提交的数据
            data:{id:id},
            //返回数据的格式
            dataType: "text",//"xml", "html", "script", "json", "jsonp", "text".
            success:function(data) {
                if (data === "200"){
                    $(this).parent('td').parent('tr').remove();
                    window.location.reload();
                }
            },
            error: function(){
                //请求出错处理
                alert("请求出错");
            }
        });
    });

    $(".updateTr").click(function () {
        let id = $(this).parent().parent().children(":first").text();
        let name = $(this).parent().parent().children("td").eq(1).text();
        let number = $(this).parent().parent().children("td").eq(2).text();
        let clazz = $(this).parent().parent().children("td").eq(3).text();


        $("#updateId").val(id);
        $("#updateName").val(name);
        $("#updateNumber").val(number);
        $("#updateClazz").val(clazz);
    });
    $("#course").click(function () {
        $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"/admin/queryTeacher",
            //提交的数据
            // data:{name:name},
            //返回数据的格式
            dataType: "json",//"xml", "html", "script", "json", "jsonp", "text".
            success:function(data) {
                let str = "";
                for (let i = 0; i < data.length; i++) {
                    let id = data[i].id;
                    let name = data[i].name;
                    str = str + "<option value=" + id + ">" + name + "</option>";
                }
                document.getElementById("teacherId").innerHTML = str;//第一种加载js方法
            },
            error: function(){
                //请求出错处理
                alert("请求出错");
            }
        });
    });
    $("#audioUpload").click(function () {
        $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"/admin/queryTeacher",
            //提交的数据
            // data:{name:name},
            //返回数据的格式
            dataType: "json",//"xml", "html", "script", "json", "jsonp", "text".
            success:function(data) {
                let str = "";
                for (let i = 0; i < data.length; i++) {
                    let id = data[i].id;
                    let name = data[i].name;
                    str = str + "<option value=" + id + ">" + name + "</option>";
                }
                document.getElementById("teacher").innerHTML = str;//第一种加载js方法
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