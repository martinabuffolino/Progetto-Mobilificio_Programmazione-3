package com.example.mobilificio;

import Template.pattern.Magazziniere;
import Template.pattern.Venditore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import singleton.pattern.Database;

import javax.swing.*;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class Form_Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="invia"
    private Button invia;

    @FXML // fx:id="mansione"
    private TextField mansione;

    @FXML // fx:id="nome"
    private TextField nome;

    @FXML // fx:id="cognome"
    private TextField cognome;

    @FXML // fx:id="email"
    private TextField email;

    @FXML // fx:id="cellulare"
    private TextField cellulare;

    @FXML // fx:id="Indietro"
    private Button Indietro;


    Magazziniere magazziniere = new Magazziniere(email,nome,cognome,cellulare,mansione);;

    Venditore venditore = new Venditore(email,nome,cognome,cellulare,mansione);;

    private Database db;

    /**
     * Inizializza tutte le variabili della classe
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
            db = new Database();
        }
        catch(Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void handleInvia(ActionEvent event) throws Exception
    {
        String nom,cogn,em,cell,mans;
        em=email.getText();
        nom=nome.getText();
        cogn=cognome.getText();
        cell=cellulare.getText();
        mans= mansione.getText();

        //Controllo valori
        if( nom.isEmpty() || cogn.isEmpty() || em.isEmpty() || cell.isEmpty() || mans.isEmpty())
            throw new Custom_Exception("ERRORE DURANTE L'INSERIMENTO\nCompilare tutti i campi");

        // al posto dei valori metto ?
        // anche se il valore contiene caratteri speciali non ho problemi
        String sql="INSERT INTO mobilificio.form (email,nome,cognome,cellulare,mansione)"+ "VALUES (?,?,?,?,?)";
        //PreparedStatement--> prepariamo lo statement
        PreparedStatement preparedStmt = db.insert(sql);
        //ad ogni ? assegniamo una stringa
        preparedStmt.setString (1, em);
        preparedStmt.setString (2, nom);
        preparedStmt.setString (3, cogn);
        preparedStmt.setString (4, cell);
        preparedStmt.setString (5, mans);
        preparedStmt.execute(); //eseguo lo statement

        JOptionPane.showMessageDialog(null,"Form inviato correttamente");
    }

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
