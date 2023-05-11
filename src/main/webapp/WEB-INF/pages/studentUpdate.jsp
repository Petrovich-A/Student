<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="CSS/style.css"/>"/>
    <meta charset="UTF-8">
    <title>Student update</title>
</head>
<nav>
    <ul>
        <li class="logo"><span>STUDENT</span> APP &#128102</li>
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
        <h2>Student update</h2>
        <br>
        <c:choose>
        <c:when
                test="${student == null} || ${cities == null}">
        <p>
            <c:out value="No data to update"/>
        </p>
        <hr>
        </c:when>
        <c:otherwise>
        <div class="container">
            <form action="student" method="POST">
                <div class="form">
                    <li>
                        <input type="hidden" value="${student.getId()}" name="studentId"/>
                        <label>FIRST NAME: </label>
                        <input type="text"
                               value="${student.getFirstName()}"
                               name="updatedStudentFirstName"
                               pattern="[a-zA-Zа-яА-Я]{2,30}"
                               title="Must contain latin and cyrillic uppercase or lowercase letters. The total
                                       length of string is from 2 to 30 characters."
                               required/>
                    </li>
                    <li>
                        <label>LAST NAME: </label>
                        <input type="text"
                               value="${student.getLastName()}"
                               name="updatedStudentLastName"
                               pattern="[a-zA-Zа-яА-Я]{2,30}"
                               title="Must contain latin and cyrillic uppercase or lowercase letters. The total length
                                        of string is from 2 to 30 characters."
                               required/>
                    </li>
                    <li>
                        <label>CITY:</label>
                        <select name='cityId' required>
                            <c:forEach items="${cities}" var="city">
                                <option value="${city.getId()}" select="{${city.getName()}">${city.getName()}
                                </option>
                            </c:forEach>
                        </select>
                    </li>
                    </c:otherwise>
                    </c:choose>
                    <div>
                        <button class="button" type="submit" name="action" value="update">Submit</button>
                    </div>
                </div>
            </form>
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