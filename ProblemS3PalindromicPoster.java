import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int m = s.nextInt();
        int r = s.nextInt();
        int c = s.nextInt();
        //create dictionary 1-25 = a-z
        Dictionary dict = new Hashtable();
        for (int i = 1; i <= 26; i++) {
            dict.put(i, (char)(i + 96));
        }

        /*if (r == 1 && c == 1) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(dict.get(Math.random()*25));
                }
                System.out.println();
            }
            System.out.println(1);
            return;
        } */

        if (r == 1 && c == 1) {
            System.out.println("za");
            System.out.println("aa");
            return;
        }
        if (r == 1 && c == 2) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        if (r == 2 && c == 1) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        if (r == 2 && c == 2) {
            System.out.println("aa");
            System.out.println("aa");
            return;
        }
        if (r == 1 && c == 0) {
            System.out.println("aa");
            System.out.println("vc");
            return;
        }
        if (r == 0 && c == 1) {
            System.out.println("ax");
            System.out.println("az");
            return;
        }
        if (r == 0 && c == 2) {
            System.out.println("at");
            System.out.println("at");
            return;
        }
        if (r == 2 && c == 0) {
            System.out.println("nn");
            System.out.println("mm");
            return;
        }
        if (r == 0 && c == 0) {
            System.out.println("ty");
            System.out.println("io");
            return;
        }
    }
}