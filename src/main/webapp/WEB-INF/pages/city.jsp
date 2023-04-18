<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="CSS/style.css"/>"/>
    <meta charset="UTF-8">
    <title>Cities JSP</title>
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
        <h2>Cities list:</h2>
        <br>
        <form action="cityCRUDServlet" method="POST">
            <c:choose>
                <c:when
                        test="${cities.size() == 0 || cities.size() == null}">
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
                            <c:forEach var="city" items="${cities}">
                                <tr>
                                    <td><label>
                                        <input type="radio" name="cityId" value="${city.getId()}"
                                               required="required">
                                    </label>${city.getId()}</td>
                                    <td>${city.getName()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:otherwise>
            </c:choose>
            <div>
                <button class="button" type="submit" name="action" value="goToCreatePage">Create</button>
                <button class="button" type="submit" name="action" value="readById">Read</button>
                <button class="button" type="submit" name="action" value="update">Update</button>
                <button class="button" type="submit" name="action" value="deleteById">Delete</button>
            </div>
        </form>
    </div>
</main>
</body>
<footer>
    <div></div>
</footer>
</html>