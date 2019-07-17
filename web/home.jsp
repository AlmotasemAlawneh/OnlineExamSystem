<%--
  Created by IntelliJ IDEA.
  User: mot_a
  Date: 7/13/2019
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>WAP Online Exam</title>


</head>
<jsp:include page="header.jsp" ></jsp:include>
<div style="position:absolute;top:70px;left:1100px;">
    <img  width="100" style="border-radius: 50%;border: 5px solid white;background-color: snow;position: relative;
    top: -68px;" src="/images/user.png"/>
    <span style="
    top: -45px;
    position: relative;
    right: 74px;
">${sessionScope.user.username}</span>
</div>

<div style="position:absolute;top:70px;left:1300px;">
     <a class="button" style="vertical-align:middle;position: relative;
    top: -68px;" href='${pageContext.request.contextPath}/logout'><span>Logout</span></a>
</div>

<div style="
    left: 30%;
    margin: auto;
    top: 40%;
    position: relative;

">
${sessionScope.availableTests}
</div>

</body>
</html>