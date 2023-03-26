import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class SymmetricEncryption {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int[] a = new int[6];
        int total = 0;
        for(int i = 0; i < 6; i++) { a[i] = s.nextInt(); total += a[i]; }

        if (total % 2 != 0) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int k = j + 1; k < 6; k++) {
                    if (total - a[i] - a[j] - a[k] == total / 2) { System.out.println("YES"); return; }
                }
            }
        }

        System.out.println("NO");
    }
}