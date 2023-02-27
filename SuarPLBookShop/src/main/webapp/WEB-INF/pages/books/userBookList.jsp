<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="books">
	<div class="container">
		<div class="row">

			<div class="col-md-8">
				<div class="card">
					<div class="card-header">
						<h4>Listado de Libros</h4>
					</div>
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>ID</th>
								<th>Titulo</th>
								<th>Autor</th>
								<th>Editorial</th>
								<th>Año</th>
								<th>Acciones</th>
							</tr>

						</thead>
						<tbody>

							<c:forEach var="book" items="${listBooks}" varStatus="status">
								<tr>
								<tr>
									<td><c:out value="${book.id}" /></td>
									<td><c:out value="${book.title}" /></td>
									<td><c:out value="${book.author}" /></td>
									<td><c:out value="${book.editorial}" /></td>
									<td><c:out value="${book.year}" /></td>
									<td>
										<form method="post"
											action="${pageContext.request.contextPath}/addToList">
											<input type="hidden" name="title" value="${book.title}">
											<input type="submit" value="Agregar al carrito">
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>




			<!-- Totales -->
			<div class="col-md-4">
				<div class="card text-center mb-3">
					<div class="card-body">
						<i class="fas fa-shopping-cart">   Carrito</i>
						<c:if test="${empty listaCompra}">
							<p>No hay libros en el carrito.</p>
						</c:if>
						<c:if test="${not empty listaCompra}">
							<ul>
								<c:forEach items="${listaCompra}" var="bookTitle">
									<li>${bookTitle}</li>
								</c:forEach>
							</ul>
						</c:if>
						<form method="post" action="clearList">
							<button type="submit">Vaciar carrito</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
