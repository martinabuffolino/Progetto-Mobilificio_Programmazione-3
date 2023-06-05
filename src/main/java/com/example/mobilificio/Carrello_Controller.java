package com.example.mobilificio;

/**
 * Sample Skeleton for 'Carrello.fxml' Controller Class
 */

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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import singleton.pattern.Database;
import strategy.pattern.Tabella_Categoria;
import strategy.pattern.Tabella_Tipo_Arredamento;
import strategy.pattern.TipoTabella;

import javax.swing.*;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Carrello_Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="tableView"
    private TableView<Articolo> tableView;

    @FXML // fx:id="col_codice"
    private TableColumn<Articolo, Integer> col_codice;

    @FXML // fx:id="col_nome"
    private TableColumn<Articolo, String> col_nome;
    @FXML // fx:id="col_descrizione"
    private TableColumn<Articolo, String> col_descrizione;

    @FXML // fx:id="col_colore"
    private TableColumn<Articolo, String> col_colore;

    @FXML // fx:id="col_costo"
    private TableColumn<Articolo, Double> col_costo;

    @FXML
    private CheckBox check_categoria;
    @FXML
    private ChoiceBox<String> choice_categoria;

    @FXML
    private CheckBox check_arredamento;
    @FXML
    private ChoiceBox<String> choice_arredamento;

    @FXML // fx:id="labelSelezione"
    private Label labelSelezione;

    @FXML
    private TextField codiceA;

    @FXML // fx:id="Avanti"
    private Button Avanti;

    @FXML // fx:id="Indietro"
    private Button Indietro;

    @FXML // fx:id="invia"
    private Button invia;

    @FXML
    private Button aggiungi;


    @FXML
    private ObservableList<Articolo> data;
    @FXML
    private ObservableList<Articolo> selected;
    private Database db;

    /**
     * Inizializza tutte le variabili della classe
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try {
            tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            col_codice.setCellValueFactory(new PropertyValueFactory<Articolo, Integer>("codice"));
            col_nome.setCellValueFactory(new PropertyValueFactory<Articolo, String>("nome"));
            col_descrizione.setCellValueFactory(new PropertyValueFactory<Articolo, String>("descrizione"));
            col_colore.setCellValueFactory(new PropertyValueFactory<Articolo, String>("colore"));
            col_costo.setCellValueFactory(new PropertyValueFactory<Articolo, Double>("costo"));

            data = FXCollections.observableArrayList(); //per iniviare la selezione
            selected = FXCollections.observableArrayList(); //per inviare arredamento
            db = new Database();

            //Riempio la choicebox categoria
            String sql="SELECT DISTINCT categoria from mobilificio.articolo";
            ResultSet rs=db.query(sql);
            while(rs.next())
                choice_categoria.getItems().add(rs.getString(1));

            //Riempio la choicebox arredamento
            sql="SELECT DISTINCT arredamento from mobilificio.articolo";
            rs=db.query(sql);
            while(rs.next())
                choice_arredamento.getItems().add(rs.getString(1));
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }



    /**
     * Metodo mostra la tabella con tutti gli arredamenti importati dal database
     * in base alla categoria scelta utilizzando il Pattern Strategy
     */
    @FXML
    void handleInvia(ActionEvent event) throws Exception
    {
        data.clear();
        TipoTabella<Articolo> tab = null;
        if(check_categoria.isSelected())
        {
            String value = choice_categoria.getValue();
            tab = new TipoTabella<Articolo>(new Tabella_Categoria(value));
        }
        if(check_arredamento.isSelected())
        {
            String value = choice_arredamento.getValue();
            tab = new TipoTabella<Articolo>(new Tabella_Tipo_Arredamento(value));
        }
        tableView.setItems(tab.getElements());
    }

    @FXML
    void handleAggiungi(ActionEvent event) throws Exception
    {
        int cod;
        cod= Integer.parseInt(codiceA.getText());

        String sql="INSERT INTO mobilificio.carrello (codiceA)"+ "VALUES (?)";
        //PreparedStatement--> prepariamo lo statement
        PreparedStatement preparedStmt = db.insert(sql);
        //ad ogni ? assegniamo una stringa
        preparedStmt.setInt (1, cod);

        preparedStmt.execute(); //eseguo lo statement

        JOptionPane.showMessageDialog(null,"Arredamento inserito nel carrello");

        //Aggiorna Database
        String sql2 = "DELETE FROM mobilificio.articolo WHERE codice=" + cod;
        db.delete(sql2);


    }

    /**
     * Metodo che richiama l'interfaccia grafica "Pagamento.fxml"
     */
    @FXML
    void handleAvanti(ActionEvent event)  throws Exception
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Pagamento.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    /**
     * Metodo che richiama l'interfaccia grafica "Home.fxml"
     */
    @FXML
    void handleIndietro(ActionEvent event)  throws Exception{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }
}

