// Esta é a nossa exceção customizada, criada para ser lançada quando 
// um objeto Financiamento é construído com valores que não fazem sentido (por exemplo, negativos).
// Ela estende RuntimeException para que o compilador não nos force a declarar o 'throws'.
public class FinanciamentoInvalidoException extends RuntimeException {
    
    // Construtor que recebe a mensagem de erro que será exibida no console.
    public FinanciamentoInvalidoException(String mensagem) {
        super(mensagem);
    }
}