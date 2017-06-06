package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Juan Manuel Mc <j-manuel_mtz23 at hotmail.com>
 */
public class Conexion {
    public static Connection conexion;
    
    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/cesapa", "root", "");
            } catch (SQLException e) {
                throw new SQLException(e);
            } catch (ClassNotFoundException e) {
                throw new ClassNotFoundException(e.getMessage());
            }
        }
        
        return conexion;
    }
    
    public static void cerrar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
