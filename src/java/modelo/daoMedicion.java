package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.medicion;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daoMedicion implements operaciones{
  dbConexion dbConexion = new dbConexion();
       private String clausulaWhere="";
    @Override
    public String insertar(Object obj) {
        String respuesta = "";
        medicion medicion  =  (medicion) obj;
        Connection connection;
        PreparedStatement pst;
        String query = "INSERT INTO tblmedicion VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try{
              Class.forName(dbConexion.getDriver());//recupero el Driver.
              connection =  (Connection) DriverManager.getConnection(dbConexion.getUrl(),dbConexion.getUsuario(),dbConexion.getClave());
              pst = (PreparedStatement) connection.prepareStatement(query);
              //luego de tener todo preparado, cargamos con los valores.
              pst.setInt(1, 0);
              pst.setString(2,medicion.getFecha());
              pst.setInt(3, medicion.getEstatura() );
              pst.setInt(4, medicion.getPeso() );
              pst.setInt(5, medicion.getMedidaCintura());
              pst.setFloat(6, medicion.getPorcentajeGrasa());
              pst.setFloat(7, medicion.getImc() );
              pst.setFloat(8, medicion.getIndiceGrasaInstrumento());
              pst.setString(9, medicion.getPathFoto());
              pst.setString(10, medicion.getUsuario());
              pst.setString(11, medicion.getEntrenador() );
              
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
           respuesta =  e.getMessage();
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
         List<medicion> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;// Result Set permite recorrer el arreglo.
        String query = "SELECT idMedicion,fecha,estatura,peso,medidaCintura,PorcentajeGrasaFormula,imc,indiceGrasaInstrumento,foto,personausuario,personaentrenador FROM tblmedicion "+getClausulaWhere(); 
        try {
            Class.forName(dbConexion.getDriver());
            // string de conexion.
            con = (Connection) DriverManager.getConnection(dbConexion.getUrl(), dbConexion.getUsuario(), dbConexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            //recorrer el resultSet.
            while(rs.next()){
            // vamos a tener una "fila" del arreglo.
                datos.add(new medicion(rs.getInt("idMedicion")
                        ,rs.getString("fecha")
                        ,rs.getInt("estatura")
                        ,rs.getInt("peso")
                        ,rs.getInt("medidaCintura")
                        ,rs.getFloat("PorcentajeGrasaFormula")
                        ,rs.getFloat("imc")
                        ,rs.getFloat("indiceGrasaInstrumento")
                        ,rs.getString("foto")
                        ,rs.getString("personausuario")
                        ,rs.getString("personaentrenador")));
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
