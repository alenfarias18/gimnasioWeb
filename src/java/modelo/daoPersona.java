
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.persona;
import dao.usuario;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
    
public class daoPersona implements operaciones {
    private String usuario;
     private String clausulaWhere="";
    dbConexion dbConexion = new dbConexion();
    @Override
    public String insertar(Object obj) {
    
        String respuesta = "";
        persona persona =  (persona) obj;
        Connection connection;
        PreparedStatement pst;
        String query = "INSERT INTO tblpersona VALUES (?,?,?,?,?)";
        try{
              Class.forName(dbConexion.getDriver());//recupero el Driver.
              connection =  (Connection) DriverManager.getConnection(dbConexion.getUrl(),dbConexion.getUsuario(),dbConexion.getClave());
              pst = (PreparedStatement) connection.prepareStatement(query);
              //luego de tener todo preparado, cargamos con los valores.
              pst.setString(1, persona.getUsuario());
              pst.setString(2, persona.getClave());
              pst.setString(3, persona.getNombre());
              pst.setString(4, persona.getApellidoPat());
              pst.setString(5, persona.getApellidoMat());
              
              int nFilas = pst.executeUpdate();
              connection.close();
              
              if(nFilas>0){
                   respuesta = "Registro insertado con exito";
              }
              else{
                   respuesta = "Error al insertar";
              }
            
        }
        catch ( ClassNotFoundException  |  SQLException e) {
            e.getMessage();
        }
          return respuesta;
    }

    
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
        public void setClausulaWhere(String clausulaWhere){
       this.clausulaWhere = clausulaWhere;
    }
    public String getClausulaWhere(){
        return clausulaWhere;
    }
    @Override
    public List<persona> listar() {
        List<persona> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;// Result Set permite recorrer el arreglo.
        String query = "SELECT * FROM tblpersona "+getClausulaWhere(); 
        try {
            Class.forName(dbConexion.getDriver());
            // string de conexion.
            con = (Connection) DriverManager.getConnection(dbConexion.getUrl(), dbConexion.getUsuario(), dbConexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            //recorrer el resultSet.
            while(rs.next()){
            // vamos a tener una "fila" del arreglo.
                datos.add(new persona(rs.getString("usuario"),rs.getString("clave"),rs.getString("nombre"),rs.getString("apellidopaterno"),rs.getString("apellidomaterno")));
            
            }
        } catch (ClassNotFoundException | SQLException e) {
           String error =  e.getMessage();
        }
        
        return datos;
    }

    @Override
    public String eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public String actualizar(Object obj) {
               
              String respuesta = "";
        Connection connection;
        PreparedStatement pst;
        String query = "update tblpersona set clave=? "+getClausulaWhere();
        try{
              Class.forName(dbConexion.getDriver());//recupero el Driver.
              connection =  (Connection) DriverManager.getConnection(dbConexion.getUrl(),dbConexion.getUsuario(),dbConexion.getClave());
              pst = (PreparedStatement) connection.prepareStatement(query);
              //luego de tener todo preparado, cargamos con los valores.
              pst.setString(1, obj.toString());

              
              int nFilas = pst.executeUpdate();
              connection.close();
              
              if(nFilas>0){
                   respuesta = "Registro actualizado con exito";
              }
              else{
                   respuesta = "Error al actualizar";
              }
            
        }
        catch ( ClassNotFoundException  |  SQLException e) {
            e.getMessage();
        }
          return respuesta;
    }
    
}
