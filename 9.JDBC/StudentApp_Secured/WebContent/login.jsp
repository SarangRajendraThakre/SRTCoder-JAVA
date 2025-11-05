<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
<h2>Admin Login</h2>
<form action="login" method="post">
    Username: <input name="username"><br><br>
    Password: <input name="password" type="password"><br><br>
    <button type="submit">Login as Admin</button>
</form>
<hr>
<h2>Student Login</h2>
<form action="login" method="post">
    Email: <input name="email"><br><br>
    Password: <input name="password" type="password"><br><br>
    <button type="submit">Login as Student</button>
</form>
<% if ("1".equals(request.getParameter("error"))) { %>
    <p style="color:red;">Invalid credentials</p>
<% } %>
<p><a href="register.jsp">Register (student)</a></p>
</body>
</html>
