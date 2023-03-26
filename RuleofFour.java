import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//https://cboj.ca/problem/cbojr2p1
public class RuleofFour {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        String a = s.nextLine();
        if (a.equals("4")) {
            System.out.println("YES");
            return;
        }
        if (Character.toString(a.charAt(0)).equals("0")) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < a.length(); i++){
            for (int j = 0; j < a.length(); j++){
                if (i != j){
                    if ((Integer.parseInt(Character.toString(a.charAt(i))) * 10 + Integer.parseInt(Character.toString(a.charAt(j)))) % 4 == 0 ){
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
    }
}