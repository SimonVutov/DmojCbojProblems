import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCCProblemJ1 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int P = s.nextInt();
        int C = s.nextInt();
        int points = 0;
        if (P > C) {
            points += 500;
        }
        points += 50*P - 10*C;
        System.out.println(points);
    }
}