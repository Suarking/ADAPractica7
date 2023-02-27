package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addToList
 */
@WebServlet("/addToList")
public class addToList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

        // Obtener el título del libro seleccionado
        String title = request.getParameter("title");

        // Obtener la lista de la compra actual (o crear una nueva si no existe)
        List<String> listaCompra = (List<String>) session.getAttribute("listaCompra");
        if (listaCompra == null) {
            listaCompra = new ArrayList<String>();
        }

        // Agregar el título del libro a la lista de la compra
        listaCompra.add(title);

        // Guardar la lista de la compra actualizada en la sesión
        session.setAttribute("listaCompra", listaCompra);

        // Redirigir al usuario a la página
        response.sendRedirect(request.getContextPath() + "/userListBooks.jsp");
    }

}
