<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="CSS/style.css"/>"/>
    <meta charset="UTF-8">
    <title>Create student JSP</title>
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
    <body>
    <h2>Create student: </h2>
    <br>
    <form action="studentCreate" method="POST">
        <div class="form">
            <li>
                <label>STUDENT FIRST NAME:</label>
                <input type="text"
                       name="studentFirstName"
                       pattern="[a-zA-Zа-яА-Я]{2,30}"
                       title="Must contain latin and cyrillic uppercase or lowercase letters. The total length of string is from 2 to 30 characters."
                       required/>
            </li>
            <li>
                <label>STUDENT LAST NAME:</label>
                <input type="text"
                       name="studentLastName"
                       pattern="[a-zA-Zа-яА-Я]{2,30}"
                       title="Must contain latin and cyrillic uppercase or lowercase letters. The total length of string is from 2 to 30 characters."
                       required/>
            </li>
            <li>
                <label>CITY:</label>
                <select name='cityId' required>
                    <c:forEach items="${cities}" var="city">
                        <option value="${city.getId()}">${city.getName()}
                        </option>
                    </c:forEach>
                </select>
            </li>
        </div>
        <div>
            <button class="button" type="submit" name="action" value="create">Submit</button>
        </div>
    </form>
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