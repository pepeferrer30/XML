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
public class BorrarLibroController implements Initializable {

    @FXML
    private TextField idBorrar;
    @FXML
    private Button botonBorrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void borrarLibro(ActionEvent event) {
        if (idBorrar.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Error");
            a.setContentText("No existe");
            a.showAndWait();
        }
        ArrayList<Libro> almaLibros = Biblioteca.leerFichero();
        int tamanyo = almaLibros.size();
        if (tamanyo < Integer.parseInt(idBorrar.getText())) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Error");
            a.setContentText("No existe");
            a.showAndWait();
        }
        Libro nuevoLibro = new Libro();
        for (Libro l : almaLibros) {
            if (l.getId() == Integer.parseInt(idBorrar.getText())) {
                nuevoLibro = l;
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Todo ok");
                a.setContentText("Borrado correctamente");
                a.showAndWait();
            }

        }

        almaLibros.remove(nuevoLibro);
        Biblioteca.actualizarfichero(almaLibros);

    }

}
