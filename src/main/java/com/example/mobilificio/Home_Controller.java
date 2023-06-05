package com.example.mobilificio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Home_Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cliente"
    private Button cliente;

    @FXML // fx:id="magazziniere"
    private Button magazziniere;

    @FXML // fx:id="inserisci"
    private Button inserisci; // Button per inserire dati arredamento

    @FXML // fx:id="visualizza"
    private Button visualizza; // Button per visualizzare lista arredamenti

    @FXML // fx:id="stato"
    private Button notifica; // Button per notificare il cliente

    @FXML // fx:id="acquista"
    private Button acquista; // Button per acquistare arredamento

    @FXML // fx:id="sostituzione"
    private Button sostituzione; // Button per richiedere sostituzione
    @FXML // fx:id="form"
    private Button form; // Button per inviare un form

    public Home_Controller() {
    }

    /**
     * Metodo che rende visibili le funzioni del magazziniere
     */
    @FXML
    void handleMagazziniere(ActionEvent event) throws Exception {
        inserisci.setVisible(true);
        visualizza.setVisible(true);
        notifica.setVisible(true);
        acquista.setVisible(false);
        sostituzione.setVisible(false);
        form.setVisible(false);
    }

    /**
     * Metodo che rende visibili le funzioni del cliente
     */
    @FXML
    void handleCliente(ActionEvent event) throws Exception {
        acquista.setVisible(true);
        sostituzione.setVisible(true);
        form.setVisible(true);
        inserisci.setVisible(false);
        visualizza.setVisible(false);
        notifica.setVisible(false);
    }

    /**
     * Metodo che richiama l'interfaccia grafica "Insert.fxml" per inserire dati arredamento
     */
    @FXML
    void handleInsert(ActionEvent event) throws Exception
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Insert.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setResizable(false);
        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * Metodo che richiama l'interfaccia grafica "Visualizza.fxml" per visualizzare lista arredamenti
     */
    @FXML
    void handleVisualizza(ActionEvent event) throws Exception
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Inventario.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    /**
     * Metodo che richiama l'interfaccia grafica "Stato.fxml" per notificare il cliente
     */
    @FXML
    void handleNotifica(ActionEvent event) throws Exception
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Notifica.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    /**
     * Metodo che richiama l'interfaccia grafica "Acquisto.fxml" per acquistare arredamento
     */
    @FXML
    void handleAcquista(ActionEvent event) throws Exception
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Acquisto.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();

    }

    /**
     * Metodo che richiama l'interfaccia grafica "Sostituzione.fxml" per richiedere sostituzione di un articolo
     */
    @FXML
    void handleSostituzione(ActionEvent event) throws Exception
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Sostituzione.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    /**
     * Metodo che richiama l'interfaccia grafica "Form.fxml" per inviare un form
     */
    @FXML
    void handleForm(ActionEvent event) throws Exception
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Form.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }
}
