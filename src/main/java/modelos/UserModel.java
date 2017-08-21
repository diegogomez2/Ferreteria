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

/**
 *
 * @author diego
 */
public class UserModel {
    
    private UserModel(){}
    public static UserModel getInstance(){
        if(usInstance == null){
            usInstance = new UserModel();
        }
        return usInstance;
    }
    
    private static UserModel usInstance;
    
    Connector conector = Connector.getInstance();
    String url = conector.getUrl();
    String login = conector.getLogin();
    String password = conector.getPassword();
    Connection conn = null;
    
    //Verifica que el usuario y contraseña sean correctos
    public int verificarLogin(String rut, String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM Usuarios WHERE name_user = ?");
            pstm.setString(1, rut);
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                String contraseña = res.getString("pass_user");
                if(contraseña.compareTo(pass) == 0){
                    return 1;
                }
            }
            pstm.close();
        }
        catch(SQLException e){
            System.out.println("Error verificar login");
            System.out.println(e);
            return 2;
        }catch(ClassNotFoundException e){
            System.out.println("Error verificar login");
            System.out.println(e);
            return 3;
        }
        return 0;
    }
}
