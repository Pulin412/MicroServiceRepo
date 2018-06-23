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
	<!-- <form method="post"> -->
		<table>
			<tr>
				<td>Select Employee Id to be deleted :</td>
			</tr>
			<tr>
			</tr>
		</table>
		<c:if test="${not empty employeesList}">
			<TABLE>
				<TR>
					<TH>Employee Id</TH>
					<TH>Employee Name</TH>
					<TH>Delete</TH>
				</TR>
				<c:forEach var="var1" items="${employeesList}">
					<TR>
						<TD>${var1.empId}</TD>
						<TD>${var1.empName}</TD>
						<form method="post" action="/delEmp/${var1.empId}/">
						<td><input type="submit" value="Delete" /></td>
						<%-- <TD><a href="/delEmp/${var1.EmpId}/" id="deleteEmp">Delete</a></TD> --%>
						</form>
					</TR>
				</c:forEach>
			</TABLE>
		</c:if>

		<!-- <table>

			<tr></tr>
			<tr>
				<td><input type="submit" value="Delete Employee" /></td>
			</tr>
		</table> -->


	<!-- </form> -->

</body>
</html>