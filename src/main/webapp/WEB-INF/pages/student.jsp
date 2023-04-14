<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="CSS/style.css"/>"/>
    <meta charset="UTF-8">
    <title>JSP - student</title>
</head>
<body>
<nav>
    <ul>
        <li class="logo"><span>STUDENT</span> APP</li>
        <div class="items">
            <li><a href="main">MAIN</a></li>
            <li><a href="student">STUDENTS</a></li>
            <li><a href="city">CITIES</a></li>
        </div>
    </ul>
</nav>
<main>
    <div class="table">
        <h2>List of students:</h2>
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
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>STUDENT FIRST NAME</th>
                        <th>STUDENT LAST NAME</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="students" items="${students}">
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
    </div>
</main>
<footer>
    <div></div>
</footer>
</body>
</html>