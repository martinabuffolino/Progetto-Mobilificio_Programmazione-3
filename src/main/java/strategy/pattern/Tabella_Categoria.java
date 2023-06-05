package strategy.pattern;

import application.Articolo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import singleton.pattern.Database;

import java.sql.ResultSet;

/**
 * Classe Tabella_Categoria: rappresenta una "ConcreteStrategy" del Pattern Strategy,
 * Inizzializza una tabella che contenga tutti gli articoli del database
 * filtrati in base alla categoria scelta dal cliente
 */
public class Tabella_Categoria implements Tabella<Articolo>{

    @FXML
    private ObservableList<Articolo> data;
    private String cat;

    /**
     * Costruttore che inizializza gli attributi di classe
     * Il paramento x può essere: 'Classico' o 'Moderno'
     */
    public Tabella_Categoria(String x)
    {
        data = FXCollections.observableArrayList();
        cat = x;
    }

    /**
     * Metodo che ritorna la lista di categorie presenti nel database
     */
    @Override
    public ObservableList<Articolo> crea()
    {
        try
        {
            Database db = new Database();
            String sql = "SELECT * FROM mobilificio.articolo WHERE categoria = '" + cat + "'";
            ResultSet rs = db.query(sql);
            while(rs.next())
            {
                Articolo art=new Articolo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8));
                data.add(art);
            }
        }
        catch(Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return data;
    }
}