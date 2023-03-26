import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class Problem5 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int num = s.nextInt();
        if (num == 1) System.out.println(2);
        else System.out.println(Math.round(num + Math.floor(Math.sqrt(num - 2)) + 1));
    }
}