    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title> Form Submission Success</title>
</head>
<body>
   <div style ="text-align:center;color:#0000FF">
   New Bank Acount succesfully Added to the Table
   </div>
   <br>
   
   <div style ="text-align:center">
Click Below to go to List BankAccounts
</div>
   <form:form method="GET" action="/bankingapp/bankAccount/listBankAccount.html">

    <div style ="text-align:center">
    <input type="submit" value="Bank Account Table Page"/>
     </div>
     </form:form>
</body>
</html>