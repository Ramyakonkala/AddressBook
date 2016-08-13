<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<div class="container">
<div class="col-sm-4"></div>

<div class="col-sm-4" style="margin-top: 150px">
<h1 align="center">Address Book</h1>

  <div class="jumbotron">
  
   <form action="SignupController">
<table align="center" class="table">
<thead>
<tr><th colspan="2" align="center"><h3>Create your account</h3></th></tr></thead>
<tr><td><b>Username:</b></td><td><input type = text name = suser></td></tr>
<tr><td><b>Password:</b></td><td><input type = password name = spwd></td></tr>
<tr><td align="center"><input type = submit value = Register></td><td align="center"><a href="loginpage.jsp"><input type = "button" value = Back></a></td></tr>

</table>
</form>
<%
String msg = request.getParameter("msg");
if(msg != null){
	out.print("<table align=center><tr><td><font color=red>*" +  msg + "</font color></td></tr></table>");
}
%>
</div>
</div>
</div>

</body>
</html>