package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Usuario;

/**
 * 
 * @author Juan Manuel Mc <j-manuel_mtz23 at hotmail.com>
 */
public class UsuarioServicio {
    private final String tabla = "usuarios";
    
    public void guardar(Connection conexion, Usuario usuario) throws SQLException {
        try {
            PreparedStatement consulta;
            
            if (usuario.getId() == null) {
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(correo_electronico, contrasenia, nombre, tipo) VALUES(?, ?, ?, ?)");
                consulta.setString(1, usuario.getCorreoElectronico());
                consulta.setString(2, usuario.getContrasenia());
                consulta.setString(3, usuario.getNombre());
                consulta.setString(4, usuario.getTipo());
            } else {
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET correo_electronico = ?, contrasenia = ?, nombre = ?, tipo = ?, WHERE id = ?");
                consulta.setString(1, usuario.getCorreoElectronico());
                consulta.setString(2, usuario.getContrasenia());
                consulta.setString(3, usuario.getNombre());
                consulta.setString(4, usuario.getTipo());
                consulta.setInt(5, usuario.getId());
            }
            
            consulta.executeUpdate();
        } catch(SQLException e) {
            throw new SQLException(e);
        }
    }
    
    public Usuario obtenerPorId(Connection conexion, int id) throws SQLException {
        Usuario usuario = null;
        
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " WHERE id = ?");
            consulta.setInt(1, id);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                usuario = new Usuario(id, resultado.getString("correo_electronico"), resultado.getString("contrasenia"), resultado.getString("nombre"), resultado.getString("tipo"));
            }
        } catch(SQLException e) {
            throw new SQLException(e);
        }
        
        return usuario;
    }
    
    public void eliminar(Connection conexion, Usuario usuario) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id = ?");
            consulta.setInt(1, usuario.getId());
            consulta.executeUpdate();
        } catch(SQLException e) {
            throw new SQLException(e);
        }
    }
    
    public List<Usuario> obtenerTodas(Connection conexion) throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " ORDER BY id");
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                usuarios.add(new Usuario(resultado.getInt("id"), resultado.getString("correo_electronico"), resultado.getString("contrasenia"), resultado.getString("nombre"), resultado.getString("tipo")));
            }
        } catch(SQLException e) {
            throw new SQLException(e);
        }
        
        return usuarios;
    }
}
