import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CBOJWinterContestProblem2SuitcasePackingHard
{
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int w = Integer.parseInt(line1[1]);
        int[] weights = new int[n];
        String[] line2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) weights[i] = Integer.parseInt(line2[i]);
        //Arrays.parallelSort(weights);
        int[] counts = new int[w + 1];
        for (int i = 0; i < n; i++) counts[weights[i]]++;

        for (int i = 1; i <= w; i++) counts[i] += counts[i - 1];

        int[] sorted = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sorted[counts[weights[i]] - 1] = weights[i];
            counts[weights[i]]--;
        }

        weights = sorted;



        boolean[] used = new boolean[n];

        int count = 0;
        int use = 0;
        int largestClearIndex = n - 1;

        while (use < n) {
            int indexOfLarge = largestClearIndex;
            while (used[indexOfLarge]) indexOfLarge--;
            used[indexOfLarge] = true;
            largestClearIndex = indexOfLarge;

            int right = largestClearIndex - 1;
            int left = 0;
            int indexOfSmall = (right + left) / 2;

            while (left < right - 1) {
                if (weights[indexOfSmall] > w - weights[indexOfLarge]) right = indexOfSmall;
                else if (weights[indexOfSmall] <= w - weights[indexOfLarge]) left = indexOfSmall;
                indexOfSmall = (right + left) / 2;
            }
            while (weights[indexOfSmall] + weights[indexOfLarge] <= w && indexOfSmall < n - 1) indexOfSmall++;
            if (indexOfSmall > 0) indexOfSmall--;
            while (used[indexOfSmall] && indexOfSmall > 0) indexOfSmall--;

            if (!used[indexOfSmall] && weights[indexOfSmall] + weights[indexOfLarge] <= w) { used[indexOfSmall] = true; use++; }

            count++;
            use++;
        }
        System.out.println(count);
    }
}
