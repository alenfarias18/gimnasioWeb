
package dao;
public class entrenador {
        private String usuario;
    
        private int profesion;
    public entrenador(String usuario, int profesion){
     this.usuario = usuario;
     this.profesion = profesion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getProfesion() {
        return profesion;
    }

    public void setProfesion(int idProfesion) {
        this.profesion = idProfesion;
                
        
                }
    
}
