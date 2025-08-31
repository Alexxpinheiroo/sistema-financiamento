// Classe para financiamento de apartamento
public class Apartamento extends Financiamento {

    // Taxa extra pra apartamentos
    private final double taxaExtra = 0.08;

    // Construtor
    public Apartamento(double valorImovel, int prazoAnos, double taxaJuros) {
        // Usa o construtor da classe 'pai' (Financiamento)
        super(valorImovel, prazoAnos, taxaJuros);
    }

    // Calcula o valor do pagamento por mês
    @Override
    public double calcularPagamentoMensal() {
        // Usa a fórmula padrão da classe base e adiciona a taxa extra
        double calculoPadrao = (this.valorImovel / (this.prazoAnos * 12)) * (1 + (this.taxaJuros / 12));
        return calculoPadrao * (1 + this.taxaExtra);
    }
}