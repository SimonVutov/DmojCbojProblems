import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC13S3ChancesofWinning {
    public static Scanner s = new Scanner(System.in);
    public static int possibilities (int yourteam, boolean[][] played, int[] points) {
        
        int dubs = 0;

        int max = 0;
        for (int i = 0; i < 4; i++) {
            if (points[i] > max && i != yourteam) max = points[i];
        }

        boolean done = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) { 
                if (!played[i][j] && i != j) done = false;
            }
        }
        
        if (done) {
            if (max < points[yourteam]) return 1;
            else return 0;
        }

        innerloop:
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!played[i][j] && i != j) {
                    played[i][j] = true;
                    played[j][i] = true;
                    points[i] += 3;
                    dubs += possibilities(yourteam, played, points);
                    points[i] -= 3;
                    points[j] += 3;
                    dubs += possibilities(yourteam, played, points);
                    points[j] -= 3;
                    points[i]++;
                    points[j]++;
                    dubs += possibilities(yourteam, played, points);
                    points[i]--;
                    points[j]--;
                    played[i][j] = false;
                    played[j][i] = false;
                    break innerloop;
                }
            }
        }
        
        return dubs;
    }
    public static void main(String[] args) {
        int yourteam = s.nextInt() - 1;
        int games = s.nextInt();

        boolean[][] played = new boolean[4][4];
        int[] points = new int[4];

        for (int i = 0; i < games; i++) {
            int team1 = s.nextInt() - 1;
            int team2 = s.nextInt() - 1;
            int score1 = s.nextInt();
            int score2 = s.nextInt();
            played[team1][team2] = true;
            played[team2][team1] = true;
            if (score1 > score2) points[team1] += 3;
            else if (score2 > score1) points[team2] += 3;
            else { points[team1]++; points[team2]++; }
        }

        System.out.println(possibilities(yourteam, played, points));
    }
}