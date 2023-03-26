import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class SuspiciousCells {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        int[][] arr = new int[b][2];
        int[] c = new int[a];
        for (int i = 0; i < b; i++) {
            arr[i][0] = s.nextInt();
            arr[i][1] = s.nextInt();
            if (arr[i][0] == arr[i][1]){
                c[arr[i][0] - 1]++;
            } else {
                c[arr[i][0] - 1]++;
                c[arr[i][1] - 1]++;
            }
        }

        int[][] arr2 = new int [a][];
        for (int i = 0; i < a; i++) {
            arr2[i] = new int[c[i]];
        }

        for (int i = 0; i < b; i++) {
            int x = arr[i][0];
            int y = arr[i][1];

            boolean done = false;
            int count = 0;
            while (!done) {
                if (arr2[x-1][count] == y) {
                    done = true;
                }else if (arr2[x-1][count] == 0) {
                arr2[x-1][count] = y;
                done = true;
                }
                else {
                    count++;
                }
            }

            done = false;
            count = 0;
            while (!done) {
                if (arr2[y-1][count] == x) {
                    done = true;
                }else if (arr2[y-1][count] == 0) {
                arr2[y-1][count] = x;
                done = true;
                }
                else {
                    count++;
                }
            }
        }

        for (int[] is : arr2) {
            Arrays.sort(is);
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}