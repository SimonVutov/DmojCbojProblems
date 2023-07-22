import java.util.Scanner;
import java.io.*;
import java.util.*;

public class DMOPC22Contest4P2FakePainting {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int r = s.nextInt();
        int c = s.nextInt();
        int[][] initial = new int[r][c];
        int[][] end = new int[r][c];
        s.nextLine();
        for (int i = 0; i < r; i++) {
            String[] line = s.nextLine().split(" ");
            for (int j = 0; j < c; j++) {
                initial[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < r; i++) {
            String[] line = s.nextLine().split(" ");
            for (int j = 0; j < c; j++) {
                end[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = initial[i][j] - end[i][j];
            }
        }
        int[][] arrHorizontal = new int[r][c];
        int[][] arrVertical = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                arrHorizontal[i][j] = initial[i][c - j - 1] - end[i][c - j - 1];
                arrVertical[i][j] = initial[r - i - 1][j] - end[r - i - 1][j];
            }
        }

        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(arrHorizontal));
        System.out.println(Arrays.deepToString(arrVertical));
        System.out.println(Arrays.deepToString(initial));
        System.out.println(Arrays.deepToString(end));

        boolean done = false;

        for (int l = 0; l < 3; l++) {
            if (l == 1) arr = arrHorizontal;
            if (l == 2) arr = arrVertical;
            int t = 0;
            while (t < 10) {
                t++;
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (arr[i][j] > 0 && arr[r - i - 1][j] > 0) {
                            arr[i][j] -= Math.min(arr[i][j], arr[r - i - 1][j]);
                            arr[r - i - 1][j] -= Math.min(arr[i][j], arr[r - i - 1][j]);
                        }
                        if (arr[i][j] > 0 && arr[i][c - j - 1] > 0) {
                            arr[i][j] -= Math.min(arr[i][j], arr[i][c - j - 1]);
                            arr[i][c - j - 1] -= Math.min(arr[i][j], arr[i][c - j - 1]);
                        }
                        if (arr[i][j] < 0 && arr[r - i - 1][j] < 0) {
                            arr[i][j] -= Math.max(arr[i][j], arr[r - i - 1][j]);
                            arr[r - i - 1][j] -= Math.max(arr[i][j], arr[r - i - 1][j]);
                        }
                        if (arr[i][j] < 0 && arr[i][c - j - 1] < 0) {
                            arr[i][j] -= Math.max(arr[i][j], arr[i][c - j - 1]);
                            arr[i][c - j - 1] -= Math.max(arr[i][j], arr[i][c - j - 1]);
                        }
                    }
                }
                System.out.println(t + " - - ");
                for (int i = 0; i < r; i++)  {
                    for (int j = 0; j < c; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            System.out.println(l + "     - - - - ");
            for (int i = 0; i < r; i++)  {
                for (int j = 0; j < c; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }

        
    }
}