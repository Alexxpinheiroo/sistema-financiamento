// Classe base pra qualquer tipo de financiamento
public abstract class Financiamento {

    protected double valorImovel;
    protected int prazoAnos;
    protected double taxaJuros;

    // Construtor
    public Financiamento(double valorImovel, int prazoAnos, double taxaJuros) {
        this.valorImovel = valorImovel;
        this.prazoAnos = prazoAnos;
        this.taxaJuros = taxaJuros;
    }

    // Método para pegar o valor do imóvel
    public double getValorImovel() {
        return this.valorImovel;
    }

    // Método que vai calcular o pagamento por mês.
    // É abstrato porque cada tipo de financiamento (casa, apê) vai ter seu próprio jeito de calcular.
    public abstract double calcularPagamentoMensal();

    // Método que calcula o valor total do financiamento.
    public double calcularPagamentoTotal() {
        return this.calcularPagamentoMensal() * this.prazoAnos * 12;
    }
}