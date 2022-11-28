

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


public class CrearLibroController implements Initializable {

    @FXML
    private Button botonAñadir;

    @FXML
    private TextField textFieldTitulo;
    @FXML
    private TextField textFieldAutor;
    @FXML
    private TextField textFieldAnyo;
    @FXML
    private TextField textFieldEditorial;
    @FXML
    private TextField textFieldcantPaginas;

    ArrayList<Libro> libros = new ArrayList<>();
    NodeList nodeList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void AñadirLibro(ActionEvent event) throws IOException, JAXBException, ParserConfigurationException, TransformerConfigurationException, TransformerException {

        ArrayList<Libro> libros = Biblioteca.leerFichero();
        Integer idMas = libros.get(libros.size() - 1).getId() + 1;
        Libro nuevoLibro = new Libro();
        nuevoLibro.setId(idMas);
        nuevoLibro.setAnyo(Integer.parseInt(textFieldAnyo.getText()));
        nuevoLibro.setAutor(textFieldAutor.getText());
        nuevoLibro.setCantPaginas(Integer.parseInt(textFieldcantPaginas.getText()));
        nuevoLibro.setEditorial(textFieldEditorial.getText());
        nuevoLibro.setTitulo(textFieldTitulo.getText());
        libros.add(nuevoLibro);
        Biblioteca.actualizarfichero(libros);
         Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Todo ok");
                a.setContentText("Creado correctamente");
                a.showAndWait();
        
    }

}
