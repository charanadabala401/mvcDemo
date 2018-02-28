<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="aqua">
<%String message=(String)request.getAttribute("message");
if(message!=null){
	out.println("<font color=red>"+message+"</font>");
}

%>
	<form action="login" method="post">
		<table border="1">
			<tr>
				<td><input type="text" name="email" placeholder="Enter Email"></td>
			</tr>
			<tr>
				<td><input type="password" name="password"
					placeholder="Enter Password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form>
</body>
</html>