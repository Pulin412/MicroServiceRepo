<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Link Test</title>
</head>
<body>
	<font color="red">${addmessage}</font>
	<form method="post" action="/linkTest/findByLinkId">
		<table>
			<tr>
				<td>Enter Link ID :</td>
				<td><input type="text" name="origLinkId"></td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="submit" id="Find"/></td>
			</tr>
			<tr>
				<c:if test="${not empty messageDTOList}">
				<td>
					Count of Messages - <font color="blue">${messagesCount}</font>
				</td>
					<TABLE>
						<TR>
							<TH>IRN</TH>
						</TR>
						<c:forEach var="var1" items="${messageDTOList}">
							<TR>
								<TD>${var1.irn}</TD>
							</TR>
						</c:forEach>
					</TABLE>
				</c:if>
			</tr>
			
		</table>


	</form>

</body>
</html>