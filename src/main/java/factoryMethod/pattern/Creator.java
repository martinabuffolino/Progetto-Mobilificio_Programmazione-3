package factoryMethod.pattern;

/**
 * Interfaccia "Creator" del Pattern Factory Method
 * L'interfaccia gestisce il metodo di pagamento
 */

public interface Creator {
    public MetodoPagamento getMetodo();
}
