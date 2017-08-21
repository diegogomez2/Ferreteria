/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.inject.Inject;
import modelos.ClientModel;
import pojos.Cliente;

/**
 *
 * @author diego
 */
public class ClientesPresenter implements Initializable {

    @FXML
    TableView tablaClientes;
    @Inject
    Cliente cliente;
    ClientModel modelo = ClientModel.getInstance();
    private ObservableList<Cliente> clientData = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablaClientes.setRowFactory(tv -> {
        TableRow<Cliente> row = new TableRow();
        return row;
        });
        loadData();
    }
    
    private void loadData(){
        List<List<String>> data = modelo.listarClientes();
        ObservableList<Cliente> dataClientes = cargarClientes(data);
//        ObservableList<Cliente> dataClientes = modelo.listarClientes();
        clientData = dataClientes;
//        filteredData = new FilteredList<>(clientData, p -> true);
//        SortedList<Cliente> sortedData = new SortedList<>(filteredData);
//        sortedData.comparatorProperty().bind(tablaClientes.comparatorProperty());
        definirColumnas();
        //tablaClientes.setItems(dataClientes);
        tablaClientes.setItems(clientData);
    }
    
    public ObservableList<Cliente> cargarClientes(List<List<String>> data){
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
        Iterator<List<String>> it = data.iterator();
        while(it.hasNext()){
            clientes.add(new Cliente(it.next()));
        }
        return clientes;
    }
    
    public void definirColumnas(){
//        tablaClientes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn rutCol = new TableColumn("Rut");
        rutCol.setCellValueFactory(new PropertyValueFactory<>("rut"));
        TableColumn rznCol = new TableColumn("Razón Social");
        rznCol.setCellValueFactory(new PropertyValueFactory<>("razon"));
        TableColumn telCol = new TableColumn("Teléfono");
        telCol.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        TableColumn dirCol = new TableColumn("Dirección");
        dirCol.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tablaClientes.getColumns().setAll(rutCol, rznCol, telCol, dirCol);
    }
}
