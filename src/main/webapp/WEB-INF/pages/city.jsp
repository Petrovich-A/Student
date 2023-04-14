<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="CSS/style.css"/>"/>
    <meta charset="UTF-8">
    <title>JSP - city</title>
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
        <h2>List of cities:</h2>
        <c:choose>
            <c:when
                    test="${cities.size() == 0 || cities.size() == null}">
                <p>
                    <c:out value="No cities"/>
                </p>
                <hr>
            </c:when>
            <c:otherwise>
                <table>
                    <thead>
                    <tr>
                        <th>CITY ID</th>
                        <th>CITY NAME</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="cities" items="${cities}">
                        <tr>
                            <td>${cities.getId()}</td>
                            <td>${cities.getName()}</td>
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