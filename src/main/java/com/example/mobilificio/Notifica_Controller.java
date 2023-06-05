package com.example.mobilificio;

import application.Sostituzione;
import command.pattern.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import singleton.pattern.Database;
import strategy.pattern.Tabella_Sostituzione;
import strategy.pattern.TipoTabella;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Notifica_Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="indietro"
    private Button indietro;

    @FXML // fx:id="invia"
    private Button invia;

    @FXML // fx:id="col_codArr"
    private TableColumn<Sostituzione, Integer> col_codArr;

    @FXML // fx:id="col_nomeC"
    private TableColumn<Sostituzione, String> col_nome;

    @FXML // fx:id="col_cognC"
    private TableColumn<Sostituzione, String> col_descrizione;

    @FXML // fx:id="tableView"
    private TableView<Sostituzione> tableView;

    @FXML // fx:id="codiceA"
    private TextField codiceA;

    private Database db;

    ObservableList<Sostituzione> tab = FXCollections.observableArrayList();

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

    /**
     * Metodo che effettua l'inserimento del codice arredamento
     * @param event Pressione bottone "Insert"
     * @throws Exception Eccezioni utente che controllano che tutti i dati inseriti siano corretti
     */
    @FXML
    void handleInvia(ActionEvent event) throws Exception
    {

        int cod;
        cod= Integer.parseInt(codiceA.getText());

        //Controllo valori
        if(cod<0 || codiceA.getText().isEmpty() )
            throw new Custom_Exception("Compila il campo\nCodice deve avere un valore >0.");

        inviaNotifica();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
            tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            col_codArr.setCellValueFactory(new PropertyValueFactory<Sostituzione, Integer>("codice"));
            col_nome.setCellValueFactory(new PropertyValueFactory<Sostituzione,String>("nome"));
            col_descrizione.setCellValueFactory(new PropertyValueFactory<Sostituzione,String>("descrizione"));

            TipoTabella<Sostituzione> tab = new TipoTabella<Sostituzione>(new Tabella_Sostituzione());
            tableView.setItems(tab.getElements());

            db = new Database();
        }
        catch(Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }

    /**
     * Metodo che effettua l'invio della notifica tramite Command Pattern
     */
    public void inviaNotifica() {

        String email = null;
        String cellulare = null;

        try {
            ResultSet result = null;

            String sql="SELECT emailCliente FROM mobilificio.sostituzione WHERE codiceArr="+ codiceA.getText();
            ResultSet rs=db.query(sql);

            if (result.next()) {
                email = result.getString("EMAIL");

                String sql2="SELECT cellulareCliente FROM mobilificio.sostituzione WHERE codiceArr="+ codiceA.getText();
                ResultSet rs2=db.query(sql);

                if (result.next()) {
                    cellulare = result.getString("CELLULARE");
                    System.out.println(cellulare);
                    if (result.isBeforeFirst()) {
                        System.out.println("Errore. Non è stato trovato nessun cellulare");
                    }
                }

                System.out.println(email);
                if (result.isBeforeFirst()) {
                    System.out.println("Errore. Non è stato trovato nessuna email");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        SendRecepit notifica = new SendRecepit();
        Sms SMS = new Sms();
        Email emailProprietario = new Email();
        Command notificaSms = new SmsCommand(SMS);
        Command notificaEmail = new EmailCommand(emailProprietario);

        // Invio SMS
        notifica.setCommand(notificaSms);
        notifica.send();

        // Invio Email
        notifica.setCommand(notificaEmail);
        notifica.send();

        JOptionPane.showMessageDialog(null,"Notifica inviata correttamente al cliente");
    }
}
