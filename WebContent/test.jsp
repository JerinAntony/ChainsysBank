<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="TestServlet" method="get">
	 <h2> How to loop Hashtable in JSP</h2>

		<table style="color: black">
			<c:forEach var="entry" items="${MAP}">
				<tr>
					<td><c:out value="${entry.key}"></c:out></td>
					<td><c:out value="${entry.value}"></c:out></td>
				</tr>

			</c:forEach>
		</table>
	</form>
</body>
</html>