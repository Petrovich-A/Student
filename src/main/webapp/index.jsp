<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello student</title>
</head>
<body>
<div style="text-align: center; margin: 50px">
    <nav style="text-decoration: none; display: flex; vertical-align: middle; padding: 10px 20px 10px 20px;">
        <ul style="display: inline-flex; list-style: none;	flex-wrap: wrap; align-items: center; justify-content: center">
            <li style="flex: 3"><span>STUDENTS</span> APP</li>
            <div style="padding: 0 5px; display: inline-flex;	font-weight: 200;">
                <li><a style="text-decoration: none;flex: 3" href="main">MAIN</a></li>
                <li><a style="text-decoration: none;flex: 3" href="student">STUDENTS</a></li>
                <li><a style="text-decoration: none;flex: 3" href="city">CITIES</a></li>
            </div>
        </ul>
    </nav>
    <br/>
    <h1>Hello Student app!</h1>
    <br/>
    <main>
        <div style="text-align: center; margin:50px">
            <h2>List of students:</h2>
            <hr>
            <c:choose>
                <c:when
                        test="${studentWithCity.size() == 0 || studentWithCity.size() == null}">
                    <p>
                        <c:out value="No studentWithCity"/>
                    </p>
                    <hr>
                </c:when>
                <c:otherwise>
                    <table style="border: grey; width: 70%; text-align: center; alignment: center; padding: 10px">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>first_name</th>
                            <th>last_name</th>
                            <th>id</th>
                            <th>name</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="studentWithCity" items="${studentWithCity}">
                            <tr>
                                <td>${studentWithCity.getStudentId()}</td>
                                <td>${studentWithCity.getStudentFirstName()}</td>
                                <td>${studentWithCity.getStudentLastName()}</td>
                                <td>${studentWithCity.getCityId()}</td>
                                <td>${studentWithCity.getCityName()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </main>
</div>
</body>
</html>