<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP - city</title>
</head>
<body>
<nav style="text-decoration: none; display: flex; vertical-align: middle; padding: 10px 20px 10px 20px;">
    <ul style="display: inline-flex; list-style: none;	flex-wrap: wrap; align-items: center; justify-content: center">
        <li style="flex: 3"><span>STUDENTS</span> APP</li>
        <div style="padding: 0 5px; display: inline-flex;	font-weight: 200;">
            <li><a style="text-decoration: none;flex: 3" href="main">MAIN</a></li>
            <li><a style="text-decoration: none;flex: 3" href="student">STUDENTS</a></li>
            <li><a style="text-decoration: none;flex: 3" href="city">CITIES</a></li>
        </div>
    </ul>
</nav>
<main>
    <div style="text-align: center; margin:50px">
        <h2>List of cities:</h2>
        <hr>
        <c:choose>
            <c:when
                    test="${cities.size() == 0 || cities.size() == null}">
                <p>
                    <c:out value="No cities"/>
                </p>
                <hr>
            </c:when>
            <c:otherwise>
                <table style="border: grey; width: 70%; text-align: center; alignment: center; padding: 10px">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>name</th>
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