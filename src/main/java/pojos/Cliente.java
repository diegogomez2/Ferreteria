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

    private IntegerProperty rutCli;
    private StringProperty digCli;
    private StringProperty rutDigCli;
    private StringProperty razCli;
    private StringProperty girCli;
    private StringProperty telCli;
    private StringProperty celCli;
    private StringProperty dirCli;
    private StringProperty regCli;
    private StringProperty ciuCli;
    private StringProperty comCli;

    public Cliente() {
    }

    public Cliente(IntegerProperty rut, StringProperty digito, StringProperty razon, StringProperty giro, StringProperty telefono, StringProperty celular, StringProperty direccion, StringProperty region, StringProperty ciudad, StringProperty comuna) {
        this.rutCli = rut;
        this.digCli = digito;
        this.rutDigCli = new SimpleStringProperty(rut.toString() + "-" + digito.toString());
        this.razCli = razon;
        this.girCli = giro;
        this.telCli = telefono;
        this.celCli = celular;
        this.dirCli = direccion;
        this.regCli = region;
        this.ciuCli = ciudad;
        this.comCli = comuna;
    }

    public Cliente(List<String> data) {
        this.rutCli = new SimpleIntegerProperty();
        this.digCli = new SimpleStringProperty();
        this.rutDigCli = new SimpleStringProperty((data.get(0)));
        this.razCli = new SimpleStringProperty(data.get(1));
        this.girCli = new SimpleStringProperty();
        this.telCli = new SimpleStringProperty(data.get(2));
        this.celCli = new SimpleStringProperty();
        this.dirCli = new SimpleStringProperty(data.get(3));
        this.regCli = new SimpleStringProperty();
        this.ciuCli = new SimpleStringProperty();
        this.comCli = new SimpleStringProperty();
    }

    public int getRut() {
        return rutCli.get();
    }

    public String getDigito() {
        return digCli.get();
    }

    public String getRutDig() {
        return rutDigCli.get();
    }

    public String getRazon() {
        return razCli.get();
    }

    public String getGiro() {
        return girCli.get();
    }

    public String getTelefono() {
        return telCli.get();
    }

    public String getCelular() {
        return celCli.get();
    }

    public String getDireccion() {
        return dirCli.get();
    }

    public String getRegion() {
        return regCli.get();
    }

    public String getCiudad() {
        return ciuCli.get();
    }

    public String getComuna() {
        return comCli.get();
    }

    public void setRut(int rut) {
        this.rutCli = new SimpleIntegerProperty(rut);
    }

    public void setDigito(String digito) {
        this.digCli = new SimpleStringProperty(digito);
    }

    public void setRutDig(String rutDig) {
        this.rutDigCli = new SimpleStringProperty(rutDig);
    }

    public void setRazon(String razon) {
        this.razCli = new SimpleStringProperty(razon);
    }

    public void setGiro(String giro) {
        this.girCli = new SimpleStringProperty(giro);
    }

    public void setTelefono(String telefono) {
        this.telCli = new SimpleStringProperty(telefono);
    }

    public void setCelular(String celular) {
        this.celCli = new SimpleStringProperty(celular);
    }

    public void setDireccion(String direccion) {
        this.dirCli = new SimpleStringProperty(direccion);
    }

    public void setRegion(String region) {
        this.regCli = new SimpleStringProperty(region);
    }

    public void setCiudad(String ciudad) {
        this.ciuCli = new SimpleStringProperty(ciudad);
    }

    public void setComuna(String comuna) {
        this.comCli = new SimpleStringProperty(comuna);
    }
}
