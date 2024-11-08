import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashTester {

    private static final int TABLE_SIZE = 5000;

    public static void main(String[] args) {
        HashTableFunction1Chained table1 = new HashTableFunction1Chained(TABLE_SIZE);
        HashTableFunction2Chained table2 = new HashTableFunction2Chained(TABLE_SIZE);

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\RA3\\src\\female_names.txt"))) {
            String name;
            long startTime, endTime;

            // Inserção na primeira tabela e medição de tempo
            startTime = System.nanoTime();
            while ((name = br.readLine()) != null) {
                table1.insert(name);
            }
            endTime = System.nanoTime();
            long insertTimeTable1 = endTime - startTime;

            System.out.println("Tabela 1 - Função Hash 1:");
            System.out.println("Número de colisões: " + table1.getCollisions());
            System.out.println("Tempo de inserção: " + insertTimeTable1 + " nanosegundos");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\RA3\\src\\female_names.txt"))) {
            String name;
            long startTime, endTime;

            // Inserção na segunda tabela e medição de tempo
            startTime = System.nanoTime();
            while ((name = br.readLine()) != null) {
                table2.insert(name);
            }
            endTime = System.nanoTime();
            long insertTimeTable2 = endTime - startTime;

            System.out.println("\nTabela 2 - Função Hash 2:");
            System.out.println("Número de colisões: " + table2.getCollisions());
            System.out.println("Tempo de inserção: " + insertTimeTable2 + " nanosegundos");

            // Distribuição de chaves
            System.out.println("\nDistribuição de chaves na Tabela 1:");
            printDistribution(table1.getDistribution());

            System.out.println("\nDistribuição de chaves na Tabela 2:");
            printDistribution(table2.getDistribution());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDistribution(int[] distribution) {
        for (int i = 0; i < distribution.length; i++) {
            System.out.printf("Posição %d: %d entradas\n", i, distribution[i]);
        }
    }
}
