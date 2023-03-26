import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CCC16S1Ragaman {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        String a = s.nextLine();
        String b = s.nextLine();
        int astericks = 0;

        int[] arr = new int[26];
        for (int i = 0; i < a.length(); i++){
            arr[a.charAt(i)-'a']++;
        }

        for (int i = 0; i < b.length(); i++){
            if (b.charAt(i) == '*') {
                astericks++;
                continue;
            }
            arr[b.charAt(i)-'a']--;
        }

        for (int i = 0; i < 26; i++){
            if (arr[i] < 0) {
                System.out.println("N");
                return;
            } else if (arr[i] > 0) {
                astericks -= arr[i];
            }
        }
        if (astericks < 0) {
            System.out.println("N");
        } else {
            System.out.println("A");
        }
    }
}