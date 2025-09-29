import java.io.Serializable; 

// Classe para financiamento de Casa.
// Ela herda a classe principal Financiamento e implementa Serializable (para persistência).
public class Casa extends Financiamento implements Serializable {
    
    // ID de serialização padrão (necessário para salvar o objeto em binário)
    private static final long serialVersionUID = 1L; 
    
    // Taxa extra específica para casas (0.05 = 5%)
    private final double taxaExtra = 0.05;

    // Construtor
    public Casa(double valorImovel, int prazoAnos, double taxaJuros) {
        // Chama o construtor da classe Financiamento para inicializar os atributos principais
        super(valorImovel, prazoAnos, taxaJuros);
    }

    // Método que calcula o pagamento por mês. É obrigatório por causa da classe abstrata!
    @Override
    public double calcularPagamentoMensal() {
        // Fórmula base do financiamento (valor, prazo e juros)
        double calculoPadrao = (this.valorImovel / (this.prazoAnos * 12)) * (1 + (this.taxaJuros / 12));
        
        // Aplica a taxa extra da casa no cálculo final.
        return calculoPadrao * (1 + this.taxaExtra);
    }
}