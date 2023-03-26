import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class COCI21Contest41Autići {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int min = Integer.MAX_VALUE;
        long total = 0;
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            min = Math.min(min, x);
            total += x;
        }

        total += (n - 1) * min;
        total -= min;

        System.out.println(total);
    }
}