<%--
  Created by IntelliJ IDEA.
  User: mot_a
  Date: 7/14/2019
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="/css/styles.css">
    <title>Insert title here</title>
</head>
<body>
<script>
    function startTheExam() {

        location.href='${pageContext.request.contextPath}/test.jsp';
    }
</script>
<br><br><br>
<h2 align="center">Instruction for The ${exameTitle} : </h2>

<div style="border: 4px solid #217480;">
    <p><strong>Steps For Accessing Your Exam Online:</strong></p>
    <ul style="list-style-type:disc">
        <li>Close all programs, including email</li>
        <li>To begin the exam, click on the Start Exam<.</li>
        <li>You can change your answers before submitting</li>
    </ul>
    <br><br>
    <p><br>
        <strong>Before starting the exam:</strong></p>
        <p>Please verify that the student's last name appears correctly within the User ID box.</p>
    <ul>
        <li>The student may not use his or her textbook, course notes, or receive help from a proctor&nbsp;or any other outside source.</li>
        <li>Students must complete minimum 7 correct questions out of 15-question multiple-choice exam within the 20-minute time frame allotted for the exam.</li>
        <li>Students must not stop the session and then return to it.</li>
    </ul>
    <br>

    <strong>Good luck for the Exam</strong></p>
</div>


    <button class="button" onclick="startTheExam()">Start Exam</button>


</body>
</html>
