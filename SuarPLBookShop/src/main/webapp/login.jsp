<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SPL BookShop</title>
<!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"> 
<link rel="stylesheet" href="css/login_style.css">
</head>
<body>
	<header>
		<h1>
			<a href="#" class="logo">SPL BookShop</a>
		</h1>
	</header>
	<form class="box" action="LoginServlet" method="post">
		<h1>Login</h1>
		<input type="text" name="uname" placeholder="Usuario"> <input
			type="password" name="upassword" placeholder="Contraseña"> <input
			type="submit" name="" value="login">
	</form>
	<jsp:include page="WEB-INF/pages/common/footer.jsp"></jsp:include>
</body>
</html>