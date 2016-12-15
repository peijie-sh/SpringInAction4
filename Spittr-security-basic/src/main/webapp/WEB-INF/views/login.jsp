<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spitter-login</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />">
</head>
<body>
<div id="content">
    <a href="/spitter/register">Register</a>

    <form name='f' action='/login' method='POST'>
        <table>
            <tr><td>User:</td><td>
                <input type='text' name='username' value='' /></td></tr>
            <tr><td>Password:</td>
                <td><input type='password' name='password'/></td></tr>
            <tr><td colspan='2'>
                <input id="remember_me" name="remember-me" type="checkbox"/>
                <label for="remember_me" class="inline">Remember me</label></td></tr>
            <tr><td colspan='2'>
                <input name="submit" type="submit" value="Login"/></td></tr>
                <input name="{_csrf.parameterName}" type="hidden" value="{_csrf.token}"/>
        </table>
    </form>

</div>

</body>
</html>
