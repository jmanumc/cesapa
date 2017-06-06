package modelos;

/**
 * 
 * @author Juan Manuel Mc <j-manuel_mtz23 at hotmail.com>
 */
public class Usuario {
    private Integer id;
    private String correoElectronico;
    private String contrasenia;
    private String nombre;
    private String tipo;
    
    public Usuario(Integer id, String correoElectronico, String contrasenia, String nombre, String tipo) {
        this.id = id;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public String getContrasenia() {
        return this.contrasenia;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "Usuario("+ this.id +", "+ this.correoElectronico +", "+ this.nombre +", "+ this.tipo +")";
    }
}
