<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Employees</title>
</head>
<body>
	<font color="red">${welcomeerrormessage}</font>
	<form method="post" id="welcome">
		<table>
			<tr>
				<td><a href="getAllEmployees" id="getAll">Update any
						Employee</a></td>
			</tr>
			<tr>
				<c:if test="${not empty employeesList}">
					<TABLE>
						<TR>
							<TH>Select </TH>
							<th></th>
							<TH>Employee Id</TH>
							<TH>Employee Name</TH>
						</TR>
						<c:forEach var="var1" items="${employeesList}">
							<TR>
								<TD><a href="updateEmp/${var1.empId}/" id="updateEmp">Update</a></TD>
								<td></td>
								<TD>${var1.empId}</TD>
								<TD>${var1.empName}</TD>

							</TR>
						</c:forEach>
					</TABLE>
				</c:if>
			</tr>
		</table>
		<table>
			<tr>
				<td><a href="addEmp" id="addEmp">Add Employee</a></td>
			</tr>
			<!-- <tr>
				<td><a href="updateEmp" id="updateEmp">Update Employee</a></td>
				<td>Employee ID :</td>
				<td><input type="text" name="empId" id="empId"></td>
			</tr> -->
			<tr>
				<td><a href="delEmp" id="delEmp">Delete Employee</a></td>
			</tr>
			<tr></tr>
			<tr>
				<td><a href="findByName" id="findByName">Find Employee by Name</a></td>
			</tr>
		</table>


	</form>

</body>
</html>