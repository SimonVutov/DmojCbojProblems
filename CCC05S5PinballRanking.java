import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CCC05S5PinballRanking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] games = new int[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            games[i] = Integer.parseInt(br.readLine());
            for (int k = 0; k < i; k++) if (games[i] < games[k]) total++;
        }
        System.out.println(String.format("%.2f", (double)(total + n)/(double)n));
    }
}