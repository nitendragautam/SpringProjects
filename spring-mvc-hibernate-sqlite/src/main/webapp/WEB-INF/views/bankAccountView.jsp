<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html >
<html>
<head>
	
<script src="<c:url value="/resources/js/lib/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/lib/jquery.min.js"/>"></script>
<link href="<c:url value="/resources/css/cssbankActsList.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/lib/bootstrap.min.css"/>"
	rel="stylesheet" />	

<link href="<c:url value="/resources/css/pagination.css"/>"
	rel="stylesheet" />	
	
<title>Bank Accounts Display</title>


</head>
<body>
		
	<br>
	<h3>Bank Account Table</h3>
	
	<form:form method="post" action="/bankingapp/bankAccount/searchBankAccounts.html">

    <div style ="text-align:center;color:#0000FF">
    <input type="text" name="searchString" />
     <button type="submit">Search Last Name</button>
     </div>
</form:form>

	
	
	<form>
	<a class ="addbutton" href="<c:url value='/bankAccount/add.html'/>">Add Bank Account</a>
	</form>
	<%-- // use our pagedListHolder --%>
<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder"/>
	<%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
<c:url value='/bankAccount/searchBankAccounts.html' var='pagedLink'>

	<c:param name='action' value='list'/>
    <c:param name='p' value='~'/>
</c:url>
<%-- // load our paging tag, pass pagedListHolder and the link --%>
<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}"/>

<%--Division for Table --%>
<div class = "table-responsive">
	<table class="table table-hover table-condensed"  >
	
	<thead>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Phone Number</th>
			<th>Email Address</th>
			<th>Residental Address</th>
			<th>Account Balance</th>
			<th>Opening Date</th>
			<th>Modified Date</th>
			
			</tr>
			</thead>
			<c:forEach items="${pagedListHolder.pageList}" var="bankAct">
				<tbody>
				<tr>
					<td>${bankAct.id}</td>
					<td>${bankAct.firstName}</td>
					<td>${bankAct.lastName}</td>
					<td>${bankAct.phoneNumber}</td>
					<td>${bankAct.emailAddress}</td>
					<td>${bankAct.residentalAddress}</td>
					<td>${bankAct.currentAccountBalance}</td>
					<td>${bankAct.openingDate}</td>
					<td>${bankAct.modifiedDate}</td>
					
					<td><a href="<c:url value='/edit/${bankAct.id}' />">Edit</a></td>
					<td><a href="<c:url value='/delete/${bankAct.id}' />">Delete</a></td>
				</tr>
              </tbody>
			</c:forEach>
			</table>
	
</div>
	<%-- // load our paging tag, pass pagedListHolder and the link --%>
<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}"/>
	
	  
	
    
	
</body>
</html>