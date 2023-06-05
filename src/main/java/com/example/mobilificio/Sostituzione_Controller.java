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

public class Sostituzione_Controller implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="codiceArr"
    private TextField codiceArr;

    @FXML // fx:id="nomeArr"
    private TextField nomeArr;

    @FXML // fx:id="descrizioneArt"
    private TextField descrizioneArt;

    @FXML // fx:id="coloreArr"
    private TextField coloreArr;

    @FXML // fx:id="fornitoreArr"
    private TextField fornitoreArr;

    @FXML // fx:id="arredamentoTipo"
    private TextField arredamentoTipo;

    @FXML // fx:id="categoriaArr"
    private TextField categoriaArr;

    @FXML // fx:id="nomeCliente"
    private TextField nomeCliente;

    @FXML // fx:id="cognomeCliente"
    private TextField cognomeCliente;

    @FXML // fx:id="emailCliente"
    private TextField emailCliente;

    @FXML // fx:id="cellulareCliente"
    private TextField cellulareCliente;
    @FXML // fx:id="invia"
    private Button invia;
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

    @FXML
    void handleInvia(ActionEvent event) throws Exception
    {
        String nomAr,descrAr,colAr,fornAr,arrT,catAr,nomC,cognC,emailC,celC;
        int codAr;
        codAr= Integer.parseInt(codiceArr.getText());
        nomAr=nomeArr.getText();
        descrAr=descrizioneArt.getText();
        colAr=coloreArr.getText();
        fornAr=fornitoreArr.getText();
        arrT=arredamentoTipo.getText();
        catAr=categoriaArr.getText();
        nomC=nomeCliente.getText();
        cognC=cognomeCliente.getText();
        emailC=emailCliente.getText();
        celC=cellulareCliente.getText();

        //Controllo valori
        if(codAr<0 || nomAr.isEmpty() || descrAr.isEmpty() || colAr.isEmpty() || fornAr.isEmpty() || arrT.isEmpty() || catAr.isEmpty() || nomC.isEmpty() || cognC.isEmpty() || emailC.isEmpty() || celC.isEmpty() || codiceArr.getText().isEmpty() )
            throw new Custom_Exception("ERRORE DURANTE L'INSERIMENTO\nCompilare tutti i campi.\nCodice deve avere un valore >0.");


        // al posto dei valori metto ?
        // anche se il valore contiene caratteri speciali non ho problemi
        String sql="INSERT INTO mobilificio.sostituzione (codiceArr,nomeArr,descrizioneArt,coloreArr,fornitoreArr,arredamentoTipo,categoriaArr,nomeCliente,cognomeCliente,emailCliente,cellulareCliente)"+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        //PreparedStatement--> prepariamo lo statement
        PreparedStatement preparedStmt = db.insert(sql);
        //ad ogni ? assegniamo una stringa
        preparedStmt.setInt (1, codAr);
        preparedStmt.setString (2, nomAr);
        preparedStmt.setString (3, descrAr);
        preparedStmt.setString (4, colAr);
        preparedStmt.setString (5, fornAr);
        preparedStmt.setString (6, arrT);
        preparedStmt.setString (7, catAr);
        preparedStmt.setString (8, nomC);
        preparedStmt.setString (9, cognC);
        preparedStmt.setString (10, emailC);
        preparedStmt.setString (11, celC);

        preparedStmt.execute(); //eseguo lo statement

        JOptionPane.showMessageDialog(null,"Sostituzione richiesta correttamente");
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