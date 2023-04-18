<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="CSS/style.css"/>"/>
    <meta charset="UTF-8">
    <title>Read city</title>
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
<main>
    <body>
    <div>
        <h2>City</h2>
        <br>
        <c:choose>
            <c:when test="${city == null}">
                <p>
                    <c:out value="No cities"/>
                </p>
                <hr>
            </c:when>
            <c:otherwise>
                <div class="container">
                    <table>
                        <thead>
                        <tr>
                            <th>CITY ID</th>
                            <th>CITY NAME</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${city.getId()}</td>
                            <td>${city.getName()}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    </body>
</main>
<footer>
    <p>Author: Alexandr Petrovich
        <br>
        <a href="https://github.com/Petrovich-A/Student">github: Student App</a>
    </p>
</footer>
</body>
</html>