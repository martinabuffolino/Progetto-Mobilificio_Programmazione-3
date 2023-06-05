package factoryMethod.pattern;
/**
 * Classe che estende "DatiSensibili" e rappresenta il metodo di pagamento "Carta di Credito"
 * @see DatiSensibili
 */
public class CartaCredito extends DatiSensibili{
    private String carta;
    /**
     * Costruttore della classe
     * @param a nome, contenuto nella superclassse
     * @param b cognome, contenuto nella superclasse
     * @param c carta
     */
    public CartaCredito(String a,String b,String c) {super(a,b);carta=c;}
    public String getCart() {return carta;}

    @Override
    public String paga() {return "Il conto e' stato saldato attraverso la carta di credito "+carta;}
}
