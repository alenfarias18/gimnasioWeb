
package dao;
public class persona {
    private String usuario,nombre,apellidoPat,apellidoMat,clave;
    
    public persona(String usuario, String nombre , String apellidoPat, String apellidoMat,String clave){
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.clave = clave;
    }
    public String getClave(){
        return clave;
    }
    
    public void setClave(String clave){
        this.clave = clave;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }
    
}
