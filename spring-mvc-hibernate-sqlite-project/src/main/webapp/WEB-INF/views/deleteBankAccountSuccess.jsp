<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    
<!DOCTYPE html>
<html>
<head>
<title>Bank Account Details Success Page</title>
</head>
<body>
<div style ="text-align:center">
    BankAccount Successfully Deleted in BankAccount Table
   </div>
   <br>
   
   <div style ="text-align:center">
Click Below to go to List Bank Account Data
</div>
   <form:form method="GET" action="/bankingapp/bankAccount/searchBankAccounts.html">

    <div style ="text-align:center">
    <input type="submit" value="Bank Account Details Page"/>
     </div>
     </form:form>
</body>
</html>