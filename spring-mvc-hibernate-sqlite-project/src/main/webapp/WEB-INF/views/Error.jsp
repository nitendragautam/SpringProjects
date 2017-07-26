<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Error Page</title>
</head>
<body>
<H3>Error!</H3>

<c:out value="${message}" default="No further information was provided."/>
</body>
</html>