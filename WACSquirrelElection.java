import java.util.Scanner;
import java.io.*;
import java.util.*;

public class WACSquirrelElection
{
    public static Scanner s = new Scanner(System.in);
    public static int minPeople(int l, int[][] p, int total, int runningTotal, boolean[] won) {
        if (runningTotal > total / 2) {
            int votesNeeded = 0;
            for (int i = 0; i < l; i++) {
                if (won[i]) votesNeeded += p[i][0];
            }
            return votesNeeded;
        }

        int minPeople = Integer.MAX_VALUE;
        for (int i = 0; i < l; i++) {
            if (won[i]) continue;
            won[i] = true;
            minPeople = Math.min(minPeople, minPeople(l, p, total, runningTotal + p[i][1], won));
            won[i] = false;
        }
        System.out.println(Arrays.toString(won));
        return minPeople;
    }
    public static void main(String[] args)
    {
        int n = s.nextInt();

        int totalPoints = 0;

        int[][] p = new int[n][2]; //votes needed | points awarded

        for (int i = 0; i < n; i++) {
            p[i][0] = s.nextInt();
            p[i][1] = s.nextInt();
            totalPoints += p[i][1];
        }

        boolean[] won = new boolean[n];
        System.out.println(minPeople(n, p, totalPoints, 0, won));
    }
}