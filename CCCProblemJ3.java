import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCCProblemJ3 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        s.nextLine();
        int[][] d = new int[n][5];
        for (int i = 0; i < n; i++) {
            String str = s.nextLine();
            for (int j = 0; j < 5; j++) {
                d[i][j] = str.charAt(j); //89 is Y, 46 is N
            }
        }

        boolean firstPrint = true;

        boolean done = false;
        int lookingFor = n;
        while (!done) {
            for (int i = 0; i < 5; i++) {
                int people = 0;
                for (int j = 0; j < n; j++) {
                    if (d[j][i] == 89) people++;
                }
                if (people == lookingFor) {
                    if (firstPrint) {
                        System.out.print((i + 1));
                        firstPrint = false;
                    } else {
                        System.out.print("," + (i + 1));
                    }
                    done = true;
                }
            }
            lookingFor--;
        }
        System.out.println();
    }
}