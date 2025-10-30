<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link href="<c:url value="/styles/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/styles/main.css" />" rel="stylesheet">

</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-12">
			<h3 class="text-center">Employee Management</h3>
			<hr />
			<div class="row" style="float: right;">
				<div class="col-md-offset-1 col-12">
					<form method="get" action="<c:url value="/employees/search" /> ">
					    <input type="text" name="kw" /> &nbsp;
				        <input type="submit" value="Search" class="btn btn-secondary" />
				        <a href = "<c:url value="/employees/showForm" />" class="btn btn-primary">Add Employee</a>  <br /> <br />
				    </form>
				</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Employee List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Gender</th>
							<th>Date of birth</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Address</th>
							<th>Action</th>
						</tr>

						<!-- loop over and print our customers -->
						<c:if test="${employees !=null }">
						<c:forEach var="employee" items="${employees}">

							<!-- construct an "update" link with employee id -->
							<c:url var="updateLink" value="/employees/update">
								<c:param name="employeeId" value="${employee.id}" />
							</c:url>

							<!-- construct an "delete" link with employee id -->
							<c:url var="deleteLink" value="/employees/delete">
								<c:param name="employeeId" value="${employee.id}" />
							</c:url>

							<tr>
								<td>${employee.firstName}</td>
								<td>${employee.lastName}</td>
								<td>${employee.gender}</td>
								<td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${employee.dob}" /></td>
								<td>${employee.email}</td>
								<td>${employee.phone}</td>
								<td>${employee.address.name}</td>
								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>
						</c:if>
					</table>
					 <div <c:if test="${totalPages > 1}" /> class="row" >
					    <nav>
					    	<ul class="pagination justify-content-end">
					    		 <c:forEach var="i" begin="1" end="${totalPages}">
					    		 	
							    	<c:choose>
							    		<c:when test="${currentPage != i}">
							    			<li class="page-item">
							    			<a class="page-link" href="<c:url value='/employees/page/${i}?sortBy=${sortBy}&sortDirection=${sortDirection}' />" >${i}</a>
							    			</li>
							    		</c:when>
							    		<c:when test="${currentPage == i}">
							    			<li class="page-item active" aria-current="page">
										      <span class="page-link">${i}</span>
										    </li>
							    		</c:when>
							    	   	</c:choose>
							    	
							    </c:forEach>
					     
					    	</ul>
					    </nav>
					</div>
				</div>
			</div>
		</div>
	</div><!-- ./container -->

</body>
</html>