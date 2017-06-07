package controladores;

import java.sql.SQLException;
import java.util.List;
import modelos.Insumo;
import servicios.Conexion;
import servicios.InsumoServicio;

/**
 * 
 * @author Juan Manuel Mc <j-manuel_mtz23 at hotmail.com>
 */
public class InsumosControlador {
    private InsumoServicio insumoServicio;
    
    public InsumosControlador() {
        this.insumoServicio = new InsumoServicio();
    }
    
    public void abrirConexion() throws SQLException, ClassNotFoundException {
        try {
            Conexion.obtener();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException(ex.getMessage());
        }
    }
    
    public List<Insumo> index() throws SQLException {
       return insumoServicio.obtenerTodas(Conexion.conexion);
    }
    
    public List<Insumo> index(String busqueda) throws SQLException {
        return insumoServicio.buscar(Conexion.conexion, busqueda);
    }
}
