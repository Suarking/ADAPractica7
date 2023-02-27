<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="books">
    <div class="container">
        <div class="row">

            <div class="col-md-9">
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
                    						<a href="${pageContext.request.contextPath}/ListServlet?accion=editar&id=${book.id}" class ="btn btn-secondary">
                                                <i class="fas fa-angle-double-right"></i> Editar
                                            </a>                   	
                    					</td>  
                                    </tr>               
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
  </div>
  </section>
  
  <jsp:include page="bookAdd.jsp"/>