package controladores;

import java.sql.SQLException;
import modelos.Usuario;
import servicios.Conexion;
import servicios.InicioSesionServicio;

/**
 * 
 * @author Juan Manuel Mc <j-manuel_mtz23 at hotmail.com>
 */
public class InicioSesionControlador {
    private String correoElectronico;
    private String contrasenia;
    private Usuario usuario;
    
    public void obtenerConexion() throws SQLException, ClassNotFoundException {
        try {
            Conexion.obtener();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException(ex.getMessage());
        }
    }
    
    public void validarDatos(String correoElectronico, String contrasenia) throws Exception {
        correoElectronico = correoElectronico.trim();
        contrasenia = contrasenia.trim();
        
        if (correoElectronico.isEmpty()) {
            throw new Exception("El correo electronico es invalido.");
        }
        
        if (contrasenia.isEmpty()) {
            throw new Exception("La contraseña es invalida.");
        }
        
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }
    
    public void obtenerUsuario() throws SQLException {
        InicioSesionServicio inicioSesionServicio = new InicioSesionServicio();
        
        try {
            usuario = inicioSesionServicio.iniciarSesion(Conexion.conexion, correoElectronico, contrasenia);
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    public void validarRespuesta() throws Exception {
        if (usuario == null) {
            throw new Exception("El correo electronico/contraseña incorrectos.");
        }
    }
}
