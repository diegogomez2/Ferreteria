/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.followme.login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelos.UserModel;
import principal.PrincipalView;

/**
 *
 * @author diego
 */
public class LoginPresenter implements Initializable {

    @FXML
    TextField textoUsuario;
    @FXML
    PasswordField textoContraseña;
    @FXML
    Button botonIngresar;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void ingresar(){
        if(!camposVacios()){
            String user = textoUsuario.getText();
            String pass = textoContraseña.getText();
            UserModel modelo = UserModel.getInstance();
            int result = modelo.verificarLogin(user, pass);
            switch(result){
                case 0:
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Usuario y/o contraseña inválidos");
                    alert.setContentText("Vuelva a ingresar los datos");
                    alert.showAndWait();
                    textoUsuario.clear();
                    textoContraseña.clear();
                    textoUsuario.getStyleClass().add("error");
                    textoContraseña.getStyleClass().add("error");
                    break;
                case 1:
                    Stage logStage = (Stage)textoUsuario.getScene().getWindow();
                    logStage.hide();
                    PrincipalView mainView = new PrincipalView();
                    Stage stage = new Stage();
                    Scene scene = new Scene(mainView.getView(), 1024, 800);
                    stage.setTitle("Factusol");
                    stage.setScene(scene);
                    stage.show();
                    break;
                case 2:
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Debe ingresar usuario y contraseña");
                    alert.setContentText("Vuelva a ingresar los datos");
                    alert.showAndWait();
                    break;
                case 3:
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("La conexión a la base de datos falló");
                    alert.setContentText("Vuelva a ingresarlo en otro momento");
                    alert.showAndWait();
                    break;
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Debe ingresar usuario y contraseña");
            alert.setContentText("Vuelva a ingresar los datos");
            alert.showAndWait();
        }
    }
    
    public boolean camposVacios(){
        boolean result = false;
        String user = textoUsuario.getText();
        String pass = textoContraseña.getText();
        if(user.isEmpty()){
            textoUsuario.getStyleClass().add("error");
            result = true;
        }else{
            textoUsuario.getStyleClass().remove("error");
        }
        if(pass.isEmpty()){
            result = true;
            textoContraseña.getStyleClass().add("error");
        }else{
            textoContraseña.getStyleClass().remove("error");
        }
        return result;
    }
    
}
