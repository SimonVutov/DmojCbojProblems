import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//https://cboj.ca/problem/cbojr1p3
public class Octomesters {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        int[] c = new int[a];
        for (int i = 0; i < a; i++) c[i] = s.nextInt();
        Arrays.sort(c);

        if (a == 0 || b == 0){
            System.out.println(0);
            return;
        }

        long daysDidntStudy = 0;
        long todoList = b;
        long lasttest = c[c.length - 1];
        for (int i = c.length - 2; i >= 0; i--){
            long dayspast = lasttest - c[i];
            if (dayspast > todoList){
                daysDidntStudy += dayspast - todoList;
                todoList = 0;
            }
            else todoList -= dayspast;
            todoList += b;
            lasttest = c[i];
        }

        System.out.println(Math.max(c.length * b - c[c.length - 1] + daysDidntStudy + 1, 0));
    }
}