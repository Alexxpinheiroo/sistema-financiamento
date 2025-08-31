// Classe pra financiamento de casa
public class Casa extends Financiamento {
    
    // Taxa extra pra casas
    private final double taxaExtra = 0.05;

    // Construtor
    public Casa(double valorImovel, int prazoAnos, double taxaJuros) {
        // Usa o construtor da classe 'pai' (Financiamento)
        super(valorImovel, prazoAnos, taxaJuros);
    }

    // Calcula o valor do pagamento por mês
    @Override
    public double calcularPagamentoMensal() {
        // Usa a fórmula da superclasse e adiciona a taxa extra da casa
        double calculoPadrao = (this.valorImovel / (this.prazoAnos * 12)) * (1 + (this.taxaJuros / 12));
        return calculoPadrao * (1 + this.taxaExtra);
    }
}