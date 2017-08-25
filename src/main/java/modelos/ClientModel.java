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
import pojos.Cliente;

/**
 *
 * @author diego
 */
public class ClientModel {

    private ClientModel() {
    }

    public static ClientModel getInstance() {
        if (clInstance == null) {
            clInstance = new ClientModel();
        }
        return clInstance;
    }

    private static ClientModel clInstance;

    Connector conector = Connector.getInstance();
    String url = conector.getUrl();
    String login = conector.getLogin();
    String password = conector.getPassword();
    Connection conn = null;

    //Lista los clientes
    public List<Cliente> listarClientes() {
        List<Cliente> data = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT rut_cli, dig_cli, raz_cli, dir_cli,"
                    + " tel_cli FROM Clientes ORDER BY rut_cli");
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                String estrut = res.getString("rut_cli");
                String estdig = res.getString("dig_cli");
                String estraz = res.getString("raz_cli");
                String esttel = res.getString("tel_cli");
                String estdir = res.getString("dir_cli");
                data.add(new Cliente(Arrays.asList(estrut + "-" + estdig, estraz, esttel, estdir)));
            }
            res.close();
        } catch (SQLException e) {
            //System.out.println(e);
            return null;
        } catch (ClassNotFoundException e) {
        }
        return data;
    }

}
