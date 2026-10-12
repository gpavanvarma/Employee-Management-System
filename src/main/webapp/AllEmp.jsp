<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Employee Result</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f7fa;
        }

        h2 {
            text-align: center;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            background-color: white;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #b1c7f6;
        }

        tr:nth-child(even) {
            background-color: #dbfbb9;
        }

        .message {
            text-align: center;
            color: green;
            margin-bottom: 15px;
        }

        .home-button {
            display: block;
            width: fit-content;
            margin: 20px auto;
            padding: 10px 20px;
            background-color: #3fe88a;
            color: black;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
        }

        .home-button:hover {
            background-color: #5b8e52;
        }

        .empty-message {
            text-align: center;
            color: #777;
        }
    </style>
</head>

<body>

<section>

    <h2>Employee Details</h2>

    <p class="message">
        <c:out value="${message}" />
    </p>

    <table>

        <thead>
        <tr>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Salary</th>
            <th>Department</th>
            <th>Email</th>
        </tr>
        </thead>

        <tbody>

        <c:choose>

            <c:when test="${not empty employees}">

                <c:forEach var="emp" items="${employees}">

                    <tr>
                        <td><c:out value="${emp.id()}" /></td>
                        <td><c:out value="${emp.name()}" /></td>
                        <td><c:out value="${emp.salary()}" /></td>
                        <td><c:out value="${emp.department()}" /></td>
                        <td><c:out value="${emp.email()}" /></td>
                    </tr>

                </c:forEach>

            </c:when>

            <c:otherwise>

                <tr>
                    <td colspan="5" class="empty-message">
                        No employee records found.
                    </td>
                </tr>

            </c:otherwise>

        </c:choose>

        </tbody>

    </table>

    <a href="${pageContext.request.contextPath}/Main.html"
       class="home-button">
        Home
    </a>

</section>

</body>
</html>