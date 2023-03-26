import java.util.Scanner;
import java.io.*;
import java.util.*;

public class preprocess2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        int[] c = new int[a];
        int[] d = new int[a];
        for (int i = 0; i < a; i++) c[i] = s.nextInt();
        for (int i = 0; i < b; i++) {
            int de = s.nextInt();
            int e = s.nextInt();
            int f = s.nextInt();
            if (e < a) {
                d[de - 1] += f;
                d[e] -= f;
            } else {
                d[de - 1] += f;
            }
        }
        int diff = d[0];
        for (int i = 0; i < a - 1; i++) {
            System.out.print(c[i] + diff + " ");
            diff += d[i + 1];
        }
        System.out.print(c[a - 1] + diff + " ");
    }
}