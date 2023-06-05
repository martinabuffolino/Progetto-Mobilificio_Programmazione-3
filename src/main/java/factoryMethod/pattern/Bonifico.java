package factoryMethod.pattern;
/**
 * Classe che estende "DatiSensibili" e rappresenta il metodo di pagamento "Bonifico"
 *
 */
public class Bonifico extends DatiSensibili{

    private String iban;
    /**
     * Costruttore che inizializza la classe
     * @param a nome, contenuto nella superclasse
     * @param b cognome, contenuto nella superclasse
     * @param c iban
     */
    public Bonifico(String a,String b,String c) {
        super(a,b);
        iban=c;
    }

    public String getIban() {
        return iban;}

    @Override
    public String paga() {
        return "Il conto e' stato saldato attraverso un bonifico con iban: "+iban;
    }
}
