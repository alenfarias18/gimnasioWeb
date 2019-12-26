/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.genero;
import dao.persona;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farias
 */
public class daoGenero implements operaciones{
    dbConexion dbConexion = new dbConexion();
    private int idGenero;

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
    
    @Override
    public String insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> listar() {
        List<genero> datos = new ArrayList<>();
        
        Connection con;
        PreparedStatement pst;
        ResultSet rs;// Result Set permite recorrer el arreglo.
        String query = "SELECT idgenero FROM tblgenero WHERE idgenero = "+getIdGenero(); 
        try {
            Class.forName(dbConexion.getDriver());
            // string de conexion.
            con = (Connection) DriverManager.getConnection(dbConexion.getUrl(), dbConexion.getUsuario(), dbConexion.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            //recorrer el resultSet.
            while(rs.next()){
            // vamos a tener una "fila" del arreglo.
                datos.add(new genero(rs.getInt("idgenero")));
            
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
