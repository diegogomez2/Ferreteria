/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author diego
 */
public class Cliente {
    StringProperty rut;
    //StringProperty digito;
    StringProperty razon;
    StringProperty giro;
    StringProperty telefono;
    StringProperty celular;
    StringProperty direccion;
    StringProperty region;
    StringProperty ciudad;
    StringProperty comuna;

    public Cliente(){}
    
    public Cliente(StringProperty rut, StringProperty razon, StringProperty giro, StringProperty telefono, StringProperty celular, StringProperty direccion, StringProperty region, StringProperty ciudad, StringProperty comuna) {
        this.rut = rut;
        this.razon = razon;
        this.giro = giro;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.region = region;
        this.ciudad = ciudad;
        this.comuna = comuna;
    }
    
    public Cliente(List<String> data) {
        this.rut = new SimpleStringProperty((data.get(0)));
        this.razon = new SimpleStringProperty(data.get(1));
        this.giro = new SimpleStringProperty();
        this.telefono = new SimpleStringProperty(data.get(2));
        this.celular = new SimpleStringProperty();
        this.direccion = new SimpleStringProperty(data.get(3));
        this.region = new SimpleStringProperty();
        this.ciudad = new SimpleStringProperty();
        this.comuna = new SimpleStringProperty();
    }

    public String getRut() {
        return rut.get();
    }

    public String getRazon() {
        return razon.get();
    }

    public String getGiro() {
        return giro.get();
    }

    public String getTelefono() {
        return telefono.get();
    }

    public String getCelular() {
        return celular.get();
    }

    public String getDireccion() {
        return direccion.get();
    }

    public String getRegion() {
        return region.get();
    }

    public String getCiudad() {
        return ciudad.get();
    }

    public String getComuna() {
        return comuna.get();
    }

    public void setRut(String rut) {
        this.rut = new SimpleStringProperty(rut);
    }

    public void setRazon(String razon) {
        this.razon = new SimpleStringProperty(razon);
    }

    public void setGiro(String giro) {
        this.giro = new SimpleStringProperty(giro);
    }

    public void setTelefono(String telefono) {
        this.telefono = new SimpleStringProperty(telefono);
    }

    public void setCelular(String celular) {
        this.celular = new SimpleStringProperty(celular);
    }

    public void setDireccion(String direccion) {
        this.direccion = new SimpleStringProperty(direccion);
    }

    public void setRegion(String region) {
        this.region = new SimpleStringProperty(region);
    }

    public void setCiudad(String ciudad) {
        this.ciudad = new SimpleStringProperty(ciudad);
    }

    public void setComuna(String comuna) {
        this.comuna = new SimpleStringProperty(comuna);
    }
    
   
}
