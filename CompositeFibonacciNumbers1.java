import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class CompositeFibonacciNumbers1 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int x = s.nextInt();
        int[] arr = new int[x];
        for(int i = 0; i < x; i++) arr[i] = s.nextInt();

        for (int i = 0; i < x; i++) {
            boolean done = false;
            int a = 0;
            int b = 0;
            int chunkstogether = 0;
            while (!done){
                if ((int)String.valueOf(arr[i]).length() == 1){
                    done = true;
                    System.out.println("NO");
                } else if (chunkstogether > 0 && a + 1 == (int)String.valueOf(arr[i]).length()) {
                    done = true;
                    System.out.println("YES");
                } else if (b + 1 == (int)String.valueOf(arr[i]).length()){
                    done = true;
                    System.out.println("NO");
                }else if (isFibonacci( Integer.parseInt( String.valueOf(arr[i]).substring(a, b + 1) ) )){
                    chunkstogether++;
                    b++;
                    a = b;
                } else {
                    b++;
                }
            }
        }
    }

    static boolean isPerfectSquare(int x)
    {
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }

    static boolean isFibonacci(int n)
    {
        return isPerfectSquare(5*n*n + 4) ||
               isPerfectSquare(5*n*n - 4);
    }
}