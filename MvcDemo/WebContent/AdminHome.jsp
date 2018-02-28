<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="aqua">
Welcome <%=session.getAttribute("email") %><br/><br/>
<a href="AddBank.jsp">Add Bank</a><br/><br/>
<a href="viewallbanks">View All Banks</a><br/><br/>
<a href="SearchBank.jsp">Search Bank</a><br/><br/>
<a href="Logout.jsp">Logout</a><br/><br/>
</body>
</html>