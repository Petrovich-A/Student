<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="CSS/style.css"/>"/>
    <meta charset="UTF-8">
    <title>Student read</title>
</head>
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
<body>
<main>
    <div>
        <h2>Student info:</h2>
        <br>
        <c:choose>
            <c:when
                    test="${student == null}">
                <p>
                    <c:out value="No students"/>
                </p>
                <hr>
            </c:when>
            <c:otherwise>
                <div class="container">
                    <table>
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>STUDENT FIRST NAME</th>
                            <th>STUDENT LAST NAME</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${student.getId()}</td>
                            <td>${student.getFirstName()}</td>
                            <td>${student.getLastName()}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</main>
<footer>
    <div></div>
</footer>
</body>
</html>