<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">
		<font color="red" size="40">Search Bank</font>
	</h1>
	<table border="1" align="center">
		<form action="searchbank" method="post">
			<tr>
				<td><input type="text" name="bankId" placeholder="Enter bankid"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Search Bank"></td>
			</tr>

		</form>
	</table>
</body>
</html>