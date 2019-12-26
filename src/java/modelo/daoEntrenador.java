
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.entrenador;
import dao.persona;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daoEntrenador implements operaciones{
dbConexion dbConexion = new dbConexion();
private String clausulaWhere;
    @Override
    public String insertar(Object obj) {
       
        String respuesta = "";
        entrenador entrenador  =  (entrenador) obj;
        Connection connection;
        PreparedStatement pst;
        String query = "INSERT INTO tblentrenador VALUES (?,?)";
        try{
              Class.forName(dbConexion.getDriver());//recupero el Driver.
              connection =  (Connection) DriverManager.getConnection(dbConexion.getUrl(),dbConexion.getUsuario(),dbConexion.getClave());
              pst = (PreparedStatement) connection.prepareStatement(query);
              //luego de tener todo preparado, cargamos con los valores.
              pst.setString(1, entrenador.getUsuario());
              pst.setInt(2, entrenador.getProfesion());
  
              
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
   
        public void setClausulaWhere(String clausulaWhere){
       this.clausulaWhere = clausulaWhere;
    }
    public String getClausulaWhere(){
        return clausulaWhere;
    }
    @Override
    public List<?> listar() {
        List<entrenador> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;// Result Set permite recorrer el arreglo.
        String query = "SELECT * FROM tblentrenador "+getClausulaWhere(); 
        try {
            Class.forName(dbConexion.getDriver());
            // string de conexion.
            con = (Connection) DriverManager.getConnection(dbConexion.getUrl(), dbConexion.getUsuario(), dbConexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            //recorrer el resultSet.
            while(rs.next()){
            // vamos a tener una "fila" del arreglo.
                datos.add(new entrenador(rs.getString("usuario"),rs.getInt("idprofesion")));
            
            }
        } catch (ClassNotFoundException | SQLException e) {
           String error =  e.getMessage();
        }
        
        return datos;
    }

    @Override
    public String eliminar(Object obj) {
        Connection connection;
        PreparedStatement pst;
        String respuesta = "";
        String query = "DELETE FROM tblentrenador "+getClausulaWhere();
        try{
              Class.forName(dbConexion.getDriver());//recupero el Driver.
              connection =  (Connection) DriverManager.getConnection(dbConexion.getUrl(),dbConexion.getUsuario(),dbConexion.getClave());
              pst = (PreparedStatement) connection.prepareStatement(query);
              //luego de tener todo preparado, cargamos con los valores.              
              int nFilas = pst.executeUpdate();
              connection.close();
              
              if(nFilas>0){
                   respuesta = "Registro eliminado con exito";
              }
              else{
                   respuesta = "Error al eliminar";
              }
            
        }
        catch ( ClassNotFoundException  |  SQLException e) {
            e.getMessage();
        }
          return respuesta;
    }

    @Override
    public String actualizar(Object obj) {
                   
              String respuesta = "";
        Connection connection;
        PreparedStatement pst;
        String query = "update tblentrenador set idprofesion=? "+getClausulaWhere();
        try{
              Class.forName(dbConexion.getDriver());//recupero el Driver.
              connection =  (Connection) DriverManager.getConnection(dbConexion.getUrl(),dbConexion.getUsuario(),dbConexion.getClave());
              pst = (PreparedStatement) connection.prepareStatement(query);
              //luego de tener todo preparado, cargamos con los valores.
              pst.setInt(1, Integer.parseInt(obj.toString()));

              
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
