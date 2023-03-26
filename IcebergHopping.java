import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
//https://cboj.ca/problem/binarysearch1
public class IcebergHopping {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int x = s.nextInt();
        int y = s.nextInt();
        if (x == 0) return;
        int max = 2147483647;
        ArrayList<Integer> z = new ArrayList<>();
        int first = s.nextInt();
        int last = 2147483647;
        z.add(first);
        for (int i = Math.min(y - 1, x - 2); i >= 0 ; i--) {
            z.add(s.nextInt());
        }
        int g = 0;
        for (int i = 0; i < Math.max(x-y, 1); i++){
            g = z.remove(0);
            if (g <= max) for (Integer k : z) g = Math.max(g, k);
            if (max > g) max = g;
            if (i < x-y - 1) {
                z.add(s.nextInt());
            }
        }
        while (!z.isEmpty()) last = z.remove(0);
        if (y > x) System.out.println(Math.min(first, last));
        else if (max != 2147483647) System.out.println(Math.min(Math.min(max, first), last));
        else System.out.println("0");
    }
}