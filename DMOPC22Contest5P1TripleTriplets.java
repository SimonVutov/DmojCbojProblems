import java.util.Scanner;
import java.io.*;
import java.util.*;

public class DMOPC22Contest5P1TripleTriplets {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt() - 2;
        int nFact = 1;
        if (n + 2 <= 3) {
            System.out.println(0);
            return;
        }
        for (int i = 1; i <= n; i++) nFact *= i;
        System.out.println(nFact/(2*(nFact/(n*(n-1)))));
    }
}