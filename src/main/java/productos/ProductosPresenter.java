/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.inject.Inject;
import modelos.ProductModel;
import pojos.Producto;
import productos.ingresar.IngresarView;

/**
 *
 * @author diego
 */
public class ProductosPresenter implements Initializable {

    @FXML
    TableView tablaProductos;
    @Inject
    private ObservableList<Producto> productData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablaProductos.setRowFactory(tv -> {
            TableRow<Producto> row = new TableRow();
            return row;
        });
        loadData();
    }

    private void loadData() {
        ProductModel model = ProductModel.getInstance();
        try {
            ObservableList<Producto> dataProductos = FXCollections.observableArrayList(model.listarProductos());
            definirColumnas();
            tablaProductos.setItems(dataProductos);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void definirColumnas() {
        TableColumn codProd = new TableColumn("Código");
        codProd.setCellValueFactory(new PropertyValueFactory<>("codProd"));
        TableColumn nomProd = new TableColumn("Nombre");
        nomProd.setCellValueFactory(new PropertyValueFactory<>("nomProd"));
        TableColumn desProd = new TableColumn("Descripción");
        desProd.setCellValueFactory(new PropertyValueFactory<>("desProd"));
        TableColumn precProd = new TableColumn("Precio");
        precProd.setCellValueFactory(new PropertyValueFactory<>("precProd"));
        TableColumn cantProd = new TableColumn("Cantidad");
        cantProd.setCellValueFactory(new PropertyValueFactory<>("cantProd"));
        tablaProductos.getColumns().setAll(codProd, nomProd, desProd, precProd, cantProd);
    }

    public void ingresarProducto() {
        IngresarView inView = new IngresarView();
        Stage stage = new Stage();
        Scene scene = new Scene(inView.getView());
        stage.setTitle("Ingresar producto");
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
//        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
        loadData();
    }
}
