package strategy.pattern;

import javafx.collections.ObservableList;
/**
 * Interfaccia del Pattern Strategy
 * Il paramento E può essere: 'Articolo'
 */
public interface Tabella<E> {
    /**
     * Metodo che ritorna la lista di elementi da inserire nella TableView
     */
    public ObservableList<E> crea();
}
