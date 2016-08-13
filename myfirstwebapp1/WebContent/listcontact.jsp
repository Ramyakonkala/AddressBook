<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "com.bvrith.model.*" %>
<%@page import = "com.bvrith.model.*"%>
<%@ page import = "java.util.*"%>
<%@page import = "com.bvrit.userDAO.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
HttpSession hs = request.getSession();
String user = (String)hs.getAttribute("sname");
ContactDAO contactDAO = new ContactDAO();
List<ContactBean> lst = contactDAO.listContact(user);
ListIterator<ContactBean> lt = lst.listIterator();

%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class = 'well-lg' style=background-color:#F0F8FF>
<div class="container" style="margin: 60px 60px 195px 0px">
<div class="col-sm-4"></div>

<div class="col-sm-4" style="margin-top: 100px">
<%String msg = request.getParameter("msg");
if(msg != null){
	out.print("<p align=center><font color=blue size = 4> "+  msg + "</font></p>");
}%>
 



<form>
<table align="center" class="table table-striped">
<thead>
<tr><th colspan="3" align="center"><h2>Contacts Info</h2></th></tr></thead>

<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Phone</th>
<th>Delete</th>
<th>Update</th>
</tr>
<%
while(lt.hasNext())
{
     ContactBean cb = lt.next();
     out.print("<tr>");
     out.print("<td>"+cb.getId()+"</td>");
     out.print("<td>"+cb.getName()+"</td>");
     out.print("<td>"+cb.getEmail()+"</td>");
     out.print("<td>"+cb.getPhone()+"</td>");
     out.print("<td align=center ><a href=DeleteController?id="+cb.getId()+"><img width = 30px height=30px alt=logo src=./images/delete.jpeg"+"></a></td>");
     out.print("<td align=center><a href=updateContact.jsp?id="+cb.getId()+ "&name="+cb.getName()+"&email="+cb.getEmail()+"&phone="+cb.getPhone()+"><img width = 30px height=30px alt=logo src=./images/update.png"+"></a></td>");
     out.print("<tr>");
}
%>
<tr><td colspan="6" align="center"><a href="WelcomePage.view"><input type = button value = back></a></td></tr>
</table>
</form>


</div>
</div>
</div>
</body>
</html>