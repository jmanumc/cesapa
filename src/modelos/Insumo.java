package modelos;

/**
 *
 * @author Otro
 */
public class Insumo {
    private Integer id;
    private int renglon;
    private String clave;
    private String descripcion;
    private String unidadMedida;
    private String parametro;
    
    public Insumo(Integer id, int renglon, String clave, String descripcion, String unidadMedida, String parametro) {
        this.id= id;
        this.renglon = renglon;
        this.clave = clave;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.parametro = parametro;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public int getRenglon() {
        return this.renglon;
    }
    
    public String getClave() {
       return this.clave;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public String getUnidadMedida() {
        return this.unidadMedida;
    }
    
    public String getParametro() {
        return this.parametro;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
}
