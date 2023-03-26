import java.util.Scanner;
import java.io.*;
import java.util.*;
//https://cboj.ca/problem/kings
public class PlacingKings {
    public static Scanner s = new Scanner(System.in);
    public static int c (int p, int n) {
        if (n == 1) return p;
        if (p < 2 * n - 1) return 0;
        if (p == 2 * n - 1) return 1;
        int combinations = 0;
        for (int i = 1; i <= p - 2 * n + 2; i++) combinations += c(p - i - 1, n - 1);    
        return combinations;
    }
    public static void main(String[] args)
    {
        int x = s.nextInt();
        int y = s.nextInt();
        System.out.println(c(x, y));
    }
}