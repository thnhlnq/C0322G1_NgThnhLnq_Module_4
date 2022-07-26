<%--
  Created by IntelliJ IDEA.
  User: ntlon
  Date: 15/07/2022
  Time: 06:42 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Email Configuration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form:form action="/edit" method="post" modelAttribute="mails">
    <fieldset>
        <h3>SETTINGS</h3>

        <table>
            <tr>
                <td><form:label path="id"/>Id</td>
                <td><form:input readonly="true" path="id"/></td>
            </tr>

            <tr>
                <th><form:label path="language"/>Languages</th>
                <td><form:select path="language" items="${language}"/></td>
            </tr>

            <tr>
                <th><form:label path="pageSize"/>Page Size</th>
                <td>Show &nbsp;<form:select path="pageSize" items="${pageSize}"/> &nbsp; Emails per page</td>
            </tr>

            <tr>
                <th>Spams Filter</th>
                <td><form:checkbox path="spamFilter"/> &nbsp; Enable Spams Filter</td>
            </tr>

            <tr>
                <th>Signature</th>
                <td><form:textarea path="signature" rows="5" cols="50"/></td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <button type="submit" value="Update" class="btn btn-outline-secondary">Update</button>
                    <a href="/"><button type="button" value="Cancel" class="btn btn-outline-secondary">Cancel</button></a>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
