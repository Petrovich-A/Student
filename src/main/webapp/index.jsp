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
        <li class="logo"><span>STUDENT</span> APP</li>
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
                test="${studentWithCity.size() == 0 || studentWithCity.size() == null}">
            <p>
                <c:out value="No studentWithCity"/>
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
                    <c:forEach var="studentWithCity" items="${studentWithCity}">
                        <tr>
                            <td>${studentWithCity.getStudentId()}</td>
                            <td>${studentWithCity.getStudentFirstName()}</td>
                            <td>${studentWithCity.getStudentLastName()}</td>
                            <td>${studentWithCity.getCityId()}</td>
                            <td>${studentWithCity.getCityName()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
</main>
</body>
</html>