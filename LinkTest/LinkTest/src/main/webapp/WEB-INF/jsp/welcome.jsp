<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Link Test</title>
</head>
<body>
	<%-- <center>
		<h2>Fetching Message Count for each link every 5 seconds</h2>
		<%
		    response.setIntHeader("Refresh", 5);
		    Calendar calendar = new GregorianCalendar();
		    String am_pm;
		    int hour = calendar.get(Calendar.HOUR);
		    int minute = calendar.get(Calendar.MINUTE);
		    int second = calendar.get(Calendar.SECOND);
		    if (calendar.get(Calendar.AM_PM) == 0)
		        am_pm = "AM";
		    else
		        am_pm = "PM";
		    String CT = hour + ":" + minute + ":" + second + " " + am_pm;
		    out.println("Time: " + CT + " ");
		%>
	</center> --%>
	<font color="red">${welcomemessage}</font>
	<form method="post" id="welcome">
		<table>
			<%-- <tr>
				<c:if test="${not empty dashboardDTO.linkMessageMap}">
					<td>
					Count of Messages - <font color="blue">${messageLinkMap}</font>
				</td>
					<TABLE>
						<TR>
							<TH>Link ID</TH>
							<TH></TH>
							<TH></TH>
							<TH>Count</TH>
							<!-- <TH></TH>
							<TH></TH>
							<TH>Status</TH>
							<TH></TH>
							<TH></TH>
							<TH>Direction</TH> -->
						</TR>
						<c:forEach var="var1" items="${dashboardDTO.linkMessageMap}">
							<TR>
								<TD>${var1.key}</TD>
								<TD></TD>
								<TD></TD>
								<TD>${var1.value}</TD>
							</TR>
						</c:forEach>
						<c:if test="${not empty dashboardDTO.mqsLinkDTOList}">
							<td>Count - <font color="blue">${dashBoardDTOForLinkcount}</font>
							</td>
							<!-- <TABLE> -->
							<TR>
								<TH>Link ID</TH>
								<TH></TH>
								<TH></TH>
								<TH>Status</TH>
								<TH></TH>
								<TH></TH>
								<TH>Direction</TH>
							</TR>
							<c:forEach var="var2" items="${dashboardDTO.mqsLinkDTOList}">
								<TR>
									<TD>${var2.mqsLinkId}</TD>
									<TD></TD>
									<TD></TD>
									<TD>${var2.mqsLinkStatus}</TD>
									<TD></TD>
									<TD></TD>
									<TD>${var2.linkDirection}</TD>
								</TR>
							</c:forEach>
							<!-- </TABLE> -->
						</c:if>
					</TABLE>
				</c:if>
			</tr> --%>
			<tr>
				<th>Messages in Send Queue Details</th>
				<c:choose>
					<c:when test="${not empty senddashboardDTO.dashBoardDTOList}">
						<TABLE>
							<TR>
								<TH>Link Name</TH>
								<TH></TH>
								<TH></TH>
								<TH>Message Count</TH>
								<TH></TH>
								<TH></TH>
								<TH>Link Direction</TH>
							</TR>
							<c:forEach var="var1"
								items="${senddashboardDTO.dashBoardDTOList}">
								<TR>
									<TD>${var1.linkName}</TD>
									<TD></TD>
									<TD></TD>
									<TD>${var1.readyQueueMessagesCount}</TD>
									<TD></TD>
									<TD></TD>
									<TD>${var1.linkDirection}</TD>
								</TR>
							</c:forEach>
						</TABLE>
					</c:when>
					<c:otherwise>
						<TABLE>
							<tr>
								<td><mark>${senddashBoardEmpty}</mark></td>
							</tr>
						</TABLE>
					</c:otherwise>
				</c:choose>
			</tr>
			</br></br>
			<tr>
				<td><b>Messages in Recieve Queue Details</b></td>
				<c:choose>
					<c:when test="${not empty recievedashboardDTO.dashBoardDTOList}">
						<TABLE>
							<TR>
								<TH>Link Name</TH>
								<TH></TH>
								<TH></TH>
								<TH>Message Count</TH>
								<TH></TH>
								<TH></TH>
								<TH>Link Direction</TH>
							</TR>
							<c:forEach var="var2"
								items="${recievedashboardDTO.dashBoardDTOList}">
								<TR>
									<TD>${var2.linkName}</TD>
									<TD></TD>
									<TD></TD>
									<TD>${var2.readyQueueMessagesCount}</TD>
									<TD></TD>
									<TD></TD>
									<TD>${var2.linkDirection}</TD>
								</TR>
							</c:forEach>
						</TABLE>
					</c:when>
					<c:otherwise>
						<TABLE>
							<tr>
								<td><mark>${recievedashBoardEmpty}</mark></td>
							</tr>
						</TABLE>
					</c:otherwise>
				</c:choose>
			</tr>
			</br>
			<tr>
				<td><a href="findByLinkId" id="findByLinkId">Find Messages
						by Link ID</a></td>
			</tr>
			</br>
			<tr>
				<td><a href="findByorigService" id="findByorigService">Find
						Messages by Org Service</a></td>
			</tr>
		</table>
	</form>
</body>
</html>