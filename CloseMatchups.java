import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
//https://cboj.ca/problem/binarysearch2
public class CloseMatchups {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int x = s.nextInt();
        int y = s.nextInt();
        int [] z = new int[x];
        for (int i = 0; i < x; i++) z[i] = s.nextInt();
        int counter = 0;

        for(int i = 0; i < x - 1; i++){
            for (int j = i + 1; j < x; j++) {
                if (Math.abs(z[i] - z[j]) <= y) counter++;
                //System.out.println(z[i] + " " + z[j] + (Math.abs(z[i] - z[j]) <= y) + " i" + i + " j" + j);
            }
        }

        System.out.println(counter);
    }
}