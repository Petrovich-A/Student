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
            <li><a href="main">MAIN</a></li>
            <li><a href="student">STUDENTS</a></li>
            <li><a href="city">CITIES</a></li>
        </div>
    </ul>
</nav>
<main>
    <body>
    <div>
        <h2>Create student: </h2>
        <br>
        <form action="studentCreate" method="POST">
            <div class="container">
                <table>
                    <tr>
                        <td>STUDENT FIRST NAME:</td>
                        <td><input type="text" name="firstName" required pattern="[a-z,A-Z,а-я,А-Я]{2,30}"
                                   title="Input student first name"/></td>
                    </tr>
                    <tr>
                        <td>STUDENT LAST NAME:</td>
                        <td><input type="text" name="lastName" required pattern="[a-z,A-Z,а-я,А-Я]{2,30}"
                                   title="Input student last name"/></td>
                    </tr>
                    <tr>
                        <td>CITY:</td>
                        <td><select name='cityId'>
                            <c:forEach items="${cities}" var="city">
                                <option value="${city.getId()}">${city.getName()}
                                </option>
                            </c:forEach>
                        </select>
                        </td>
                    </tr>
                </table>
            </div>
            <div>
                <button class="button" type="submit" name="action" value="create">Submit</button>
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