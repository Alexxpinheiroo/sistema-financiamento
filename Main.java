import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
// import java.lang.reflect.Constructor; // REMOVIDO: Reflection é avançado demais
// import java.lang.reflect.InvocationTargetException; // REMOVIDO: Não precisamos mais

// A classe principal onde a gente testa o código (Requisitos: Listas, Try/Catch, Persistência)
public class Main {
    
    // Nomes dos arquivos de persistência
    private static final String NOME_ARQUIVO_TEXTO = "financiamentos_texto.txt";
    private static final String NOME_ARQUIVO_SERIAL = "financiamentos_serial.bin";

    // Salva a lista em formato de texto (Requisito: Escrita de Texto)
    public static void salvarEmTexto(ArrayList<Financiamento> lista) {
        try (PrintWriter writer = new PrintWriter(NOME_ARQUIVO_TEXTO)) {
            for (Financiamento f : lista) {
                writer.println(f.toTextFileString());
            }
            // Comentário simples do aluno
            System.out.println("\n[PERSISTÊNCIA] Dados salvos no arquivo de texto: " + NOME_ARQUIVO_TEXTO); 
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados de texto: " + e.getMessage());
        }
    }

    // Lê a lista a partir do arquivo de texto (Requisito: Leitura de Texto SIMPLIFICADA)
    public static ArrayList<Financiamento> lerDeTexto() {
        ArrayList<Financiamento> novaLista = new ArrayList<>();
        File arquivo = new File(NOME_ARQUIVO_TEXTO);
        if (!arquivo.exists()) {
            return novaLista;
        }

        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split("\\|"); 
                
                String tipo = partes[0];
                double valorImovel = Double.parseDouble(partes[1]);
                int prazoAnos = Integer.parseInt(partes[2]);
                double taxaJuros = Double.parseDouble(partes[3]);

                // ABORDAGEM SIMPLIFICADA DE ESTUDANTE: Usando if/else ou switch para recriar o objeto.
                // É mais didático do que usar Reflection.
                
                if (tipo.equals("Casa")) {
                    novaLista.add(new Casa(valorImovel, prazoAnos, taxaJuros));
                } else if (tipo.equals("Apartamento")) {
                    novaLista.add(new Apartamento(valorImovel, prazoAnos, taxaJuros));
                } else if (tipo.equals("Terreno")) {
                    novaLista.add(new Terreno(valorImovel, prazoAnos, taxaJuros));
                } else {
                    System.err.println("Tipo de financiamento desconhecido encontrado: " + tipo);
                }
            }
            System.out.println("[PERSISTÊNCIA] Dados lidos do arquivo de texto: " + NOME_ARQUIVO_TEXTO);
        } catch (IOException | FinanciamentoInvalidoException e) { // Removemos as exceções complexas do Reflection
            System.err.println("Erro ao ler dados de texto: " + e.getMessage());
        }
        return novaLista;
    }

    // Salva a lista em formato serializado
    public static void salvarSerializado(ArrayList<Financiamento> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO_SERIAL))) {
            oos.writeObject(lista);
            System.out.println("[PERSISTÊNCIA] Dados salvos serializados em: " + NOME_ARQUIVO_SERIAL);
        } catch (IOException e) {
            System.err.println("Erro ao salvar serializado: " + e.getMessage());
        }
    }

    // Lê a lista a partir do arquivo serializado (Requisito: Leitura Serializada)
    public static ArrayList<Financiamento> lerSerializado() {
        ArrayList<Financiamento> novaLista = new ArrayList<>();
        File arquivo = new File(NOME_ARQUIVO_SERIAL);
        if (!arquivo.exists()) {
            return novaLista;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO_SERIAL))) {
            // A leitura exige um casting (conversão) para o tipo correto
            novaLista = (ArrayList<Financiamento>) ois.readObject(); 
            System.out.println("[PERSISTÊNCIA] Dados lidos serializados de: " + NOME_ARQUIVO_SERIAL);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler dados serializados: " + e.getMessage());
        }
        return novaLista;
    }
    
    // Método auxiliar para imprimir os totais
    public static void imprimirTotais(ArrayList<Financiamento> lista, String titulo) {
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (Financiamento f : lista) {
            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.calcularPagamentoTotal();
        }

        System.out.println("\n--- " + titulo + " ---");
        System.out.printf("Total de %d imóveis: R$ %.2f%n", lista.size(), totalImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f%n", totalFinanciamentos);
    }

    public static void main(String[] args) {

        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();

        // Cria e adiciona financiamentos usando try/catch (Critério de Tratamento de Exceções)
        try {
            System.out.println("--- Criando Financiamentos Válidos ---");
            listaFinanciamentos.add(new Casa(200000, 10, 0.06));
            listaFinanciamentos.add(new Apartamento(300000, 15, 0.08));
            listaFinanciamentos.add(new Terreno(150000, 8, 0.05));
            listaFinanciamentos.add(new Casa(250000, 12, 0.07));
            
            // Tentativa de criar um financiamento INVÁLIDO (para testar a exceção)
            System.out.println("\nTentando adicionar financiamento com prazo zero...");
            listaFinanciamentos.add(new Apartamento(50000, 0, 0.10)); // Esta linha lança FinanciamentoInvalidoException
            
        } catch (FinanciamentoInvalidoException e) {
            // Captura a exceção customizada, o que é um requisito do trabalho
            System.err.println("ERRO de Financiamento detectado: " + e.getMessage());
            System.out.println("O objeto inválido foi descartado. O programa continua com os válidos.");
        }
        
        // 1. RESULTADO DA LISTA INICIAL (VALIDA)
        imprimirTotais(listaFinanciamentos, "Resultados da Lista Inicial (Válida)");

        // 2. SALVAR DADOS
        salvarEmTexto(listaFinanciamentos);
        salvarSerializado(listaFinanciamentos);
        
        // 3. LER DADOS E IMPRIMIR (TESTE DE PERSISTÊNCIA)
        
        // Lendo do Arquivo de Texto 
        ArrayList<Financiamento> listaLidaDeTexto = lerDeTexto();
        imprimirTotais(listaLidaDeTexto, "Resultados da Lista Lida de Arquivo de Texto");

        // Lendo do Arquivo Serializado
        ArrayList<Financiamento> listaLidaSerializada = lerSerializado();
        imprimirTotais(listaLidaSerializada, "Resultados da Lista Lida Serializada");
    }
}