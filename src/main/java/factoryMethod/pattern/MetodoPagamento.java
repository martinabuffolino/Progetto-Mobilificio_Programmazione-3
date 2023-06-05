package factoryMethod.pattern;

/**
 * Interfaccia per i "Product" del pattern Factory Method
 * L'interfaccia implementa un metodo paga che, a seconda del tipo di classe richiamante,
 * eseguirà un operazione speficica.
 *
 */

public interface MetodoPagamento {
    public String paga();
}
