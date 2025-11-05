<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String user = (String) session.getAttribute("user");
    com.srtCoder.Student student = (com.srtCoder.Student) session.getAttribute("student");
    if (user == null && student == null) response.sendRedirect("login.jsp");
%>
<!DOCTYPE html>
<html>
<head><title>Home</title></head>
<body>
    <h2>Welcome <%= (user!=null?user:student.getName()) %></h2>
    <p><a href="students">View Students</a> | <a href="logout">Logout</a></p>
</body>
</html>
