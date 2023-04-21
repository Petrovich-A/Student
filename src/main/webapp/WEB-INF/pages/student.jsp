<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="CSS/style.css"/>"/>
    <meta charset="UTF-8">
    <title>JSP - student</title>
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
        <h2>Students list:</h2>
        <br>
        <form action="studentCrudServlet" method="POST">
            <c:choose>
                <c:when
                        test="${students.size() == 0 || students.size() == null}">
                    <p>
                        <c:out value="No students"/>
                    </p>
                    <hr>
                </c:when>
                <c:otherwise>
                    <div class="container">
                        <table>
                            <thead>
                            <tr>
                                <th></th>
                                <th>FIRST NAME</th>
                                <th>LAST NAME</th>
                                <th>CITY</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="student" items="${students}">
                                <tr>
                                    <td>
                                        <input type="radio" name="studentId" value="${student.getId()}"
                                               required="required"></td>
                                    <td>${student.getFirstName()}</td>
                                    <td>${student.getLastName()}</td>
                                    <td>${student.getCity().getName()}</td>
                                    <td><input type="hidden" name="cityId" value="${student.getCity().getId()}">
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:otherwise>
            </c:choose>
            <button class="button" type="submit" name="action" value="readById">Read</button>
            <button class="button" type="submit" name="action" value="update">Update</button>
            <button class="button" type="submit" name="action" value="deleteById">Delete</button>
        </form>
        <form action="goToCreateStudentPage" method="POST">
            <button class="button" type="submit">Create</button>
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