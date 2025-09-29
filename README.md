# Sistema de Simulação de Financiamento de Imóveis em Java

## 📜 Descrição do Projeto

Este projeto é um sistema de simulação de financiamento de imóveis desenvolvido para a disciplina de Programação Orientada a Objetos (POO). O objetivo é demonstrar a aplicação prática de conceitos fundamentais como: **Herança**, **Polimorfismo**, **Classes Abstratas**, **Tratamento de Exceções** e **Persistência de Dados (Serialização e Arquivos de Texto)**.

## ✨ Funcionalidades Avançadas

O sistema é capaz de:
* **Simular Financiamentos** para diferentes tipos de imóveis (`Casa`, `Apartamento`, `Terreno`), aplicando taxas de juros e prazos específicos.
* **Utilizar POO** de forma completa, com classes abstratas (`Financiamento`), herança e polimorfismo.
* **Gerenciar Múltiplos Financiamentos** usando a coleção `ArrayList`.
* **Tratar Dados Inválidos** utilizando blocos `try-catch` e uma **Exceção Customizada** (`FinanciamentoInvalidoException`) para garantir a estabilidade.
* **Persistência de Dados (Semana 8):**
    * **Ler e Escrever** a lista de financiamentos em um **arquivo de texto** (`financiamentos_texto.txt`).
    * **Ler e Escrever** a lista de objetos **serializados** em um arquivo binário (`financiamentos_serial.bin`).
* Apresentar o valor total dos imóveis e o valor total dos financiamentos realizados, incluindo a leitura dos dados salvos.

## 🛠️ Como Executar

Para rodar o projeto em sua máquina e testar a persistência de dados, siga os passos abaixo:

1.  **Baixe os arquivos:** Certifique-se de ter todos os arquivos Java (`Main.java`, `Financiamento.java`, `Casa.java`, `Apartamento.java`, `Terreno.java`, e o novo **`FinanciamentoInvalidoException.java`**) na mesma pasta.
2.  **Abra o terminal:** Navegue até a pasta onde os arquivos estão salvos.
3.  **Compile os arquivos:** Use o comando do compilador Java.
    ```bash
    javac *.java
    ```
4.  **Execute o programa:** Inicie a aplicação a partir da classe principal.
    ```bash
    java Main
    ```

### 📝 Saída Esperada

Após a primeira execução, o sistema irá:
1.  Exibir a mensagem de erro da exceção (por tentar criar um objeto inválido).
2.  Mostrar os resultados da lista inicial.
3.  Criar e salvar os dados nos dois arquivos: `financiamentos_texto.txt` e `financiamentos_serial.bin`.
4.  Mostrar os resultados lidos de ambos os arquivos, comprovando a funcionalidade de persistência.