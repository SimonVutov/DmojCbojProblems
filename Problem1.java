import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class Problem1 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int num = s.nextInt();
        int totalTime = 0;

        for (int i = 0; i < num; i++) {
            int a = s.nextInt();

            if (num / 2 <= num - i - 1) totalTime += a * (i + 1);
            else totalTime += a * (num - i);
        }

        System.out.println(totalTime);
    }
}