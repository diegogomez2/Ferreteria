/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author diego
 */
public class Usuario {
    SimpleIntegerProperty id;
    SimpleStringProperty user;
    SimpleStringProperty password;

    public Usuario(SimpleStringProperty user, SimpleStringProperty password) {
        this.user = user;
        this.password = password;
    }
    
    public Usuario(String user, String password){
        this.user = new SimpleStringProperty(user);
        this.password = new SimpleStringProperty(password);
    }
    
    public Usuario(){}
    
    public void setUser(String user) {
        this.user = new SimpleStringProperty(user);
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }
    
    public void setId(int id){
        this.id = new SimpleIntegerProperty(id);
    }

    public String getUser() {
        return user.get();
    }

    public String getPassword() {
        return password.get();
    }
    
    public int getId(){
        return id.get();
    }
}
