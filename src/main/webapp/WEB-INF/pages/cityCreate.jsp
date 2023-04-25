<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="CSS/style.css"/>"/>
    <meta charset="UTF-8">
    <title>Create city JSP</title>
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
<main>
    <body>
    <div>
        <h2>Create city: </h2>
        <br>
        <form action="cityCreate" method="POST">
            <div class="container">
                <table>
                    <tr>
                        <td>CITY NAME:</td>
                        <td><input type="text" name="cityName" pattern="[a-z,A-Z,а-я,А-Я,\s]{2,30}"
                                   title="Input city name" required/></td>
                    </tr>
                </table>
            </div>
            <div>
                <button class="button" type="submit">Submit</button>
            </div>
        </form>
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