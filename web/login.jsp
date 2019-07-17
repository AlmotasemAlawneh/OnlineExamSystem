<%--
  Created by IntelliJ IDEA.
  User: mot_a
  Date: 7/14/2019
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>WAP Online Exam</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">

</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <jsp:include page="header.jsp" ></jsp:include>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-4" style="padding-top: 100px;">


            <div style="color: red">
                <c:if test='${errorMessage != null}'>
                    <h3 align="center">${errorMessage}</h3>
                    ${errorMessage=null}
                </c:if>

            </div>
            <div>

                <form name="login-form" class="login-form" action="login" method="post">

                    <div class="header">
                        <h1>Login </h1>
                        <span></span>
                    </div>

                    <div class="content">
                        <input name="username" type="text" class="input username" placeholder="Username" />
                        <div class="user-icon"></div></br>
                        <input name="password" type="password" class="input password" placeholder="Password" />
                        <div class="pass-icon"></div>
                    </div>

                    <div class="footer">
                        <input type="submit" name="submit" value="Login" class="button" />

                    </div>

                </form>

            </div>
        </div>
        <div class="col-md-4">
        </div>
    </div>
</div>

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/scripts.js"></script>
</body>
</html>

