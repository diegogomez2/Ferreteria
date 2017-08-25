package productos.ingresar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import modelos.ProductModel;
import pojos.Producto;

/**
 *
 * @author Diego
 */
public class IngresarPresenter implements Initializable {

    @FXML
    TitledPane titledIngresar;
    @FXML
    TextField textoCodigo;
    @FXML
    TextField textoNombre;
    @FXML
    TextField textoPrecio;
    @FXML
    TextField textoCantidad;
    @FXML
    TextArea textoDescripcion;

    Stage stage;
    private static double xOffset = 0;
    private static double yOffset = 0;

    private ResourceBundle resources = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        titledIngresar.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
            if (oldScene == null && newScene != null) {
                // scene is set for the first time. Now its the time to listen stage changes.
                newScene.windowProperty().addListener((observableWindow, oldWindow, newWindow) -> {
                    if (oldWindow == null && newWindow != null) {
                        // stage is set. now is the right time to do whatever we need to the stage in the controller.
                        stage = (Stage) newWindow;
                        titledIngresar.setOnMousePressed((event) -> {
                            xOffset = stage.getX() - event.getSceneX();
                            yOffset = stage.getY() - event.getSceneY();
                        }
                        );
                        titledIngresar.setOnMouseDragged((event) -> {
                            stage.setX(event.getSceneX() + xOffset);
                            stage.setY(event.getSceneY() + yOffset);
                        });
                    }
                });
            }
        });
    }

    public void cerrar() {
        stage.close();
    }

    public void ingresarProducto() {
        ProductModel modelo = ProductModel.getInstance();
        modelo.ingresarProducto(new Producto(textoCodigo.getText(), textoNombre.getText(), textoDescripcion.getText(), textoPrecio.getText(), 
        textoCantidad.getText()));
        
    }

    public void cargarScene() {
        stage = (Stage) titledIngresar.getScene().getWindow();
    }
    
    public void precioKeyReleased(){
        //TextFieldFormatter tff = new TextFieldFormatter();
    }
}
