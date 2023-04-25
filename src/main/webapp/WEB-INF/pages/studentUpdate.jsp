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
            <li><a href="goToMainPage">MAIN</a></li>
            <li><a href="goToStudentPage">STUDENTS</a></li>
            <li><a href="goToCityPage">CITIES</a></li>
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
            <form action="studentUpdateById" method="POST">
                <table>
                    <tr>
                        <input type="hidden" value="${student.getId()}" name="studentId"/>
                        <td>FIRST NAME:</td>
                        <td><label><input type="text" value="${student.getFirstName()}" name="updatedStudentFirstName"
                                   required pattern="[a-z,A-Z,а-я,А-Я]{2,30}" title="Input first name"/></label></td>
                        <td>LAST NAME:</td>
                        <td><label><input type="text" value="${student.getLastName()}" name="updatedStudentLastName"
                                   required pattern="[a-z,A-Z,а-я,А-Я]{2,30}" title="Input last name"/></label></td>
                        <td>CITY:</td>
                        <td><select name='cityId' required>
                            <c:forEach items="${cities}" var="city">
                                <option value="${city.getId()}" select="{${city.getName()}">${city.getName()}
                                </option>
                            </c:forEach>
                        </select>
                        </td>
                    </tr>
                </table>
                </c:otherwise>
                </c:choose>
                <div>
                    <button class="button" type="submit">Submit</button>
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