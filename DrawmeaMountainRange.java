import java.util.Scanner;
import java.io.*;
import java.util.*;

public class DrawmeaMountainRange {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int [][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = s.nextInt();
            arr[i][1] = s.nextInt();
        }
        int combinations = 0;

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        System.out.println(Arrays.deepToString(arr));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < arr[i][1]; j++) {
                for (int k = 0; k < arr[i][0]; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}