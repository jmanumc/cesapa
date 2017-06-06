package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
