import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class PerfectlyEvenNumbers2 {
    public static Scanner s = new Scanner(System.in);
    public static int amount (int a){
        int total = 0;
        for (int i = 1; i < a; i++){
            String b = Integer.toString(i);
            boolean goodnum = true;
            for (int j = 0; j < b.length(); j++) {
                int c = Integer.parseInt(Character.toString((b.charAt(b.length() - 1 - j))));
                if (c % 2 != 0) goodnum = false;
            }
            if (goodnum) total++;
        }
        return total;
    }
    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++) {
            System.out.println(amount(i) + " " + i);
        }
    }
}