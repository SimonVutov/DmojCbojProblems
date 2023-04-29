import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CPC21Contest1P1AQTandFractions {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            int y = s.nextInt();

            boolean doneSimplifying = false;
            while (!doneSimplifying) {
                System.out.println(x + " " + y);
                doneSimplifying = true;
                innerloop:
                for (int j = 2; j < Math.min(x, y) / 2 + 1; j++) {
                    System.out.println("Checking " + x + " " + y + " by " + j);
                    if (x % j == 0 && y % j == 0) {
                        System.out.println("Simplifying " + x + " " + y + " by " + j);
                        x /= j;
                        y /= j;
                        doneSimplifying = false;
                        break innerloop;
                    }
                }
            }

            System.out.println(x + " " + y);
        }
    }
}