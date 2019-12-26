/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.entrenador;
import dao.persona;
import dao.usuario;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farias
 */
public class daoUsuario implements operaciones {
    private String usuario;
   private String clausulaWhere;
      dbConexion dbConexion = new dbConexion();
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
    public String insertar(Object obj) {
     
        String respuesta = "";
        usuario usuario =  (usuario) obj;
        
        Connection connection;
        PreparedStatement pst;
        String query = "INSERT INTO tblusuario VALUES (?,?,?,?)";
        try{
              Class.forName(dbConexion.getDriver());//recupero el Driver.
              connection =  (Connection) DriverManager.getConnection(dbConexion.getUrl(),dbConexion.getUsuario(),dbConexion.getClave());
              pst = (PreparedStatement) connection.prepareStatement(query);
              //luego de tener todo preparado, cargamos con los valores.
              pst.setString(1, getUsuario());
              pst.setInt(2, usuario.getGenero()  );
              pst.setString(3, usuario.getFechaIngreso());
              pst.setString(4, usuario.getFechaNacimiento());
          
              
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

    
    
    @Override
    public List<?> listar() {
        List<usuario> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;// Result Set permite recorrer el arreglo.
        String query = "SELECT * FROM tblusuario "+getClausulaWhere(); 
        try {
            Class.forName(dbConexion.getDriver());
            // string de conexion.
            con = (Connection) DriverManager.getConnection(dbConexion.getUrl(), dbConexion.getUsuario(), dbConexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            //recorrer el resultSet.
            while(rs.next()){
            // vamos a tener una "fila" del arreglo.
                datos.add(new usuario(rs.getString("fechaNacimiento"),rs.getString("fechaIngreso"),rs.getInt("idgenero")));
            
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
        String query = "DELETE FROM tblusuario "+getClausulaWhere();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
