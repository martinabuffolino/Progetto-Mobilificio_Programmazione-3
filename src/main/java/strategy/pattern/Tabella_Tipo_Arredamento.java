package strategy.pattern;

import application.Articolo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import singleton.pattern.Database;

import java.sql.ResultSet;

/**
 * Classe Tabella_Arredamento: rappresenta una "ConcreteStrategy" del Pattern Strategy,
 * Inizzializza una tabella che contiene tutti gli articoli del database
 */
public class Tabella_Tipo_Arredamento implements Tabella<Articolo>{

    @FXML
    private ObservableList<Articolo> data;

    private String arred;

    public Tabella_Tipo_Arredamento(String x)
    {

        data = FXCollections.observableArrayList();
        arred = x;
    }

    /**
     * Metodo che ritorna la lista di arredamenti presenti nel database
     */
    @Override
    public ObservableList<Articolo> crea()
    {
        try
        {
            Database db = new Database();
            String sql="SELECT * FROM mobilificio.articolo WHERE arredamento = '" + arred + "'";
            ResultSet rs=db.query(sql);
            while(rs.next())
            {
                data.add(new Articolo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8)));
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