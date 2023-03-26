import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class AFenwickTreeProblem {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] sums;
    public static void main(String[] args) throws IOException {
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int q = Integer.parseInt(input1[1]);
        int[] fenwickTree = new int[n];
        int[] valuesOfXfenwickTree = new int[1000000];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            fenwickTree[i] = Integer.parseInt(input2[i]);
            update(valuesOfXfenwickTree, fenwickTree[i], 1);
        }

        String[] T = new String[q];
        int[] S = new int[q];
        int[] E = new int[q];

        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            T[i] = query[0];
            S[i] = Integer.parseInt(query[1]);
            E[i] = Integer.parseInt(query[2]);
        }

        for (int i = 0; i < n; i++) {
            int j = i + lsb(i + 1);
            if (j < n) {
                fenwickTree[j] += fenwickTree[i];
            }
        }

        for (int i = 0; i < q; i++) {
            switch (T[i]) {
                case "Q1": {
                    System.out.println(sum(fenwickTree, E[i] - 1) - sum(fenwickTree, S[i] - 2));
                    break;
                }
                case "Q2": {
                    System.out.println(sum(valuesOfXfenwickTree, E[i]) - sum(valuesOfXfenwickTree, S[i] - 1));
                    break;
                }
                case "U": {
                    update(valuesOfXfenwickTree, fenwickTree[S[i] - 1], -1);
                    update(valuesOfXfenwickTree, E[i], 1);
                    int j = S[i] - 1;
                    int diff = E[i] - fenwickTree[j];
                    while (j < fenwickTree.length) {
                        fenwickTree[j] += diff;
                        j = j + lsb(j + 1);
                    }
                    break;
                }
            }
        }
    }

    public static int sum(int[] fenwickTree, int i) {
        int sum = 0;
        while (i >= 0) {
            sum += fenwickTree[i];
            i = i - lsb(i + 1);
        }
        return sum;
    }

    private static int lsb(int i) {
        return i & -i;
    }

    private static void update(int[] fenwickTree, int i, int delta) {
        while (i < fenwickTree.length) {
            fenwickTree[i] += delta;
            i = i + lsb(i + 1);
        }
    }
}