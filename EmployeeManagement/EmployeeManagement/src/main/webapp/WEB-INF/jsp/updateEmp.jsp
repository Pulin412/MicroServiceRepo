<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Employees</title>
</head>
<body>
	<font color="red">${updatemessage}</font>
	<form method="post" action="/updateEmp">
		<table>
			<tr>
				<td>Employee Id :</td>
				<td><input type="text" name="empId" value=${empId}></td>
			</tr>
			<tr>
				<td>Employee Name :</td>
				<td><input type="text" name="empName" value=${empName}></td>
			</tr>
			<tr>
				<td>Employee Age :</td>
				<td><input type="text" name="empAge" value=${empAge}></td>
			</tr>
			<tr>
				<td>Employee Salary :</td>
				<td><input type="text" name="empSalary" value=${empSalary}></td>
			</tr>
			<tr>
				<td>Employee Department :</td>
				<td><input type="text" name="empDepartment" value=${empDepartment}></td>
			</tr>
			<tr>
				<td>Employee Role :</td>
				<td><input type="text" name="empRole" value=${empRole}></td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="submit" value="Update Employee" /></td>
			</tr>
		</table>


	</form>

</body>
</html>