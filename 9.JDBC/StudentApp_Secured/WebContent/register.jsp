<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Register</title></head>
<body>
<h2>Register as Student</h2>
<form action="register" method="post">
    Name: <input name="name" required><br><br>
    Email: <input name="email" type="email" required><br><br>
    Password: <input name="password" type="password" required><br><br>
    <button type="submit">Register</button>
</form>
<p><a href="login.jsp">Back to Login</a></p>
</body>
</html>
