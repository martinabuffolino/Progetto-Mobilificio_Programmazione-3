package com.example.mobilificio;

/**
 * Classe Pagamento_Controller: permette al cliente di pagare in base al metodo di pagamento scelto
 */

import factoryMethod.pattern.Creator;
import factoryMethod.pattern.CreatorBonifico;
import factoryMethod.pattern.CreatorCartaCredito;
import factoryMethod.pattern.MetodoPagamento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import singleton.pattern.Database;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Pagamento_Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="nome"
    private TextField nome;

    @FXML // fx:id="cognome"
    private TextField cognome;

    @FXML // fx:id="carta"
    private TextField carta;

    @FXML // fx:id="iban"
    private TextField iban;

    @FXML // fx:id="radioBonifico"
    private RadioButton radioBonifico;

    @FXML // fx:id="radioCarta"
    private RadioButton radioCarta;

    @FXML // fx:id="Indietro"
    private Button Indietro;

    @FXML // fx:id="contanti"
    private TextField contanti;

    @FXML // fx:id="label_conto"
    private Label label_conto;

    @FXML // fx:id="Paga"
    private Button Paga;

    private ToggleGroup rbGroup = new ToggleGroup();


    @Override
    public void initialize(URL location,ResourceBundle resources)
    {    }

    /**
     * Metodo che gestisce la scelta del metodo di pagamento
     */
    @FXML
    void handleTipoPagamento() {
        if(radioBonifico.isSelected()){
            nome.setVisible(true);
            cognome.setVisible(true);
            iban.setVisible(true);
            carta.setVisible(false);
        }
        if(radioCarta.isSelected()){
            nome.setVisible(true);
            cognome.setVisible(true);
            iban.setVisible(false);
            carta.setVisible(true);
        }
    }

    /**
     * Metodo che gestisce il pagamento, andando ad eliminare gli arredamenti selezionati
     * dal database
     */
    @FXML
    void handlePaga(ActionEvent event) throws Exception
    {
        try
        {
            Database db = new Database();
            Creator creator = null;
            MetodoPagamento met = null;

            //Leggi scelta
            if(radioBonifico.isSelected())
            {
                //Controllo dati
                if(nome.getText().isEmpty() || cognome.getText().isEmpty() || iban.getText().isEmpty())
                    throw new Custom_Exception("Compilare tutti i campi.");

                creator = new CreatorBonifico(nome.getText(),cognome.getText(),iban.getText());
                met = creator.getMetodo();
            }
            if(radioCarta.isSelected())
            {
                //Controllo dati
                if(nome.getText().isEmpty() || cognome.getText().isEmpty() || carta.getText().isEmpty())
                    throw new Custom_Exception("Compilare tutti i campi.");

                creator = new CreatorCartaCredito(nome.getText(),cognome.getText(),carta.getText());
                met = creator.getMetodo();
            }

            JOptionPane.showMessageDialog(null,met.paga());

            //Ritorna al menu principale
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        }
        catch(NullPointerException e)
        {
            throw new Custom_Exception("Scegli il metodo di pagamento");
        }
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

