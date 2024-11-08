import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

abstract class HashTableChained {
    protected List<String>[] table;
    protected int size;
    protected int collisions;

    public HashTableChained(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        this.collisions = 0;

        // Inicializa cada posição com uma LinkedList vazia
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    protected abstract int hash(String key);  // Método abstrato para função hash

    // Inserção com listas encadeadas
    public void insert(String key) {
        int index = Math.abs(hash(key)) % size;
        List<String> chain = table[index];

        if (chain.contains(key)) {
            System.out.println("Chave já existe: " + key);
            return;
        }

        if (!chain.isEmpty()) {
            collisions++;  // Incrementa colisões se a lista já contém elementos
        }

        chain.add(key);
    }

    // Busca na lista encadeada
    public boolean search(String key) {
        int index = Math.abs(hash(key)) % size;
        return table[index].contains(key);
    }

    // Retorna o número de colisões
    public int getCollisions() {
        return collisions;
    }

    // Retorna a distribuição das chaves
    public int[] getDistribution() {
        int[] distribution = new int[size];
        for (int i = 0; i < size; i++) {
            distribution[i] = table[i].size();
        }
        return distribution;
    }
}