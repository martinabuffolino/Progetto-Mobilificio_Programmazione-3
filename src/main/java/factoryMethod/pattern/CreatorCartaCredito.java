package factoryMethod.pattern;
/**
 * Classe che rappresenta un "ConcreteCreator" del pattern Factory Method
 * che si occupa di creare il "Product" CartaCredito
 * @see Creator
 */
public class CreatorCartaCredito implements Creator{
    private MetodoPagamento carta;

    public CreatorCartaCredito(String nom,String cogn,String card)
    {
        carta = new CartaCredito(nom,cogn,card);
        getMetodo();
    }

    /**
     * Metodo "factory" del Pattern
     */
    public MetodoPagamento getMetodo()
    {
        return carta;
    }
}