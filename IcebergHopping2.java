import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
//https://cboj.ca/problem/binarysearch1
public class IcebergHopping2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int x = s.nextInt();
        int y = s.nextInt();
        int [] z = new int[x];
        for (int i = 0; i < x; i++) z[i] = s.nextInt();
        int max = 2147483647;

        for (int i = 0; i < x-y + 1; i++){
            int g = 0;
            for (int j = 0; j < y; j++) if (g < z[i+j]) g = z[i+j];
            if (max > g) max = g;
        }

        if (y > x) System.out.println(Math.min(z[0], z[x - 1]));
        else if (max != 2147483647) System.out.println(Math.min(Math.min(max, z[0]), z[x - 1]));
        else System.out.println("0");
    }
}