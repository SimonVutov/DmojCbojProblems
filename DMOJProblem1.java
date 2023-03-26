import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class DMOJProblem1 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int x = s.nextInt();
        int y = s.nextInt();
        int red = 0;
        if (y < x){
            int temp = x;
            x = y;
            y = temp;
        }

        if ((y%2==1) && (x%2==1))red = x*((int)(Math.floor((double)y/2) + 1));
        else red = x*y/2;

        System.out.println((red) + " " + (x*y-red));
    }
}