<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.test.dao.*"%>
<%@page import=" com.test.pojo.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
<title>EazyKart</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="index.jsp" class="navbar-brand"> Register </a>
			</div>

			
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Couriers</h3>
			
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>City</th>
						<th>Mobile</th>
						<th>Destination</th>
						<th>Weight</th>		
						<th>Distance</th>
						<th>Cost</th>
						<th>OrderDate</th>
						<th>DeliveryDate</th>
						<th>TrackingNo</th>
										
					</tr>
				</thead>
				<tbody>
					<%
				CourierDao obj = new CourierDao(); 
			List<Courier> list = obj.selectAllCouriers();
				for (Courier courier : list) {
					%>
					<tr>
					<td><%=courier.getId() %></td>
					<td><%=courier.getName()%></td>
					<td><%=courier.getCity() %></td>
					<td><%=courier.getMobile() %></td>
					<td><%=courier.getArea() %></td>
					<td><%=courier.getWeight() %></td>
					<td><%=courier.getDistance() %></td>
					<td><%=courier.getCost() %></td>   
					<td><%=courier.getOrderDate() %></td>
					<td><%=courier.getDeliveryDate() %></td>
					<td><%=courier.getTrackingNo() %></td>
					</tr>
					
					
					<%
				}
			%>
					
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>