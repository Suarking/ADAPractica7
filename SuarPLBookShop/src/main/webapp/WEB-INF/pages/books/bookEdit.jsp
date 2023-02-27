<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">

<script src="https://kit.fontawesome.com/3556f97ea7.js"
	crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<form
		action="${pageContext.request.contextPath}/ListServlet?accion=modificar&id=${book.id}"
		method="POST" class="was-validated">

		<jsp:include page="../common/navButtonsEdit.jsp"></jsp:include>

		<section id="details">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="card">
							<div class="card-header">
								<h4>Editar Libro</h4>
							</div>
							<div class="card-body">
								<div class="form-group">
									<label for="title">Título</label> <input type="text"
										class="form-control" name="title" required value="${book.title}">
								</div>
								<div class="form-group">
									<label for="author">Autor</label> <input type="text"
										class="form-control" name="author" required value="${book.author}">
								</div>
								<div class="form-group">
									<label for="editorial">Editorial</label> <input type="text"
										class="form-control" name="editorial" required value="${book.editorial}">
								</div>
								<div class="form-group">
									<label for="year">Year</label> <input type="number"
										class="form-control" name="year" required value="${book.year}">
								</div>
							</div>
						</div>		
					</div>
				</div>
			</div>
		</section>

	</form>

</body>
</html>