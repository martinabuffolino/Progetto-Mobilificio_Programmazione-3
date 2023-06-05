package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 * Classe Sostituzione: contiene i dati per richiedere una sostituzione
 *  * La classe per ogni attributo ha i metodi get e set
 */

public class Sostituzione {

    private SimpleIntegerProperty codiceArr;

    private SimpleStringProperty nomeArr;

    private SimpleStringProperty descrizioneArt;

    private SimpleStringProperty coloreArr;

    private SimpleStringProperty fornitoreArr;

    private SimpleStringProperty arredamentoTipo;

    private SimpleStringProperty categoriaArr;

    private SimpleStringProperty nomeCliente;

    private SimpleStringProperty cognomeCliente;

    private SimpleStringProperty emailCliente;

    private SimpleStringProperty cellulareCliente;

    /**
     * Costruttore vuoto
     */
    public Sostituzione()
    {
        codiceArr = new SimpleIntegerProperty(0);
        nomeArr = new SimpleStringProperty("");
        descrizioneArt = new SimpleStringProperty("");
        coloreArr = new SimpleStringProperty("");
        fornitoreArr = new SimpleStringProperty("");
        arredamentoTipo = new SimpleStringProperty("");
        categoriaArr = new SimpleStringProperty("");
        nomeCliente = new SimpleStringProperty("");
        cognomeCliente = new SimpleStringProperty("");
        emailCliente = new SimpleStringProperty("");
        cellulareCliente = new SimpleStringProperty("");
    }

    /**
     * Costruttore che inizializza ogni attributo di classe
     * @param codArr codiceArr
     * @param nomArr nomeArr
     * @param descArr descrizioneArt
     * @param colArr coloreArr
     * @param fornArr fornitoreArr
     * @param arredTip arredamentoTipo
     * @param catArr categoriaArr
     * @param nomeCl nomeCliente
     * @param cognCl cognomeCliente
     * @param emailCl emailCliente
     * @param cellCl cellulareCliente
     */

    public Sostituzione(int codArr, String nomArr, String descArr, String colArr, String fornArr, String arredTip, String catArr, String nomeCl, String cognCl, String emailCl, String cellCl)
    {
        codiceArr = new SimpleIntegerProperty(codArr);
        nomeArr = new SimpleStringProperty(nomArr);
        descrizioneArt = new SimpleStringProperty(descArr);
        coloreArr = new SimpleStringProperty(colArr);
        fornitoreArr = new SimpleStringProperty(fornArr);
        arredamentoTipo = new SimpleStringProperty(arredTip);
        categoriaArr = new SimpleStringProperty(catArr);
        nomeCliente = new SimpleStringProperty(nomeCl);
        cognomeCliente = new SimpleStringProperty(cognCl);
        emailCliente = new SimpleStringProperty(emailCl);
        cellulareCliente = new SimpleStringProperty(cellCl);
    }

    public int getCodice() {
        return codiceArr.get();
    }
    public void setCodice(int codArr) {
        codiceArr.set(codArr);
    }

    public String getNome() {
        return nomeArr.get();
    }
    public void setNome(String nomArr) {
        nomeArr.set(nomArr);
    }

    public String getDescrizione() {
        return descrizioneArt.get();
    }
    public void setDescrizione(String descArr) {
        descrizioneArt.set(descArr);
    }

    public String getColore() {
        return coloreArr.get();
    }
    public void setColore(String colArr) {
        coloreArr.set(colArr);
    }

    public String getFornitore() {
        return fornitoreArr.get();
    }
    public void setFornitore(String fornArr) {
        fornitoreArr.set(fornArr);
    }

    public String getArredamento() {
        return arredamentoTipo.get();
    }
    public void setArredamento(String arredTip) {
        arredamentoTipo.set(arredTip);
    }

    public String getCategoria() {
        return categoriaArr.get();
    }
    public void setCategoria(String catArr) {
        categoriaArr.set(catArr);
    }

    public String getNomec() {
        return nomeCliente.get();
    }
    public void setNomec(String nomeCl) {
        nomeCliente.set(nomeCl);
    }

    public String getCognomec() {
        return cognomeCliente.get();
    }
    public void setCognomec(String cognCl) {
        cognomeCliente.set(cognCl);
    }

    public String getEmail() {
        return emailCliente.get();
    }
    public void setEmail(String emailCl) {
        emailCliente.set(emailCl);
    }

    public String getCellulare() {
        return cellulareCliente.get();
    }
    public void setCellulare(String cellCl) {
        cellulareCliente.set(cellCl);
    }
}