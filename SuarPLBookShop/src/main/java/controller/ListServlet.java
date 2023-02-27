package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.BookDAO;

/**
 *
 * @author fn7se
 */
@WebServlet(name = "ListServlet", urlPatterns = {"/ListServlet"})
public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
		//Mapeamos acción
		String accion =request.getParameter("accion");
		if (accion!=null) {
			switch (accion) {
			case "editar":
				try {
					this.editBook(request,response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "eliminar":
				try {
					this.deleteBook(request,response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				this.defaultAction(request, response);
			}
		}else {
			//Si no hay acción, hace la acción pro defecto
			this.defaultAction(request, response);
		}
	}
             
    
	//Acción por defecto que realiza el servlet
	protected void defaultAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        try {
            List<Book> listBooks = new BookDAO().listAllBooks();
            System.out.println("listBooks : "+ listBooks);
            HttpSession session=request.getSession();
            session.setAttribute("listBooks", listBooks);
            response.sendRedirect("listBooks.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
	
	//Abrir ventana edición
	protected void editBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException  {
		//Pido ID del libro
		int idBook = Integer.parseInt(request.getParameter("id"));
		 
       //Buscamos el libro con esa ID
		Book book = new BookDAO().findBookByID(new Book(idBook));
		request.setAttribute("book", book);
		//Ruta jsp editar libro
		String jspEdit="/WEB-INF/pages/books/bookEdit.jsp";
		request.getRequestDispatcher(jspEdit).forward(request, response);
		
         
    }
	//Modificar el libro
	@SuppressWarnings("unused")
		protected void modBook(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException, SQLException  {
			//Pido ID del libro
			int idBook = Integer.parseInt(request.getParameter("id"));
			//Obtenemos nuevos valores
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String editorial = request.getParameter("editorial");
			int year = 0;
			String yearString = request.getParameter("year");
			if (yearString!=null && !"".equals(yearString)) {
				year = Integer.parseInt(yearString);

			}
			//Creamos cliente con los valores obtenidos
			Book book = new Book(idBook, title, author, editorial, year);
			//Comprobamos si podemos actualizarlo, como el delete, este int actua de booleano			
			int modifiedRegister = new BookDAO().updateBook(book);
			//Volvemos a recargar la lista
			this.defaultAction(request, response);
	         
	    }
		//Modificar el libro
		@SuppressWarnings("unused")
		protected void insertBook(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException, SQLException  {
			//Pido ID del libro
			//int idBook = Integer.parseInt(request.getParameter("id"));
			//Obtenemos nuevos valores
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String editorial = request.getParameter("editorial");
			int year = Integer.parseInt(request.getParameter("year"));
			//Creamos cliente con los valores obtenidos
			Book book = new Book(title, author, editorial, year);
			//Comprobamos si podemos actualizarlo, como el delete, este int actua de booleano
			int modifiedRegister = new BookDAO().insertBook(book);
			//Volvemos a recargar la lista
			this.defaultAction(request, response);
	         
	    }
	
	//Borrar libro
		@SuppressWarnings("unused")
	protected void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException  {
		//Pido ID del libro
		int idBook = Integer.parseInt(request.getParameter("id"));
		 
       //Instanciamos el libro con esa ID
		Book book = new Book(idBook);
		
		//Si el libro se elimina, devuelve 1, si no, 0
		int modifiedRegister = new BookDAO().deleteBook(book);
		//Volvemos a recargar la lista
		this.defaultAction(request, response);
		
         
    }

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
		//Mapeamos acción
		String accion =request.getParameter("accion");
		if (accion!=null) {
			switch (accion) {
			case "insertar":
				try {
					this.insertBook(request, response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "modificar":
				try {
					this.modBook(request, response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "eliminar":
				try {
					this.deleteBook(request, response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				this.defaultAction(request, response);
			}
		}else {
			//Si no hay acción, hace la acción pro defecto
			this.defaultAction(request, response);
		}
	}
}
