<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="CSS/style.css"/>"/>
    <meta charset="UTF-8">
    <title>Update city JSP</title>
</head>
<nav>
    <ul>
        <li class="logo"><span>STUDENT</span> APP &#128102</li>
        <div class="items">
            <li><a href="go-to-main-page">MAIN</a></li>
            <li><a href="go-to-student-page">STUDENTS</a></li>
            <li><a href="go-to-city-page">CITIES</a></li>
        </div>
    </ul>
</nav>
<body>
<main>
    <div>
        <h2>Update city: </h2>
        <br>
        <c:choose>
        <c:when test="${cityId == null} || ${cityName == null}">
            <p>
                <c:out value="No parametrs"/>
            </p>
            <hr>
        </c:when>
        <c:otherwise>
        <div class="container">
            <form action="city-controller" method="POST">
                <div class="form">
                    <li>
                        <label>NAME:</label>
                        <input type="text"
                               placeholder="insert new city name"
                               name="updatedCityName"
                               value="${cityName}"
                               pattern="^[a-zA-Zа-яА-Я]{1,15}[-|\s]?[a-zA-Zа-яА-Я]{1,15}$"
                               title="Must contain latin and cyrillic uppercase or lowercase letters. Optionally may contain
                               only one dash or space symbols. The total length of string is from 2 to 25 characters."
                               required/>
                    </li>
                    <input type="hidden" value="${cityId}" name="cityId"/>
                </div>
                </c:otherwise>
                </c:choose>
                <div>
                    <button class="button" type="submit" name="action" value="update">Submit</button>
                </div>
            </form>
        </div>
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