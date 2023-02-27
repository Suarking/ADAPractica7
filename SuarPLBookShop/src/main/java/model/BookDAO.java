package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fn7se
 */
public class BookDAO {
    
    //Statements CRUD
    private static final String SQL_SELECT = "SELECT * FROM book";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM book where id = ?";
    private static final String SQL_INSERT = "INSERT INTO book (title, author, editorial, yearb) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM book where id = ?";
    private static final String SQL_UPDATE = "UPDATE book SET title = ?, author = ?, editorial = ?, yearb = ? WHERE id = ?";
    
    
	

	
	public List<Book> listAllBooks() throws SQLException {
		List<Book> listBook = new ArrayList<>();
                Connection conn = null;
                PreparedStatement stmt=null;
		ResultSet rs=null;
                Book book = null;
                
                try {
                conn=ConnectionUtil.getConnection();
                stmt=conn.prepareStatement(SQL_SELECT);
                rs=stmt.executeQuery();
                while (rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			String editorial = rs.getString("editorial");
			Integer year = rs.getInt("yearb");
			
			book = new Book(id, title, author, editorial, year);
			listBook.add(book);
		}
                
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                    if (conn!=null) {
                        conn.close();
                    }else if(rs!=null){
                        rs.close();
                    }else if(stmt!=null){
                        stmt.close();
                    }
                }
		
		return listBook;
	}
        
        public Book findBookByID(Book book) throws SQLException{
            
                Connection conn = null;
                PreparedStatement stmt=null;
		ResultSet rs=null;
                
                
                try {
                conn=ConnectionUtil.getConnection();
                stmt=conn.prepareStatement(SQL_FIND_BY_ID);
                stmt.setInt(1, book.getId());
                rs=stmt.executeQuery();
                rs.next();
      
			String title = rs.getString("title");
			String author = rs.getString("author");
			String editorial = rs.getString("editorial");
			Integer year = rs.getInt("yearb");
			
			book.setTitle(title);
                        book.setAuthor(author);
                        book.setEditorial(editorial);
                        book.setYear(year);
          
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                    if (conn!=null) {
                        conn.close();
                    }else if(rs!=null){
                        rs.close();
                    }else if(stmt!=null){
                        stmt.close();
                    }
                }
		
		return book;
            
        }
        	public int insertBook(Book book) throws SQLException {
                Connection conn = null;
                PreparedStatement stmt=null;
		int rows =0;
                             
                try {
                conn=ConnectionUtil.getConnection();
                stmt=conn.prepareStatement(SQL_INSERT);
                stmt.setString(1, book.getTitle());
                stmt.setString(2, book.getAuthor());
                stmt.setString(3, book.getEditorial());
                stmt.setInt(4, book.getYear());
                
                rows=stmt.executeUpdate();
                
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                    if (conn!=null) {
                        conn.close();
                    }else if(stmt!=null){
                        stmt.close();
                    }
                }
		
		return rows;
	}
	
	public int deleteBook(Book book) throws SQLException {
		Connection conn = null;
                PreparedStatement stmt=null;
		int rows =0;
                             
                try {
                conn=ConnectionUtil.getConnection();
                stmt=conn.prepareStatement(SQL_DELETE);
                stmt.setInt(1, book.getId());
                
                rows=stmt.executeUpdate();
                
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                    if (conn!=null) {
                        conn.close();
                    }else if(stmt!=null){
                        stmt.close();
                    }
                }
		
		return rows;			
	}
	
	public int updateBook(Book book) throws SQLException {
		Connection conn = null;
                PreparedStatement stmt=null;
		int rows =0;
                             
                try {
                conn=ConnectionUtil.getConnection();
                stmt=conn.prepareStatement(SQL_UPDATE);
                stmt.setString(1, book.getTitle());
                stmt.setString(2, book.getAuthor());
                stmt.setString(3, book.getEditorial());
                stmt.setInt(4, book.getYear());
                stmt.setInt(5, book.getId());
                
                rows=stmt.executeUpdate();
                
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                    if (conn!=null) {
                        conn.close();
                    }else if(stmt!=null){
                        stmt.close();
                    }
                }
		
		return rows;		
	}
	
}
