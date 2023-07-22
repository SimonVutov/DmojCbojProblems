import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CBOJExecSelectionContest2Problem2PatrykandPrimes {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int input = s.nextInt();
        int primes = 0;
        for (int i = 0; i < input; i++) {
            if (isPrime(s.nextInt())) primes++;
        }
        System.out.println(primes);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;

        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}