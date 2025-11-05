<%@ page import="com.srtCoder.Student" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Student s = (Student) request.getAttribute("student");
    if (s == null) { response.sendRedirect("students"); return; }
%>
<!DOCTYPE html>
<html>
<head><title>Edit Student</title></head>
<body>
    <h2>Edit Student</h2>
    <form action="student/edit" method="post">
        <input type="hidden" name="id" value="<%= s.getId() %>">
        Name: <input name="name" value="<%= s.getName() %>" required><br><br>
        Email: <input name="email" type="email" value="<%= s.getEmail() %>" required><br><br>
        <button type="submit">Save</button>
    </form>
    <p><a href="students">Back to List</a></p>
</body>
</html>
