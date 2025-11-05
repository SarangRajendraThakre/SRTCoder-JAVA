<%@ page import="java.util.*,com.srtcoder.Student" %>
<h2>Student List</h2>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Actions</th></tr>
<%
List<Student> list = (List<Student>) request.getAttribute("studentList");
for(Student s : list){
%>
<tr>
<td><%= s.getId() %></td>
<td><%= s.getName() %></td>
<td><%= s.getEmail() %></td>
<td><%= s.getCourse() %></td>
<td>
  <a href="edit?id=<%=s.getId()%>">Edit</a> |
  <a href="delete?id=<%=s.getId()%>">Delete</a>
</td>
</tr>
<% } %>
</table>
