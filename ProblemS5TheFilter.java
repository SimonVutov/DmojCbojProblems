import java.util.Scanner;
import java.io.*;
import java.util.*;

public class ProblemS5TheFilter {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            boolean good = false;
            for (int k = 0; k < 3; k++) {
                if (k < Math.pow(3, k) % n) {
                    
                }
            }
            if (good) System.out.println(i);
        }
    }
}