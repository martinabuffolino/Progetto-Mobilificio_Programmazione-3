package com.example.mobilificio;

import application.Sostituzione;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import strategy.pattern.Tabella_Sostituzione;
import strategy.pattern.TipoTabella;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe Stato_Controller: che rappresenta il controller dell'interfaccia grafica "Inventario.fxml",
 * che permette di visualizzare l'inventario
 */

public class Stato_Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="indietro"
    private Button indietro;

    @FXML // fx:id="invia"
    private Button invia;

    @FXML // fx:id="tableView"
    private TableView<Sostituzione> tableView;

    @FXML // fx:id="col_codArr"
    private TableColumn<Sostituzione, Integer> col_codArr;

    @FXML // fx:id="col_descrizioneArt"
    private TableColumn<Sostituzione, String> col_descrizioneArt;

    @FXML // fx:id="col_stato"
    private TableColumn<Sostituzione, String> col_stato;

    ObservableList<Sostituzione> tab = FXCollections.observableArrayList();


    /**
     * Metodo che inizializza le variabili di classe.
     * Inoltre, usa il Pattern Strategy per la creazione della tabella
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        col_codArr.setCellValueFactory(new PropertyValueFactory<Sostituzione,Integer>("codice"));
        col_descrizioneArt.setCellValueFactory(new PropertyValueFactory<Sostituzione,String>("descrizione"));
        col_stato.setCellValueFactory(new PropertyValueFactory<Sostituzione,String>("stato"));

        TipoTabella<Sostituzione> tab = new TipoTabella<Sostituzione>(new Tabella_Sostituzione());
        tableView.setItems(tab.getElements());

    }

    /**
     * Metodo che permette di richiamare l'interfaccia grafica "Home.fxml"
     * @param event Pressione bottone "Back"
     * @throws Exception
     */

    @FXML
    void handleIndietro(ActionEvent event) throws Exception
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();

    }

    @FXML
    void handleInvia(ActionEvent event) throws SQLException {

        System.out.println("Stampo dati riparazione: ");



    }

}
