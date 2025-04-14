public class PilhaSimplesAtividade implements IEstruturaSimples {

    private int tamanho;
    private Integer[] pilha;
    private int posicaoDisponivel;

    public PilhaSimplesAtividade(int tamanho) {

        this.tamanho = tamanho;
        this.pilha = new Integer[tamanho];
        this.posicaoDisponivel = 0;
    }


    @Override
    public void inserirElemento(Object elemento) {
        if (estaCheia()) {
            System.out.println("A pilha está cheia. Não é possível empilhar o elemento "+ elemento);
        } else {
            pilha[posicaoDisponivel] = (Integer) elemento;
            System.out.println("Elemento inserido com sucesso!");
            posicaoDisponivel++;
        }
    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) {
        if (estaCheia()) {
            System.out.println("A pilha está cheia. Não é possível empilhar.");
            return;
        }
        if (indice < 0 || indice > posicaoDisponivel) {
            System.out.println("Por regra de pilha, os elementos devem ser empilhados em sequência. Não é possível inserir pulando posições.");
            return;
        }
        if (indice == posicaoDisponivel) {
            inserirElemento(elemento);
            return;
        }
        for (int i = posicaoDisponivel; i > indice; i--) {
            pilha[i] = pilha[i - 1];
        }
        pilha[indice] = (Integer) elemento;
        posicaoDisponivel++;

    }

    @Override
    public void inserirSequencia(Object elementos) {
        if (!(elementos instanceof Integer[])) {
            System.out.println("Tipo de sequência não suportado para inserção.");
            return;
        }
        Integer[] lista = (Integer[]) elementos;
        for (Integer elem : lista) {
            inserirElemento(elem);
        }
    }

    @Override
    public boolean removerElemento() {
        if (estaVazia()) {
            System.out.println("A pilha está vazia. Nada para desempilhar.");
        } else {
            System.out.println("Removendo: " + pilha[posicaoDisponivel]);
            pilha[posicaoDisponivel] = null;
            posicaoDisponivel--;
            return true;
        }
        return false;
    }

    @Override
    public Object removerIndice(int indice) {
        if (indice < 0 || indice >= posicaoDisponivel) {
            System.out.println("Índice inválido para remoção.");
            return null;
        }
        Integer removido = pilha[indice];
        for (int i = indice; i < posicaoDisponivel - 1; i++) {
            pilha[i] = pilha[i + 1];
        }
        pilha[posicaoDisponivel - 1] = null;
        posicaoDisponivel--;
        return removido;
    }

    @Override
    public void removerSequencia(Object elementos) {
        if (!(elementos instanceof Integer[])) {
            System.out.println("Tipo de sequência não suportado para remoção.");
            return;
        }
        Integer[] lista = (Integer[]) elementos;
        for (Integer elem : lista) {
            removerTodasOcorrencias(elem);
        }
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        int i = 0;
        while (i < posicaoDisponivel) {
            if (pilha[i].equals(elemento)) {
                removerIndice(i);
            } else {
                i++;
            }
        }
    }


    @Override
    public boolean estaCheia() {
        return posicaoDisponivel == tamanho - 1;

    }

    @Override
    public boolean estaVazia() {
        return posicaoDisponivel == 0;
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        return buscarIndice(elemento) != -1;
    }

    public int buscarIndice(Object elemento) {
        for (int i = 0; i < posicaoDisponivel; i++) {
            if (pilha[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object buscarElementoIndice(int indice) {
        if (indice < 0 || indice >= posicaoDisponivel) {
            System.out.println("Índice vazio ou inválido para buscar.");
            return null;
        }
        return pilha[indice];
    }

    @Override
    public void ordenarCrescente() {
        for (int i = 0; i < posicaoDisponivel - 1; i++) {
            for (int j = 0; j < posicaoDisponivel - i - 1; j++) {
                if (pilha[j] > pilha[j + 1]) {
                    int temp = pilha[j];
                    pilha[j] = pilha[j + 1];
                    pilha[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void ordenarDecrescente() {
        for (int i = 0; i < posicaoDisponivel - 1; i++) {
            for (int j = 0; j < posicaoDisponivel - i - 1; j++) {
                if (pilha[j] < pilha[j + 1]) {
                    int temp = pilha[j];
                    pilha[j] = pilha[j + 1];
                    pilha[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int quantidadeElementos() {
        return posicaoDisponivel;
    }

    @Override
    public void dobrarCapacidade() {
        int novoTamanho = tamanho * 2;
        Integer[] novaPilha = new Integer[novoTamanho];
        for (int i = 0; i < posicaoDisponivel; i++) {
            novaPilha[i] = pilha[i];
        }
        pilha = novaPilha;
        tamanho = novoTamanho;
        System.out.println("Capacidade dobrada para " + novoTamanho);
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {

        for (int i = 0; i < posicaoDisponivel; i++) {
            if (pilha[i].equals(elementoAntigo)) {
                pilha[i] = (Integer) elementoNovo;
            }
        }

    }

    @Override
    public void limpar() {
        for (int i = 0; i < posicaoDisponivel; i++) {
            pilha[i] = null;
        }
        posicaoDisponivel = 0;
    }

    @Override
    public void exibir() {
        System.out.print("Pilha: ");
        for (int i = posicaoDisponivel - 1; i >= 0; i--) {
            System.out.print(pilha[i] + " ");
        }
        System.out.println();
    }

    @Override
    public Object obterPrimeiroElemento() {
        if (estaVazia()) {
            System.out.println("Pilha vazia.");
            return null;
        }
        return pilha[0];
    }

    @Override
    public Object obterUltimoElemento() {
        if (estaVazia()) {
            System.out.println("Pilha vazia.");
            return null;
        }
        return pilha[posicaoDisponivel - 1];
    }
}

