package com.example.mobilificio;

import application.Articolo;

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

import strategy.pattern.Tabella_Arredamento;
import strategy.pattern.TipoTabella;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Classe Inventario_Controller: che rappresenta il controller dell'interfaccia grafica "Inventario.fxml",
 * che permette di visualizzare l'inventario
 */

public class Inventario_Controller implements Initializable {
    @FXML
    private TableView<Articolo> tableView;
    @FXML
    private TableColumn<Articolo, Integer> col_codice;
    @FXML
    private TableColumn<Articolo, String> col_nome;
    @FXML
    private TableColumn<Articolo, String> col_descrizione;
    @FXML
    private TableColumn<Articolo, String> col_colore;
    @FXML
    private TableColumn<Articolo,Double> col_costo;
    @FXML
    private TableColumn<Articolo, String>  col_fornitore;
    @FXML
    private TableColumn<Articolo, String>  col_arredamento;
    @FXML
    private TableColumn<Articolo, String>  col_categoria;
    @FXML
    private Button indietro;

    ObservableList<Articolo> tab = FXCollections.observableArrayList();
    /**
     * Metodo che inizializza le variabili di classe.
     * Inoltre, usa il Pattern Strategy per la creazione della tabella
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        col_codice.setCellValueFactory(new PropertyValueFactory<Articolo,Integer>("codice"));
        col_nome.setCellValueFactory(new PropertyValueFactory<Articolo,String>("nome"));
        col_descrizione.setCellValueFactory(new PropertyValueFactory<Articolo,String>("descrizione"));
        col_colore.setCellValueFactory(new PropertyValueFactory<Articolo,String>("colore"));
        col_costo.setCellValueFactory(new PropertyValueFactory<Articolo,Double>("costo"));
        col_fornitore.setCellValueFactory(new PropertyValueFactory<Articolo,String>("fornitore"));
        col_arredamento.setCellValueFactory(new PropertyValueFactory<Articolo,String>("arredamento"));
        col_categoria.setCellValueFactory(new PropertyValueFactory<Articolo,String>("categoria"));

        TipoTabella<Articolo> tab = new TipoTabella<Articolo>(new Tabella_Arredamento());
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
}
