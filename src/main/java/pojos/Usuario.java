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
    
    public Usuario(){}
    
    public void setUser(SimpleStringProperty user) {
        this.user = user;
    }

    public void setPassword(SimpleStringProperty password) {
        this.password = password;
    }
    
    public void setId(SimpleIntegerProperty id){
        this.id = id;
    }

    public SimpleStringProperty getUser() {
        return user;
    }

    public SimpleStringProperty getPassword() {
        return password;
    }
    
    public SimpleIntegerProperty getId(){
        return id;
    }
}
