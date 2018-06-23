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
<title>Manage Employees</title>
</head>
<body>
	<font color="red">${addmessage}</font>
	<form method="post" action="/findByName">
		<table>
			<tr>
				<td>Enter Employee Name :</td>
				<td><input type="text" name="empName"></td>
			</tr>
			<tr></tr>
			<tr>
				<c:if test="${not empty employeesList}">
					<TABLE>
						<TR>
							<TH>Employee Id</TH>
							<TH>Employee Name</TH>
							<TH>Employee Role</TH>
						</TR>
						<c:forEach var="var1" items="${employeesList}">
							<TR>
								<TD>${var1.empId}</TD>
								<TD>${var1.empName}</TD>
								<TD>${var1.empRole}</TD>
							</TR>
						</c:forEach>
					</TABLE>
				</c:if>
			</tr>
			<tr>
				<td><input type="submit" name="Find"/></td>
			</tr>
		</table>


	</form>

</body>
</html>