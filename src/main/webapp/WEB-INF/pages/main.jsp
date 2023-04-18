<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="CSS/style.css"/>"/>
    <meta charset="UTF-8">
    <title>JSP - Hello student</title>
</head>
<nav>
    <ul>
        <li class="logo"><span>STUDENT</span> APP &#128102</li>
        <div class="items">
            <li><a href="main">MAIN</a></li>
            <li><a href="student">STUDENTS</a></li>
            <li><a href="city">CITIES</a></li>
        </div>
    </ul>
</nav>
<body>
<br/>
<h1>Hello Student app!</h1>
<br/>
<main>
    <c:choose>
        <c:when
                test="${studentWithCityDto.size() == 0 || studentWithCityDto.size() == null}">
            <p>
                <c:out value="No studentWithCityDto"/>
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
                        <th>CITY ID</th>
                        <th>CITY NAME</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="studentWithCityDto" items="${studentWithCityDto}">
                        <tr>
                            <td>${studentWithCityDto.getStudentId()}</td>
                            <td>${studentWithCityDto.getStudentFirstName()}</td>
                            <td>${studentWithCityDto.getStudentLastName()}</td>
                            <td>${studentWithCityDto.getCityId()}</td>
                            <td>${studentWithCityDto.getCityName()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
</main>
<footer>
    <p>Author: Alexandr Petrovich
        <br>
        <a href="https://github.com/Petrovich-A/Student">github: Student App</a>
    </p>
</footer>
</body>
</html>