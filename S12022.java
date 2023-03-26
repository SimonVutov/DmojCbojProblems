import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;

public class S12022 {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            if (b % 2 == 0 && (a > 0 || b > 0 || c > 0)) System.out.println("YES");
            else System.out.println("NO");
        }
    }   
}