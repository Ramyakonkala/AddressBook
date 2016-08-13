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

<%
String msg = request.getParameter("msg");
if(msg != null){
	out.print("<p align=center><font color=blue> "+  msg + "</font></p>");
}	
%>

<title>login account</title>
</head>
<body>

<div class="container">
<div class="col-sm-4"></div>

<div class="col-sm-4" style="margin-top: 30px">

<h1 align="center">Address Book</h1>
  <div class="jumbotron">

<form action = "LoginController">
<table align="center" class="table">
<thead>
<tr><th colspan="3" align="center"><h3>Login</h3></th></tr></thead>
<tr><td colspan="2"><img alt="logo" src="./images/loginpic.png"></td><tr>
<tr><td><b>Username:</b></td>
<td><input type = text name = "user" ></td></tr>
<tr><td><b>Password</b></td>
<td><input type = password name = "pwd"></td></tr>
<tr><td><input type = submit value= login></td><td><a href="password.jsp">change password</a></td></tr>
<tr><td colspan="2"><a href = signup.jsp>Are u new user? sign up here</a></td></tr>


</table>
</form>
<%
String user = request.getParameter("username");
String error = request.getParameter("error");
if(user == ""){
	out.print("<table align=center><tr><td><font color=red>*" + "please enter username and password" + "</font color></td></tr></table>");
	}
else if(user != null){
		out.print("<table align=center><tr><td><font color=red>*" +  user + " it seems you have not registered!! or your password may be wrong!!" + "</font color></td></tr></table>");
		} 	
if(error != null){
	out.print("<table align=center><tr><td><font color=red>*" +  error + "</font color></td></tr></table>");
}
%>
</div>
</div>
</div>
</body>
</html>