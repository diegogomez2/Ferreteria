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
 * @author Diego
 */
public class Producto {
    
    private IntegerProperty idProd;
    private StringProperty codProd;
    private StringProperty nomProd;
    private StringProperty desProd;
    private IntegerProperty precProd;
    private IntegerProperty cantProd;
    
    
    public Producto(){}

    public Producto(IntegerProperty idProd, StringProperty codProd, StringProperty nomProd, StringProperty desProd, IntegerProperty precProd, 
            IntegerProperty cantProd){
        this.idProd = idProd;
        this.codProd = codProd;
        this.nomProd = nomProd;
        this.desProd = desProd;
        this.precProd = precProd;
        this.cantProd = cantProd;
    }
    
    public Producto( String codProd, String nomProd, String desProd, String precProd, String cantProd){
        this.idProd = null;
        this.codProd = new SimpleStringProperty(cantProd);
        this.nomProd = new SimpleStringProperty(nomProd);
        this.desProd = new SimpleStringProperty(desProd);
        this.precProd = new SimpleIntegerProperty(Integer.parseInt(precProd));
        this.cantProd = new SimpleIntegerProperty(Integer.parseInt(cantProd));
    }
    
    public Producto(List<String> data) {
        this.codProd = new SimpleStringProperty(data.get(0));
        this.nomProd = new SimpleStringProperty(data.get(1));
        this.desProd = new SimpleStringProperty((data.get(2)));
        this.precProd = new SimpleIntegerProperty(Integer.parseInt(data.get(3)));
        this.cantProd = new SimpleIntegerProperty(Integer.parseInt(data.get(4)));
    }

    public int getIdProd() {
        return idProd.get();
    }

    public String getCodProd() {
        return codProd.get();
    }

    public String getNomProd() {
        return nomProd.get();
    }

    public String getDesProd() {
        return desProd.get();
    }

    public int getPrecProd() {
        return precProd.get();
    }

    public int getCantProd() {
        return cantProd.get();
    }

    public void setIdProd(int idProd) {
        this.idProd.set(idProd);
    }

    public void setCodProd(String codProd) {
        this.codProd.set(codProd);
    }

    public void setNomProd(String nomProd) {
        this.nomProd.set(nomProd);
    }

    public void setDesProd(String desProd) {
        this.desProd.set(desProd);
    }

    public void setPrecProd(int precProd) {
        this.precProd.set(precProd);
    }

    public void setCantProd(int cantProd) {
        this.cantProd.set(cantProd);
    }
    
    
}
