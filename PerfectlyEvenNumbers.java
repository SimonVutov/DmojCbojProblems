import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class PerfectlyEvenNumbers {
    public static Scanner s = new Scanner(System.in);
    public static long amount (String a){
        long total = 0;

        for (int i = 0; i < a.length(); i++) {
            int b = Integer.parseInt(Character.toString((a.charAt(i))));
            if (b % 2 != 0) b++;
            b /= 2;
            total += ( b * Math.pow(5, a.length() - 1 - i) ) % 1000000007;
            if (Integer.parseInt(Character.toString((a.charAt(i)))) % 2 != 0) return total - 1;
        }
        return total - 1;
    }

    public static void main(String[] args)
    {
        System.out.println(amount(s.nextLine()));
    }
}