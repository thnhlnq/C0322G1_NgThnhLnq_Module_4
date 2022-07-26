<%--
  Created by IntelliJ IDEA.
  User: ntlon
  Date: 12/07/2022
  Time: 03:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2>Currency Converter</h2>
<form action="/convert" method="post">

    <label class="form-label">Rate</label>
    <label><input type="number" name="rate" value="${rate}"></label><br>

    <label class="form-label">USD</label>
    <label><input type="number" name="usd" value="${usd}"></label><br>

    <button type="submit" class="btn btn-primary ms-5">Submit</button>
    <h2>Result: ${vnd} VND.</h2>

</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
