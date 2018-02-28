<%@page import="java.util.Iterator"%>
<%@page import="com.beans.BankBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>BankId</th>
<th>Bank Name</th>
<th>IFSC</th>
<th>Address</th>
</tr>
<%
ArrayList<BankBean>al=(ArrayList)request.getAttribute("banklist");
Iterator<BankBean> i=al.iterator();
while(i.hasNext()){
	BankBean b=i.next();
	%>
	<tr>
	<th><%=b.getBankId() %></th>
	<th><%=b.getBankName() %></th>
	<th><%=b.getIfsc() %></th>
	<th><%=b.getAddress() %></th>
	</tr>
	
	
	
	
	<% 
}	
%>
</table>
<br/>
<a href="AdminHome.jsp">Back</a>
</body>
</html>