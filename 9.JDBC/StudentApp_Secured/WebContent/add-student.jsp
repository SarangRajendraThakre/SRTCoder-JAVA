<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Add Student</title></head>
<body>
    <h2>Add Student</h2>
    <form action="register" method="post">
        Name: <input name="name" required><br><br>
        Email: <input name="email" type="email" required><br><br>
        Password: <input name="password" type="password" required><br><br>
        <button type="submit">Add</button>
    </form>
    <p><a href="students">Back to List</a></p>
</body>
</html>
