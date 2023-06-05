package factoryMethod.pattern;
/**
 * Classe che rappresenta un "ConcreteCreator" del pattern Factory Method
 * che si occupa di creare il "Product" Bonifico
 */
public class CreatorBonifico implements Creator{
    private MetodoPagamento bon;

    public CreatorBonifico(String nom,String cogn,String iban)
    {
        bon = new Bonifico(nom,cogn,iban);
        getMetodo();
    }

    /**
     * Metodo "factory" del Pattern
     */
    public MetodoPagamento getMetodo()
    {
        return bon;
    }
}
