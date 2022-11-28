

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class MostrarInfoLibroController implements Initializable {

    @FXML
    private TextField textFieldId;
    @FXML
    private TextArea areaMostrarInfo;
    @FXML
    private Button botonBuscar;
    NodeList nodeList;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void muestraInfo(ActionEvent event) {
         ArrayList<Libro> almaLibros = Biblioteca.leerFichero() ;
        areaMostrarInfo.clear();
        
            if (textFieldId.getText().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Incorrecto");
                a.setContentText("no deje el campo de la Id vacio");
                a.showAndWait();
            } else {
                for (Libro l : almaLibros) {

                    if (l.getId() == Integer.parseInt(textFieldId.getText())) {

                        areaMostrarInfo.setText(areaMostrarInfo.getText() + l.toString());
                    }
                }

            }

        
    }

}
