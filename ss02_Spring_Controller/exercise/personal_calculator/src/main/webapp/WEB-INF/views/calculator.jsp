<%--
  Created by IntelliJ IDEA.
  User: ntlon
  Date: 14/07/2022
  Time: 10:40 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<h1>Simple Calculator</h1>
<form method="post" action="/calculator">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First Operand:</td>
                <td><input name="firstOperand" type="text" required value="${firstOperand}"/></td>
            </tr>
            <tr>
                <td>Operator:</td>
                <td>
                    <select name="operator">
                        <option <c:if test="${operator == '+'}"> selected </c:if> value="+">Addition (+)</option>
                        <option <c:if test="${operator == '-'}"> selected </c:if> value="-">Subtraction (-)</option>
                        <option <c:if test="${operator == '*'}"> selected </c:if> value="*">Multiplication (*)</option>
                        <option <c:if test="${operator == '/'}"> selected </c:if> value="/">Division (/)</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Second Operand:</td>
                <td><input name="secondOperand" type="text" required value="${secondOperand}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"/></td>
            </tr>
        </table>
    </fieldset>
</form>
<h3>Result: ${result}</h3>

</body>
</html>
