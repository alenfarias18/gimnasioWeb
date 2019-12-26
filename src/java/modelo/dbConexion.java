package modelo;
public class dbConexion {
    private String servidor;
    private String db;
    private String usuario;
    private String url;
    private String driver;
    private String clave;
    
    public dbConexion(){
        this.servidor = "localhost";
        this.db = "gimnasiodb";
        this.usuario = "root";
        this.clave = "";
        this.url = "jdbc:mysql://localhost:3306/gimnasiodb";
        this.driver = "com.mysql.jdbc.Driver";
        
    }
    
    public String getServidor() {
        return servidor;
    }

    public String getdb() {
        return db;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }
    
    public String getDriver(){
        return driver;
    }
    public String getUrl(){
        return url;
    }
    
           
    
    
}
