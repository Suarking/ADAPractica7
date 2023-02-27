package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author fn7se
 */
public class ConnectionUtil {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/libreria?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="1234";
    private static Connection  jdbcConnection;
    
    public static Connection getConnection() throws SQLException{
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		}
        return jdbcConnection;
    }
    
    public static void closeConnection(ResultSet rs){
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void closeConnection(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   

}
