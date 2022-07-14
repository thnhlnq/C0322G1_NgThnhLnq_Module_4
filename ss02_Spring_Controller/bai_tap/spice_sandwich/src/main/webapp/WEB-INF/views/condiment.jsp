<%--
  Created by IntelliJ IDEA.
  User: ntlon
  Date: 14/07/2022
  Time: 11:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<form action="/condiment" method="post">
    <fieldset>
        <legend><b>Spice Sandwich</b></legend>
        <input type="checkbox" name="condiment" value="Lettuce">${lettuce}
        <span>Lettuce</span>
        <input type="checkbox" name="condiment" value="Tomato">${tomato}
        <span>Tomato</span>
        <input type="checkbox" name="condiment" value="Mustard">${mustard}
        <span>Mustard</span>
        <input type="checkbox" name="condiment" value="Sprouts">${sprouts}
        <span>Sprouts</span><br>
        <button type="submit" value="Save">Save</button>
    </fieldset>
    <h2>You Choose Condiment: ${sandwich}</h2>
</form>
</body>
</html>
