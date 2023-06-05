package factoryMethod.pattern;

/*
 * Classe Astratta DatiSensibili: implementa l'interfaccia MetodoPagamento utilizzata per il pattern Factory Method,
 * la quale riassume le caratteristiche comuni tra le 2 sottoclassi
 */

public abstract class DatiSensibili implements MetodoPagamento{
    private String nome,cognome;

    public DatiSensibili() {}
    /**
     * Costruttore utilizzato dalle sottoclassi per inizializzare i due parametri
     * @param a nome
     * @param b cognome
     */
    public DatiSensibili(String a,String b) {nome=a;cognome=b;}
    public String getNome() {return nome;}
    public String getCognome() {return cognome;}

    /**
     * Metodo da sovrascrivere nelle sottoclassi
     */
    public abstract String paga();
}
