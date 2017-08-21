/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author diego
 */
public class ProductModel {
    private ProductModel(){}
    public static ProductModel getInstance(){
        if(pdInstance == null){
            pdInstance = new ProductModel();
        }
        return pdInstance;
    }
    
    private static ProductModel pdInstance;
    
    Connector conector = Connector.getInstance();
    String url = conector.getUrl();
    String login = conector.getLogin();
    String password = conector.getPassword();
    Connection conn = null;
    
    //Lista los productos
    public List<List<String>> listarProductos(){
        List<List<String>> data = new ArrayList<>();         
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT cod_prod, nom_prod, des_prod, prec_prod,"
                    + " cant_prod FROM Productos ORDER BY cod_prod");
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                String estcod = res.getString("cod_prod");
                String estnom = res.getString("nom_prod");
                String estdes = res.getString("des_prod");
                String estprec = res.getString("prec_prod");
                String estcant = res.getString("cant_prod");
                data.add(Arrays.asList(estcod, estnom, estdes, estprec, estcant));
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){}
        return data;
    }
}
