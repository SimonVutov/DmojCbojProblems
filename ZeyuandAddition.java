import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZeyuandAddition
{
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = s.nextInt();
        long k = s.nextLong();

        long[] a = new long[n];
        for (int i = 0; i < n; i++){
            a[i] = s.nextLong();
        }

        for (int i = 0; i < k; i++){
            for (int j = i; j < n; j++){
                long[] b = Arrays.copyOfRange(a, i, j);
                long sum = 0;
                for (long l : b) {
                    sum += l;
                }
                if (sum > k) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
