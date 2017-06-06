package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Usuario;

/**
 * 
 * @author Juan Manuel Mc <j-manuel_mtz23 at hotmail.com>
 */
public class InicioSesionServicio {
    private final String tabla = "usuarios";
    
    public Usuario iniciarSesion(Connection conexion, String correoElectronico, String contrasenia) throws SQLException {
        Usuario usuario = null;
        
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " WHERE correo_electronico = ? AND contrasenia = ?");
            consulta.setString(1, correoElectronico);
            consulta.setString(2, contrasenia);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                usuario = new Usuario(resultado.getInt("id"), resultado.getString("correo_electronico"), resultado.getString("contrasenia"), resultado.getString("nombre"), resultado.getString("tipo"));
            }
        } catch(SQLException ex) {
            throw new SQLException(ex);
        }
        
        return usuario;
    }
}
