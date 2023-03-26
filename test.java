import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class test {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        double root1 = (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
        double root2 = (-b - Math.sqrt(b*b - 4*a*c))/(2*a);

        if (b*b - 4*a*c == 0) System.out.println("This has one solution " + root1);
        else if (b*b - 4*a*c > 0) System.out.println("This has two solutions " + root1 + " and " + root2);
        else System.out.println("This has no solution");

    }
}