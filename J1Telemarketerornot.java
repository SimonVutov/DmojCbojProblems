import java.util.Scanner;
import java.io.*;
import java.util.*;

public class J1Telemarketerornot {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int d = s.nextInt();
        if (a == 8 || a == 9) {
            if (d == 8 || d == 9) {
                if (b == c) {
                    System.out.println("ignore");
                } else 
                System.out.println("answer");
            } else 
            System.out.println("answer");
        } else 
        System.out.println("answer");
    }
}