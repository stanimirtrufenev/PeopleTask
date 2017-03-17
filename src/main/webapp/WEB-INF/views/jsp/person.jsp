<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Application</title>
</head>
<body>

	<div id="container" style="color: #919191">
		<div style="background-color: #232323">
			<div class="beauty">
				<br> <br>

			</div>

			<div id="list">
				<c:choose>
					<c:when test="${not empty list}">
						<%
							int count = 0;
						%>
						<c:forEach items="${list}" var="entry">
							<%
								if (count % 6 == 0) {
							%>
							<br>
							<br>
							<%
								}
							%>

							<table>
								<tr>
									<th>${item}</th>
									<%=count++%>
									<th></th>
								</tr>
							</table>

						</c:forEach>
					</c:when>

				</c:choose>
			</div>

			<div id="intro"></div>
		</div>
	</div>
</body>
</html>