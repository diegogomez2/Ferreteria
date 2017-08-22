/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import entities.EntityClientes;
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
import modelos.ClientQuery;
import pojos.Cliente;

/**
 *
 * @author diego
 */
public class ClientesPresenter implements Initializable {

    @FXML
    TableView tablaClientes;
    @Inject
    private ObservableList<EntityClientes> clientData = FXCollections.observableArrayList();
    ClientQuery query;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablaClientes.setRowFactory(tv -> {
        TableRow<Cliente> row = new TableRow();
        return row;
        });
        loadData();
    }
    
    private void loadData(){
//        List<List<String>> data = modelo.listarClientes();
        query = new ClientQuery();
        List<EntityClientes> data = query.getClientes();
        ObservableList<EntityClientes> dataClientes = FXCollections.observableArrayList(query.getClientes());
        System.out.println(dataClientes.get(0).getRutCli());
        System.out.println(dataClientes.get(0).getRutDigCli());
//        ObservableList<Cliente> dataClientes = modelo.listarClientes();
        clientData = dataClientes;
//        filteredData = new FilteredList<>(clientData, p -> true);
//        SortedList<Cliente> sortedData = new SortedList<>(filteredData);
//        sortedData.comparatorProperty().bind(tablaClientes.comparatorProperty());
        definirColumnas();
        //tablaClientes.setItems(dataClientes);
        tablaClientes.setItems(clientData);
    }
    
//    public ObservableList<Cliente> cargarClientes(List<List<String>> data){
//        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
//        Iterator<List<String>> it = data.iterator();
//        while(it.hasNext()){
//            clientes.add(new Cliente(it.next()));
//        }
//        return clientes;
//    }
    
    public void definirColumnas(){
//        tablaClientes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn rutCol = new TableColumn("Rut");    
        rutCol.setCellValueFactory(new PropertyValueFactory<>("rutDigCli"));
        TableColumn rznCol = new TableColumn("Razón Social");
        rznCol.setCellValueFactory(new PropertyValueFactory<>("razCli"));
        TableColumn telCol = new TableColumn("Teléfono");
        telCol.setCellValueFactory(new PropertyValueFactory<>("telCli"));
        TableColumn dirCol = new TableColumn("Dirección");
        dirCol.setCellValueFactory(new PropertyValueFactory<>("dirCli"));
        tablaClientes.getColumns().setAll(rutCol, rznCol, telCol, dirCol);
    }
}
