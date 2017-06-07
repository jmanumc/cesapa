package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Insumo;

/**
 *
 * @author Juan Manuel Mc <j-manuel_mtz23 at hotmail.com>
 */
public class InsumoServicio {
    public final String tabla = "insumos";
    
    public void guardar(Connection conexion, Insumo insumo) throws SQLException {
        try {
            PreparedStatement consulta;
            
            if (insumo.getId() == null) {
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(renglon, clave, descripcion, unidad_medida, parametro) VALUES(?, ?, ?, ?, ?)");
                consulta.setInt(1, insumo.getRenglon());
                consulta.setString(2, insumo.getClave());
                consulta.setString(3, insumo.getDescripcion());
                consulta.setString(4, insumo.getUnidadMedida());
                consulta.setString(5, insumo.getParametro());
            } else {
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET renglon = ?, clave = ?, descripcion = ?, unidad_medida = ?, parametro = ?, WHERE id = ?");
                consulta.setInt(1, insumo.getRenglon());
                consulta.setString(2, insumo.getClave());
                consulta.setString(3, insumo.getDescripcion());
                consulta.setString(4, insumo.getUnidadMedida());
                consulta.setString(5, insumo.getParametro());
                consulta.setInt(5, insumo.getId());
            }
            
            consulta.executeUpdate();
        } catch(SQLException e) {
            throw new SQLException(e);
        }
    }
    
    public Insumo obtenerPorId(Connection conexion, int id) throws SQLException {
        Insumo insumo = null;
        
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " WHERE id = ?");
            consulta.setInt(1, id);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                insumo = new Insumo(id, resultado.getInt("renglon"), resultado.getString("clave"), resultado.getString("descripcion"), resultado.getString("unidad_medida"), resultado.getString("parametro"));
            }
        } catch(SQLException e) {
            throw new SQLException(e);
        }
        
        return insumo;
    }
    
    public void eliminar(Connection conexion, Insumo insumo) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id = ?");
            consulta.setInt(1, insumo.getId());
            consulta.executeUpdate();
        } catch(SQLException e) {
            throw new SQLException(e);
        }
    }
    
    public List<Insumo> obtenerTodas(Connection conexion) throws SQLException {
        List<Insumo> insumos = new ArrayList<>();
        
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " ORDER BY id");
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                insumos.add(new Insumo(resultado.getInt("id"), resultado.getInt("renglon"), resultado.getString("clave"), resultado.getString("descripcion"), resultado.getString("unidad_medida"), resultado.getString("parametro")));
            }
        } catch(SQLException e) {
            throw new SQLException(e);
        }
        
        return insumos;
    }
    
    public List<Insumo> buscar(Connection conexion, String busqueda) throws SQLException {
        List<Insumo> insumos = new ArrayList<>();
        
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " WHERE descripcion LIKE '%"+ busqueda +"%'");
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                insumos.add(new Insumo(resultado.getInt("id"), resultado.getInt("renglon"), resultado.getString("clave"), resultado.getString("descripcion"), resultado.getString("unidad_medida"), resultado.getString("parametro")));
            }
        } catch(SQLException e) {
            throw new SQLException(e);
        }
        
        return insumos;
    }
}
