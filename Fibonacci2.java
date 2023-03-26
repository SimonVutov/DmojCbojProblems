import java.util.Scanner;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Fibonacci2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = s.nextInt();
        BigInteger[] fib = new BigInteger[n + 1];
        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) fib[i] = fib[i - 1].add(fib[i - 2]);
        System.out.println(fib[n].mod(BigInteger.valueOf(1000000007)));
    }
}