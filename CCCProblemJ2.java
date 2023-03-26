import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCCProblemJ2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int total = 0;
        for (int i = 0; i < n; i++) {
            String str = s.next();
            if (str.equals("Poblano")) {
                total += 1500;
            } else if (str.equals("Mirasol")) {
                total += 6000;
            } else if (str.equals("Serrano")) {
                total += 15500;
            } else if (str.equals("Cayenne")) {
                total += 40000;
            } else if (str.equals("Thai")) {
                total += 75000;
            } else if (str.equals("Habanero")) {
                total += 125000;
            }
        }
        System.out.println(total);
    }
}