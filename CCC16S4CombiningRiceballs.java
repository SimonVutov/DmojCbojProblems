import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC16S4CombiningRiceballs {
    public static Scanner s = new Scanner(System.in);
    public static int add (int[] arr, int largest) {
        System.out.println(Arrays.toString(arr) + " " + largest);
        if (arr.length == 1) return arr[0];
        boolean done = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] && arr[i] != -1) {
                int j = arr[i];
                int k = arr[i + 1];
                arr[i] = arr[i] + arr[i + 1];
                arr[i + 1] = -1;
                int[] temp = new int[arr.length - 1];
                int count = 0;
                int len = arr.length;
                for (int q = 0; q < len - 1; q++) {
                    if (arr[q] != -1) {
                        temp[q - count] = arr[q];
                    } else {
                        count++;
                        len++;
                    }
                }
                done = true;
                largest = Math.max(largest, add(temp, largest));
                arr[i] = j;
                arr[i + 1] = k;
            }
        }
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == arr[i + 2] && arr[i] != -1) {
                int j = arr[i];
                int m = arr[i + 1];
                int k = arr[i + 2];
                arr[i] = arr[i] + arr[i + 2] + arr[i + 1];
                arr[i + 2] = -1;
                arr[i + 1] = -1;
                int[] temp = new int[arr.length - 2];
                int count = 0;
                int len = arr.length;
                for (int q = 0; q < len - 2; q++) {
                    if (arr[q] != -1) {
                        temp[q - count] = arr[q];
                    } else {
                        count++;
                        len++;
                    }
                }
                done = true;
                largest = Math.max(largest, add(temp, largest));
                arr[i] = j;
                arr[i + 1] = m;
                arr[i + 2] = k;
            }
        }
        if (!done) for (int i = 0; i < arr.length; i++)
            largest = Math.max(largest, arr[i]);
        return largest;
    }
    public static void main(String[] args)
    {
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int largest = 0;
        for (int i = 0; i < arr.length; i++)
            largest = Math.max(largest, arr[i]);
        System.out.println(add(arr, largest));
    }
}