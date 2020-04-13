<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html>
<html>
<head>
<title>Bank Account Data Delete Page</title>


<script src="<c:url value="/resources/js/lib/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/lib/jquery-min.js"/>"></script>



<link  href="<c:url value="/resources/css/css-add-update-dis.css"/>" rel="stylesheet"/>
<link  href="<c:url value="/resources/css/lib/bootstrap.min.css"/>" rel="stylesheet"/>
</head>

<body>

<div class="container">
<h3>Deleting Existing Information</h3>
<c:url var="deleteAction" value="/bankAccount/delete.html" ></c:url>
<form:form class="form-inline" id ="updateform" action="${deleteAction}" 
modelAttribute="bankAct" name="BankAccountForm" method="post">


<c:if test="${!empty bankAct.id}">


<div class="form-group">
					<label for="id">ID</label>
					<form:input path="id" readonly="true" size="8" 
					 disabled ="true" class="form-control" />
					<form:hidden path ="id"/>
					 </div>
			</c:if>

			<div class="form-group">
				<label for="firstName">firstName</label>
				<form:input name="firstName" path="firstName" readonly="true"
				class="form-control" required="true" placeholder="First Name"/>
			    
			</div>

			<div class="form-group">
				<label for="lastName">Last Name</label>
				<form:input name="lastName" path="lastName" readonly="true"
				class="form-control" required="true"
				placeholder="Last Name" />
			</div>

			<div class="form-group">
				<label for="phoneNumber">Phone Number</label>
				<form:input name="phoneNumber" path="phoneNumber" readonly="true"
				 class="form-control" required="true" placeholder="Phone Number" />
			</div>

			<div class="form-group">
				<label for="emailAddress">Email Address</label>
				<form:input name="emailAddress" path="emailAddress" readonly="true"
				class="form-control" required="true"
					placeholder="Email Address" />
			</div>

			<div class="form-group">
				<label for="residentalAddress">Added By</label>
				<form:input name="residentalAddress" path="residentalAddress" readonly="true"
				 class="form-control" required="true" placeholder="Residental Address" />
			   
			</div>
			<div class="form-group">
				<label for="currentAccountBalance">Account Balance</label>
				<form:input name="currentAccountBalance" path="currentAccountBalance" readonly="true"
				 class="form-control" required="true" placeholder="Account Balance" />
			   
			</div>

             <div class="form-group">
			<input type="submit" value="Delete Bank Account" class="btn btn-info" />
            </div>

			</form:form>
	
	</div>
    
     

</body>
</html>