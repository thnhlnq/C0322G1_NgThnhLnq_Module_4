<%--
  Created by IntelliJ IDEA.
  User: ntlon
  Date: 15/07/2022
  Time: 09:28 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Information</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h5>${message}</h5>
<form action="/">
    <table class="table table-striped table-hover">
        <tr>
            <th></th>
            <th hidden>Id</th>
            <th>Languages</th>
            <th>Page Size</th>
            <th>Spams Filter</th>
            <th>Signature</th>
            <th></th>
        </tr>

        <c:forEach items="${mails}" var="mail">
            <tr>
                <td></td>
                <td hidden>${mail.id}</td>
                <td>${mail.language}</td>
                <td>${mail.pageSize}</td>
                <td>${mail.spamFilter}</td>
                <td>${mail.signature}</td>
                <td><a href="/edit?id=${mail.id}"><button type="button" class="btn btn-outline-secondary" value="Edit">Edit</button></a></td>
            </tr>
        </c:forEach>

    </table>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
