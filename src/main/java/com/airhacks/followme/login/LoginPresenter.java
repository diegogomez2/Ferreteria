/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.followme.login;

import java.net.URL;
import java.sql.SQLException;
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
import pojos.Usuario;
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
        try{
            if(!camposVacios()){
                UserModel model = UserModel.getInstance();
                String user = textoUsuario.getText();
                String pass = textoContraseña.getText();
                Usuario usuario = model.verificarLogin(user, pass);
                if(usuario != null){
                    if(usuario.getPassword().compareTo(pass) == 0){
                        Stage logStage = (Stage)textoUsuario.getScene().getWindow();
                        logStage.hide();
                        PrincipalView mainView = new PrincipalView();
                        Stage stage = new Stage();
                        Scene scene = new Scene(mainView.getView(), 1024, 800);
                        stage.setTitle("Factusol");
                        stage.setScene(scene);
                        stage.show();
                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Usuario y/o contraseña inválidos");
                        alert.setContentText("Vuelva a ingresar los datos");
                        alert.showAndWait();
                        textoUsuario.clear();
                        textoContraseña.clear();
                        textoUsuario.getStyleClass().add("error");
                        textoContraseña.getStyleClass().add("error");
                    }
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Usuario y/o contraseña inválidos");
                    alert.setContentText("Vuelva a ingresar los datos");
                    alert.showAndWait();
                    textoUsuario.clear();
                    textoContraseña.clear();
                    textoUsuario.getStyleClass().add("error");
                    textoContraseña.getStyleClass().add("error");
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Debe ingresar usuario y contraseña");
                alert.setContentText("Vuelva a ingresar los datos");
                alert.showAndWait();
            }
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("La conexión a la base de datos falló");
            alert.setContentText("Por favor vuelva a intentarlo");
            alert.showAndWait();
            e.getMessage();
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
