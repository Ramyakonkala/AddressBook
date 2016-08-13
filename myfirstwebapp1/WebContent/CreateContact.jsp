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
<body >
<div class = 'well-lg' style=background-color:#F0F8FF>

<div class="container" style="margin: 0px 0px 70px 0px">
<div class="col-sm-4"></div>

<div class="col-sm-4" style="margin-top: 100px">

  <div class="jumbotron">

<form action="CreateContactController" >
<table align="center" class="table table-striped">
<thead>
<tr><th colspan="3" align="center"><h2>Add contact</h2></th></tr></thead>
<tr><td>Id:</td><td><input type = text name = id></td></tr>
<tr><td>Name:</td><td><input type =text  name = name></td></tr>
<tr><td>Email:</td><td><input type = text name = email></td></tr>
<tr><td>Phone:</td><td><input type = text name = phone></td></tr>
<tr><td align="right"><input type = submit value = ADD></td><td colspan="5" align="center"><a href="WelcomePage.view"><input type = button value = back></a></td></tr>
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
</div>
</body>
</html>