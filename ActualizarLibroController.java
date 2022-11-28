/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package entregables3;

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

/**
 * FXML Controller class
 *
 * @author Joan_2k2
 */
public class ActualizarLibroController implements Initializable {

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
    @FXML
    private Button botonAñadir;
    @FXML
    private TextArea mostrarTexto;
    @FXML
    private TextField textFieldId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ActualizarLibro(ActionEvent event) {
        ArrayList<Libro> almaLibros = Biblioteca.leerFichero();
        Libro nuevoLibro = new Libro();

        for (Libro l : almaLibros) {
            if (l.getId() == Integer.parseInt(textFieldId.getText())) {
                int prueba = Integer.parseInt(textFieldAnyo.getText());
                l.setAnyo(Integer.parseInt(textFieldAnyo.getText()));
                l.setAutor(textFieldAutor.getText());
                l.setCantPaginas(Integer.parseInt(textFieldcantPaginas.getText()));
                l.setEditorial(textFieldEditorial.getText());
                l.setTitulo(textFieldTitulo.getText());

            }

        }
        Biblioteca.actualizarfichero(almaLibros);

        for (Libro l : almaLibros) {

            if (l.getId() == Integer.parseInt(textFieldId.getText())) {

                mostrarTexto.setText(mostrarTexto.getText() + l.toString());
            }
        }
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setHeaderText("Todo ok");
        a.setContentText("Actualizado correctamente");
        a.showAndWait();
    }

}
