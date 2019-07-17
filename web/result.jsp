<%--
  Created by IntelliJ IDEA.
  User: mot_a
  Date: 7/15/2019
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="position:absolute;left:500px;top:70px">
    <h3 align="center">Exam Result</h3>
    <table border=1>
        <tr>
            <td class="head">
                Exame Name :
            </td>
            <td>
                <span id="lblSubject">${sessionScope.examName}</span></td>
        </tr>
        <tr>
            <td class="head">
                No. of Answered Questions :
            </td>
            <td>
                <span id="lblNquestions">${sessionScope.TotalAnsweredQuestions} out of 15. </span></td>
        </tr>

        <tr>
            <td class="head">
                No. of correct answers :
            </td>
            <td>
                <span id="lblNcans">${sessionScope.correcAnswers}</span></td>
        </tr>

    </table>

    <c:if test="${sessionScope.correcAnswers >= 7}">
        <h3 align="center">Passed</h3>
    </c:if>
    <c:if test="${sessionScope.correcAnswers < 7}">
        <h3 align="center">Failed</h3>
    </c:if>
    <h3 align="center"><a href='home.jsp'>Back to HomePage</a></h3>
</div>

</body>
</html>
