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
        <li class="logo"><span>STUDENT</span> APP &#128102 </li>
        <div class="items">
            <li><a href="main">MAIN</a></li>
            <li><a href="redirect-to-student-page">STUDENTS</a></li>
            <li><a href="redirect-to-city-page">CITIES</a></li>
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
                            <th>FIRST NAME</th>
                            <th>LAST NAME</th>
                            <th>CITY</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${student.getFirstName()}</td>
                            <td>${student.getLastName()}</td>
                            <td>${student.getCity().getName()}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</main>
<footer>
    <p>Author: Alexandr Petrovich
        <br>
        <a href="https://github.com/Petrovich-A/Student">github: Student App</a>
    </p>
</footer>
</body>
</html>