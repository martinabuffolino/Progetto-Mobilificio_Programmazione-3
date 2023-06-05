package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Classe Articolo: contiene i dati dell'articolo
 *  * La classe per ogni attributo ha i metodi get e set
 */

public class Articolo extends Sostituzione {
    private SimpleIntegerProperty codice;
    private SimpleStringProperty nome;
    private SimpleStringProperty descrizione;
    private SimpleStringProperty colore;
    private SimpleDoubleProperty costo;
    private SimpleStringProperty fornitore;
    private SimpleStringProperty arredamento;
    private SimpleStringProperty categoria;

    /**
     * Costruttore vuoto
     */
    public Articolo()
    {
        codice = new SimpleIntegerProperty(0);
        nome = new SimpleStringProperty("");
        descrizione = new SimpleStringProperty("");
        colore = new SimpleStringProperty("");
        costo = new SimpleDoubleProperty(0);
        fornitore = new SimpleStringProperty("");
        arredamento = new SimpleStringProperty("");
        categoria = new SimpleStringProperty("");
    }

    /**
     * Costruttore che inizializza ogni attributo di classe
     * @param cod Codice
     * @param nom Nome
     * @param desc Descrizione
     * @param col Colore
     * @param forn Fornitore
     * @param cost Costo
     * @param arred Arredamento
     * @param cat Categoria
     */
    public Articolo(int cod,String nom,String desc,String col,double cost,String forn,String arred,String cat)
    {
        codice = new SimpleIntegerProperty(cod);
        nome = new SimpleStringProperty(nom);
        descrizione = new SimpleStringProperty(desc);
        colore = new SimpleStringProperty(col);
        costo = new SimpleDoubleProperty(cost);
        fornitore = new SimpleStringProperty(forn);
        arredamento = new SimpleStringProperty(arred);
        categoria = new SimpleStringProperty(cat);
    }

    public int getCodice() {
        return codice.get();
    }
    public void setCodice(int cod) {
        codice.set(cod);
    }

    public String getNome() {
        return nome.get();
    }
    public void setNome(String nom) {
        nome.set(nom);
    }

    public String getDescrizione() {
        return descrizione.get();
    }
    public void setDescrizione(String descr) {
        descrizione.set(descr);
    }

    public String getColore() {
        return colore.get();
    }
    public void setColore(String col) {
        colore.set(col);
    }

    public double getCosto() {
        return costo.get();
    }
    public void setCosto(double cost) {
        costo.set(cost);
    }

    public String getFornitore() {
        return fornitore.get();
    }
    public void setFornitore(String forn) {
        fornitore.set(forn);
    }

    public String getArredamento() {
        return arredamento.get();
    }
    public void setArredamento(String arr) {
        arredamento.set(arr);
    }

    public String getCategoria() {
        return categoria.get();
    }
    public void setCategoria(String cat) {
        categoria.set(cat);
    }
}
