import java.io.Serializable;

// Classe base (abstrata) para representar qualquer tipo de financiamento.
// Implementamos Serializable para poder salvar e ler o objeto em arquivo (persistência).
public abstract class Financiamento implements Serializable {

    // ID de serialização padrão (boa prática para salvar o objeto).
    private static final long serialVersionUID = 1L; 

    protected double valorImovel;
    protected int prazoAnos;
    protected double taxaJuros;

    // Construtor
    public Financiamento(double valorImovel, int prazoAnos, double taxaJuros) {
        
        // Validação de dados (Tratamento de Exceções)
        // Se os valores não forem válidos, lançamos a exceção customizada.
        if (valorImovel <= 0 || prazoAnos <= 0 || taxaJuros < 0) {
            throw new FinanciamentoInvalidoException("O valor do imóvel e o prazo devem ser positivos.");
        }
        
        this.valorImovel = valorImovel;
        this.prazoAnos = prazoAnos;
        this.taxaJuros = taxaJuros;
    }

    // Método para pegar o valor do imóvel (Encapsulamento)
    public double getValorImovel() {
        return this.valorImovel;
    }

    // Método abstrato que força cada subclasse (Casa, Terreno, Apartamento) 
    // a ter seu próprio cálculo de pagamento (Polimorfismo).
    public abstract double calcularPagamentoMensal();

    // Método que calcula o valor total do financiamento (mesmo para todos).
    public double calcularPagamentoTotal() {
        // Multiplica o valor mensal pelo número total de meses.
        return this.calcularPagamentoMensal() * this.prazoAnos * 12;
    }
    
    // Método para criar uma linha de texto para salvar no arquivo (Persistência de Dados).
    public String toTextFileString() {
        // O nome da classe é usado para saber qual objeto recriar na leitura.
        return this.getClass().getSimpleName() + "|" + 
               this.valorImovel + "|" + 
               this.prazoAnos + "|" + 
               this.taxaJuros;
    }
}