package strategy.pattern;

import application.Sostituzione;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import singleton.pattern.Database;

import java.sql.ResultSet;

/**
 * Classe Tabella_Sostituzione: rappresenta una "ConcreteStrategy" del Pattern Strategy,
 * Inizzializza una tabella che contiene tutti le sosituzioni richieste dal cliente salvate nel database
 */

public class Tabella_Sostituzione implements Tabella<Sostituzione>{

    @FXML
    private ObservableList<Sostituzione> data;

    public Tabella_Sostituzione()
    {

        data = FXCollections.observableArrayList();
    }

    /**
     * Metodo che ritorna la lista di arredamenti presenti nel database
     */
    @Override
    public ObservableList<Sostituzione> crea()
    {
        try
        {
            Database db = new Database();
            String sql="Select * from mobilificio.sostituzione";
            ResultSet rs=db.query(sql);
            while(rs.next())
            {
                data.add(new Sostituzione(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));
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
