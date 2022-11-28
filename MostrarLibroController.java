

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class MostrarLibroController implements Initializable {

    @FXML
    private TextArea areaMostrar;
    @FXML
    private Button botonMostrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Mostrar(ActionEvent event) throws IOException, JAXBException {
        NodeList nodeList;
        ArrayList<Libro> almaLibros = Biblioteca.leerFichero();
        
        for (Libro l : almaLibros) {
            areaMostrar.setText(areaMostrar.getText() + "Id " + l.getId() + "\n" + "El titulo es " + l.getTitulo() + "\n");
        }

    }

}
