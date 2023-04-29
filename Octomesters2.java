import java.util.Scanner;
import java.io.*;
import java.util.*;

//https://cboj.ca/problem/cbojr1p3
public class Octomesters2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        int[] c = new int[a];
        for (int i = 0; i < a; i++) c[i] = s.nextInt();
        Arrays.sort(c);
        if (a == 0 || b == 0){ System.out.println(0); return; }

        double daysDidntStudy = 0;
        double todoList = b;
        double lasttest = c[c.length - 1];
        for (int i = c.length - 2; i >= 0; i--){
            double dayspast = (double)lasttest - (double)c[i];
            if (dayspast > todoList){
                daysDidntStudy = (double)daysDidntStudy + (double)dayspast - (double)todoList;
                todoList = 0;
            }
            else {
                todoList = (double)todoList - (double)dayspast;
            }
            todoList = (double)todoList + (double)b;
            lasttest = (double)c[i];
        }

        System.out.println((int)Math.round(c.length * b - c[c.length - 1] + daysDidntStudy + 1));
    }
}
