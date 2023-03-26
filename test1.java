import java.util.Scanner;
import java.io.*;
import java.util.*;

public class test1 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int a = Math.abs(s.nextInt());
        int b = Math.abs(s.nextInt());

        int k = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                k++;
            }
        }

        int[] array = new int[k];
        int counter = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                array[counter] = i;
                counter++;
            }
        }

        boolean complete = false;
        outerloop:
        for (int x : array) {
            for (int y : array) {
                for (int z : array) {
                    if (x*y*z==a && Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2)==b) {
                        System.out.println(x + " " + y + " " + z);
                        complete = true;
                        break outerloop;
                    }
                }
            }
        }
        if (!complete && a!=0 && b!=0) {
            System.out.println(-1);
        } else if (a==0 && b==0) {
            System.out.println("0 0 0");
        }
    }
}