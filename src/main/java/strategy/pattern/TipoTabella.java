package strategy.pattern;

import javafx.collections.ObservableList;
/**
 * Classe TipoTabella: rappresenta il "Context" dello Strategy Pattern.
 * In base al tipo di "Tabella" ricevuta in input, esegue un algoritmo specifico
 */
public class TipoTabella<E> {
    /**
     * Attributo che rappresente l'interfaccia IStrategy del Pattern Strategy
     */
    private Tabella<E> tab;

    public TipoTabella(Tabella<E> x)
    {
        tab=x;
    }

    /**
     * Metodo che ritorna la lista di elementi da inserire nella tabella
     */
    public ObservableList<E> getElements()
    {
        return tab.crea();
    }
}