import java.io.Serializable; 

// Classe para financiamento de Terreno.
// Ela herda (extends) a classe principal Financiamento e implementa Serializable.
public class Terreno extends Financiamento implements Serializable {

    // ID de serialização padrão para garantir a leitura/escrita em arquivo
    private static final long serialVersionUID = 1L; 
    
    // Taxa extra específica para terrenos (0.02 = 2%)
    private final double taxaExtra = 0.02;

    // Construtor
    public Terreno(double valorImovel, int prazoAnos, double taxaJuros) {
        // Chama o construtor da classe Financiamento (a superclasse) para inicializar os atributos
        super(valorImovel, prazoAnos, taxaJuros);
    }

    // Método que calcula o pagamento por mês. É obrigatório por causa da classe abstrata!
    @Override
    public double calcularPagamentoMensal() {
        // Fórmula base do financiamento (valor, prazo e juros)
        double calculoPadrao = (this.valorImovel / (this.prazoAnos * 12)) * (1 + (this.taxaJuros / 12));
        
        // Aplica a taxa extra do terreno no cálculo final.
        return calculoPadrao * (1 + this.taxaExtra);
    }
}