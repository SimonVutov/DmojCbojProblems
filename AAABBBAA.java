import java.util.Scanner;
import java.io.*;
import java.util.*;

public class AAABBBAA {
    public static Scanner s = new Scanner(System.in);

    public static int check (int len, String str) {
        if (len == 10) {
            if (!str.contains("ABBA")) {
                System.out.println(str + " ");
                return 1;
            }
            return 0;
        }
        int goodAnswers = 0;
        goodAnswers += check(len + 1, str + "A");
        goodAnswers += check(len + 1, str + "B");
        return goodAnswers;
    }

    public static void main(String[] args) {
        System.out.println(" -- " + check(0, ""));
    }
}