import java.io.Serializable; 

// Classe para financiamento de Apartamento.
// Ela herda a classe principal Financiamento e implementa Serializable (para persistência).
public class Apartamento extends Financiamento implements Serializable {
    
    // ID de serialização padrão (necessário para salvar o objeto em binário)
    private static final long serialVersionUID = 1L; 
    
    // Taxa extra específica para apartamentos (0.08 = 8%)
    private final double taxaExtra = 0.08;

    // Construtor
    public Apartamento(double valorImovel, int prazoAnos, double taxaJuros) {
        // Chama o construtor da classe Financiamento (a superclasse)
        super(valorImovel, prazoAnos, taxaJuros);
    }

    // Método que calcula o pagamento por mês. Sobrescreve o método abstrato.
    @Override
    public double calcularPagamentoMensal() {
        // Fórmula base do financiamento (valor, prazo e juros)
        double calculoPadrao = (this.valorImovel / (this.prazoAnos * 12)) * (1 + (this.taxaJuros / 12));
        
        // Aplica a taxa extra do apartamento no cálculo final.
        return calculoPadrao * (1 + this.taxaExtra);
    }
}