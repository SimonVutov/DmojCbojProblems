import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CCC16S2TandemBicycle {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int t = s.nextInt();
        int n = s.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[2*n];
        for (int i = 0; i < n; i++) {
            arr3[i] = s.nextInt();
            arr1[i] = arr3[i];
        }
        for (int i = 0; i < n; i++) {
            arr3[i+n] = s.nextInt();
            arr2[i] = arr3[i+n];
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        int sum = 0;

        if (t == 1) {
            for (int i = 0; i < n; i++) {
                sum += Math.max(arr1[i], arr2[i]);
            }
        } else {
            for (int i = 0; i < n; i++) {
                sum += arr3[2*n - i - 1];
            }
        }
        System.out.println(sum);
    }
}