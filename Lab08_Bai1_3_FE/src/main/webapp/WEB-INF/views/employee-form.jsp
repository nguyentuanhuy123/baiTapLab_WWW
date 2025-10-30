<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link href="<c:url value="/styles/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/styles/main.css" />" rel="stylesheet">

</head>
<body>

	<div class="container" style="max-width: 600px">
		<span>${error}</span>
		
		<%--@elvariable id="employee" type="java"--%>
		<form:form role="form" action="${pageContext.request.contextPath}/employees/save" method="post" modelAttribute="employee">
			<h2>
			<c:if test="${employee.id == 0 }">
				Registration Employee
			</c:if>
			<c:if test="${employee.id > 0 }">
				Update Employee
			</c:if>
			</h2>
			
			<div class="mb-3 row align-items-center">
				<form:hidden path="id" />
				<form:label path="firstName" cssClass="col-sm-3 control-label">First Name</form:label>
				<div class="col-sm-9">
					<form:input path="firstName" placeholder="First Name" cssClass="form-control" />
					<c:if test="${errors != null && errors.get('firstName') != ''}">
					<span class="error">${errors.get('firstName')}</span>
					</c:if>
					 
				</div>
			</div>
			<div class="mb-3 row align-items-center">
				<form:label path="lastName" cssClass="col-sm-3 control-label">Last Name</form:label>
				<div class="col-sm-9">
					<form:input path="lastName" placeholder="Last Name" cssClass="form-control" />
					<c:if test="${errors != null && errors.get('lastName') != ''}">
					<span class="error">${errors.get('lastName')}</span>
					</c:if>
				</div>
			</div>
			<div class="mb-3 row align-items-center">
				<form:label path="email" cssClass="col-sm-3 control-label">Email</form:label>
				<div class="col-sm-9">
					<form:input type="email" path="email" placeholder="Email" cssClass="form-control" />
					<c:if test="${errors != null && errors.get('emailAddress') != ''}">
					<span class="error">${errors.get('emailAddress')}</span>
					</c:if>
				</div>
			</div>
			<div class="mb-3 row align-items-center">
				<form:label path="dob" class="col-sm-3 control-label">Date of Birth</form:label>
				<div class="col-sm-9">
					<form:input type="date" path="dob" cssClass="form-control" />
					<c:if test="${errors != null && errors.get('dob') != ''}">
					<span class="error">${errors.get('dob')}</span>
					</c:if>
				</div>
			</div>
			<div class="mb-3 row align-items-center">
				<form:label path="phone" cssClass="col-sm-3 control-label">Phone number </form:label>
				<div class="col-sm-9">
					<form:input path="phone" placeholder="Phone number" cssClass="form-control" />
					<c:if test="${errors != null && errors.get('phoneNumber') != ''}">
					<span class="error">${errors.get('phoneNumber')}</span>
					</c:if>
				</div>
			</div>
			<div class="mb-3 row align-items-center">
				<form:label path="gender" class="control-label col-sm-3">Gender</form:label>
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-4">
							<div class="form-check form-check-inline">
								<form:radiobutton cssClass="form-check-input" path="gender" id="male" value="male" label="Male"/> 
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-check form-check-inline">
								<form:radiobutton cssClass="form-check-input" path="gender" id="female" value="female" label="Female" /> 
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="mb-3 row align-items-center">
				<form:label path="address.name" cssClass="col-sm-3 control-label">Address</form:label>
				<div class="col-sm-9">
					<form:input path="address.name" placeholder="Address" class="form-control" />
				</div>
			</div>
			<div class="mb-3 row">
			<div class="col-sm-3"></div>
			<div class="col-sm-9">
			<a href="<c:url value="/employees" /> " class="btn btn-secondary"> Back</a>
			<button type="submit" class="btn btn-primary">Register</button>
			</div>
			</div>
		</form:form>
		<!-- /form -->
	</div>
	<!-- ./container -->

</body>
</html>