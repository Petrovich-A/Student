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
            <li><a href="main">MAIN</a></li>
            <li><a href="student">STUDENTS</a></li>
            <li><a href="city">CITIES</a></li>
        </div>
    </ul>
</nav>
<main>
    <body>
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
            <form action="cityUpdateById" method="POST">
                <table>
                    <tr>
                        <td>CITY NAME:</td>
                        <td><input type="text" value="${cityName}" name="updatedCityName" required
                                   pattern="[a-z,A-Z,а-я,А-Я]{2,30}"
                                   title="Input city name"/></td>
                        <input type="hidden" value="${cityId}" name="cityId"/>
                    </tr>
                </table>
                </c:otherwise>
                </c:choose>
                <div>
                    <button class="button" type="submit">Submit</button>
                </div>
            </form>
        </div>
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