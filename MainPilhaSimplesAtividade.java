import java.util.Scanner;

public class MainPilhaSimplesAtividade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilhaSimplesAtividade pilha = new PilhaSimplesAtividade(5);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU PILHA ===");
            System.out.println("1 - Inserir elemento");
            System.out.println("2 - Inserir elemento em índice");
            System.out.println("3 - Inserir sequência de elementos");
            System.out.println("4 - Remover elemento (topo)");
            System.out.println("5 - Remover por índice");
            System.out.println("6 - Remover sequência de elementos");
            System.out.println("7 - Remover todas ocorrências de um elemento");
            System.out.println("8 - Buscar elemento");
            System.out.println("9 - Buscar elemento por índice");
            System.out.println("10 - Editar elemento");
            System.out.println("11 - Exibir pilha");
            System.out.println("12 - Dobrar capacidade");
            System.out.println("13 - Ordenar crescente");
            System.out.println("14 - Ordenar decrescente");
            System.out.println("15 - Limpar pilha");
            System.out.println("16 - Obter primeiro elemento");
            System.out.println("17 - Obter último elemento");
            System.out.println("18 - Verificar se está cheia");
            System.out.println("19 - Verificar se está vazia");
            System.out.println("20 - Ver quantidade de elementos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número a inserir: ");
                    int elem = scanner.nextInt();
                    pilha.inserirElemento(elem);
                    break;
                case 2:
                    System.out.print("Digite o número a inserir: ");
                    int valor = scanner.nextInt();
                    System.out.print("Digite o índice: ");
                    int indice = scanner.nextInt();
                    pilha.inserirElementoIndice(valor, indice);
                    break;
                case 3:
                    System.out.print("Quantos elementos deseja inserir? ");
                    int qtd = scanner.nextInt();
                    Integer[] sequencia = new Integer[qtd];
                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        sequencia[i] = scanner.nextInt();
                    }
                    pilha.inserirSequencia(sequencia);
                    break;
                case 4:
                    pilha.removerElemento();
                    break;
                case 5:
                    System.out.print("Digite o índice para remover: ");
                    int indRemover = scanner.nextInt();
                    Object removido = pilha.removerIndice(indRemover);
                    if (removido != null) {
                        System.out.println("Elemento removido: " + removido);
                    }
                    break;
                case 6:
                    System.out.print("Quantos elementos deseja remover? ");
                    int qtdRemover = scanner.nextInt();
                    Integer[] seqRemover = new Integer[qtdRemover];
                    for (int i = 0; i < qtdRemover; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        seqRemover[i] = scanner.nextInt();
                    }
                    pilha.removerSequencia(seqRemover);
                    break;
                case 7:
                    System.out.print("Digite o elemento a remover todas ocorrências: ");
                    int valRemover = scanner.nextInt();
                    pilha.removerTodasOcorrencias(valRemover);
                    break;
                case 8:
                    System.out.print("Digite o número a buscar: ");
                    int busca = scanner.nextInt();
                    boolean encontrado = pilha.buscarElemento(busca);
                    System.out.println(encontrado ? "Elemento encontrado!" : "Elemento não encontrado.");
                    break;
                case 9:
                    System.out.print("Digite o índice a buscar: ");
                    int idxBuscar = scanner.nextInt();
                    Object elemBuscado = pilha.buscarElementoIndice(idxBuscar);
                    if (elemBuscado != null) {
                        System.out.println("Elemento: " + elemBuscado);
                    }
                    break;
                case 10:
                    System.out.print("Elemento antigo: ");
                    int antigo = scanner.nextInt();
                    System.out.print("Elemento novo: ");
                    int novo = scanner.nextInt();
                    pilha.editarElemento(antigo, novo);
                    break;
                case 11:
                    pilha.exibir();
                    break;
                case 12:
                    pilha.dobrarCapacidade();
                    break;
                case 13:
                    pilha.ordenarCrescente();
                    System.out.println("Pilha agora esta em ordem Crescente.");
                    break;
                case 14:
                    pilha.ordenarDecrescente();
                    System.out.println("Pilha agora esta em ordem Descrescente.");
                    break;
                case 15:
                    pilha.limpar();
                    System.out.println("Pilha limpa.");
                    break;
                case 16:
                    System.out.println("Primeiro elemento: " + pilha.obterPrimeiroElemento());
                    break;
                case 17:
                    System.out.println("Último elemento: " + pilha.obterUltimoElemento());
                    break;
                case 18:
                    System.out.println(pilha.estaCheia() ? "Pilha está cheia." : "Pilha ainda tem espaço.");
                    break;
                case 19:
                    System.out.println(pilha.estaVazia() ? "Pilha está vazia." : "Pilha tem elementos.");
                    break;
                case 20:
                    System.out.println("Quantidade de elementos: " + pilha.quantidadeElementos());
                    break;

                case 0:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
