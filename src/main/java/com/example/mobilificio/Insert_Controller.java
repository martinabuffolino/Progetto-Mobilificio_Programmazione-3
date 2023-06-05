package com.example.mobilificio;

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

/**
 * Classe Insert_Controller: rappresenta il controller dell'interfaccia grafica "Insert.fxml"
 * Permette di inserire arredamento nel database
 */
public class Insert_Controller implements Initializable{

    @FXML // fx:id="codice"
    private TextField codice;

    @FXML // fx:id="nome"
    private TextField nome;

    @FXML // fx:id="descrizione"
    private TextField descrizione;

    @FXML // fx:id="colore"
    private TextField colore;

    @FXML // fx:id="costo"
    private TextField costo;

    @FXML // fx:id="arredamento"
    private TextField arredamento;

    @FXML // fx:id="fornitore"
    private TextField fornitore;

    @FXML // fx:id="categoria"
    private TextField categoria;

    @FXML // fx:id="Inserisci"
    private Button Inserisci;

    @FXML // fx:id="Indietro"
    private Button Indietro;

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

    /**
     * Metodo che effettua l'inserimento dei "data" nel DB
     * @param event Pressione bottone "Insert"
     * @throws Exception Eccezioni utente che controllano che tutti i dati inseriti siano corretti
     */
    @FXML
    void handleInsert(ActionEvent event) throws Exception
    {
        String nom,descr,col,forn,arred,categ;
        double cost;
        int cod;
        cost=Double.parseDouble(costo.getText());
        cod= Integer.parseInt(codice.getText());
        nom=nome.getText();
        descr=descrizione.getText();
        col=colore.getText();
        forn=fornitore.getText();
        arred=arredamento.getText();
        categ=categoria.getText();

        //Controllo valori
        if(cost<0 || cod<0 || nom.isEmpty() || descr.isEmpty() || col.isEmpty() || forn.isEmpty() || arred.isEmpty() || categ.isEmpty() || codice.getText().isEmpty() || costo.getText().isEmpty() )
            throw new Custom_Exception("ERRORE DURANTE L'INSERIMENTO\nCompilare tutti i campi.\nCosto deve avere un valore >0.");

        // al posto dei valori metto ?
        // anche se il valore contiene caratteri speciali non ho problemi
        String sql="INSERT INTO mobilificio.articolo (codice,nome,descrizione,colore,costo,fornitore,arredamento,categoria)"+ "VALUES (?,?,?,?,?,?,?,?)";
        //PreparedStatement--> prepariamo lo statement
        PreparedStatement preparedStmt = db.insert(sql);
        //ad ogni ? assegniamo una stringa
        preparedStmt.setInt (1, cod);
        preparedStmt.setString (2, nom);
        preparedStmt.setString (3, descr);
        preparedStmt.setString (4, col);
        preparedStmt.setDouble (5, cost);
        preparedStmt.setString (6, forn);
        preparedStmt.setString (7, arred);
        preparedStmt.setString (8, categ);
        preparedStmt.execute(); //eseguo lo statement

        JOptionPane.showMessageDialog(null,"Arredamento inserito correttamente");
    }

    /**
     * Metodo che richiama l'interfaccia grafica "Home.fxml"
     * @param event Pressione bottone "Indietro"
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
