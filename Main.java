import java.util.ArrayList;

// A classe principal onde a gente testa o código
public class Main {
    public static void main(String[] args) {

        // Cria uma lista (ArrayList) pra guardar os financiamentos
        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();

        // Adiciona 4 financiamentos diferentes na nossa lista
        listaFinanciamentos.add(new Casa(200000, 10, 0.06));
        listaFinanciamentos.add(new Apartamento(300000, 15, 0.08));
        listaFinanciamentos.add(new Terreno(150000, 8, 0.05));
        listaFinanciamentos.add(new Casa(250000, 12, 0.07));

        // Cria as variáveis pra guardar os totais
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        // Passa por cada financiamento na lista
        for (Financiamento f : listaFinanciamentos) {
            // Soma o valor do imóvel e o valor total do financiamento
            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.calcularPagamentoTotal();
        }

        // Mostra os resultados na tela
        System.out.printf("Total de todos os imóveis: R$ %.2f%n", totalImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f%n", totalFinanciamentos);
    }
}