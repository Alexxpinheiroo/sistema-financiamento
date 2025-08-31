// Classe pra financiamento de terreno
public class Terreno extends Financiamento {

    // Taxa extra pra terrenos, que é menor
    private final double taxaExtra = 0.02;

    // Construtor
    public Terreno(double valorImovel, int prazoAnos, double taxaJuros) {
        // Usa o construtor da classe 'pai' (Financiamento)
        super(valorImovel, prazoAnos, taxaJuros);
    }

    // Calcula o valor do pagamento por mês, mas com uma taxa extra
    @Override
    public double calcularPagamentoMensal() {
        // Pega o cálculo base e já adiciona a taxa extra do terreno
        double calculoPadrao = (this.valorImovel / (this.prazoAnos * 12)) * (1 + (this.taxaJuros / 12));
        return calculoPadrao * (1 + this.taxaExtra);
    }
}