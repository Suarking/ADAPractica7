<div class="modal fade" id="addBookModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">Agregar Libro</h5>
                <button class="clse" data-dismiss="modal">
                    <span>&times;</span>
                </button>
        </div>
            
            <form action="${pageContext.request.contextPath}/ListServlet?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="title">Título</label>
                        <input type="text" class="form-control" name="title" required>
                    </div>
                    <div class="form-group">
                        <label for="author">Autor</label>
                        <input type="text" class="form-control" name="author" required>
                    </div>
                    <div class="form-group">
                        <label for="editorial">Editorial</label>
                        <input type="text" class="form-control" name="editorial" required>
                    </div>
                    <div class="form-group">
                        <label for="year">Año</label>
                        <input type="number" class="form-control" name="year" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn-primary" type="submit">Guardar Libro</button>
                   
                    </div>
            
            </form> 
            
        </div>
    </div>
    
</div>