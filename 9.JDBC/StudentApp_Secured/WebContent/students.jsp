<%@ page import="java.util.*, com.srtCoder.Student" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String user = (String) session.getAttribute("user");
    com.srtCoder.Student student = (com.srtCoder.Student) session.getAttribute("student");
    if (user == null && student == null) { response.sendRedirect("login.jsp"); return; }
    List<com.srtCoder.Student> list = (List<com.srtCoder.Student>) request.getAttribute("students");
%>
<!DOCTYPE html>
<html>
<head><title>Students</title></head>
<body>
    <h2>Students</h2>
    <p>Logged in as: <%= (user!=null?user:student.getName()) %></p>
    <p><a href="logout">Logout</a> | <a href="add-student.jsp">Add Student</a></p>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr><th>ID</th><th>Name</th><th>Email</th><th>Action</th></tr>
        <%
            if (list != null) {
                for (com.srtCoder.Student s : list) {
        %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getEmail() %></td>
                <td>
                    <a href="student/edit?id=<%= s.getId() %>">Edit</a> |
                    <a href="student/delete?id=<%= s.getId() %>">Delete</a>
                </td>
            </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
