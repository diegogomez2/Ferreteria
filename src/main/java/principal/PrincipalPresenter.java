/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author diego
 */
public class PrincipalPresenter implements Initializable {
    @FXML
    StackPane stackPane;
    @FXML 
    GridPane anchorClientes;
    @FXML
    GridPane anchorMain;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarPanel();
//        stackPane.getChildren().add(anchorClientes);
//        stackPane.getChildren().remove(0);
//        stackPane.getChildren().add(anchorClientes);
    }
    
    public void cargarPanel(){
        //stackPane.getChildren().get(0).toFront();
    }
    
    public void mostrarClientes(){
        try{
            GridPane pane = (GridPane)FXMLLoader.load(getClass().getClassLoader().getResource("clientes/clientes.fxml"));
            anchorMain.getChildren().setAll(pane);
//            anchorMain.getChildren().get(0).set
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("missing file");
        }
//        stackPane.getChildren().get(0).toFront();
    }
    
    public void mostrarProductos(){
        try{
            anchorMain.getChildren().setAll((AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("productos/productos.fxml")));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("missing file");
        }
    }
}
