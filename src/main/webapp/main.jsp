<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--<%@ page import="by.petrovich.student.model.Student" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>main page</title>
</head>
<body>
<main>
    <section>
        <p>The str is: "${str}"</p>
        <hr>
        <h2>List:</h2>
        <c:choose>
            <c:when
                    test="${students.size() == 0 || students.size() == null}">
                <p>
                    <c:out value="No students"/>
                </p>
                <hr>
            </c:when>
            <c:otherwise>
                <table>
                    <col width="30">
                    <col width="30">
                    <col width="50">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>first_name</th>
                        <th>last_name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="students" items="${students}" begin="0"
                               end="20">
                        <tr>
                            <td>${students.getId()}</td>
                            <td>${students.getFirstName()}</td>
                            <td>${students.getLastName()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </section>
</main>
<footer>
    <div></div>
</footer>
</body>
</html>