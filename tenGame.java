import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class tenGame {
    public static int check(ArrayList<Integer> lis, int at, String s) {
        if (at == 10) System.out.println(s);
        else {
            for (int i = 0; i < lis.size(); i++) {
                int temp = lis.get(i);
                lis.remove(i);
                check(lis, at + temp, s + "+" + temp);
                check(lis, at - temp, s + "-" + temp);
                check(lis, at * temp, s + "*" + temp);
                lis.add(i, temp);
            }
        }
    }
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> lis = new ArrayList<Integer>();
        lis.add(s.nextInt());

        check(lis, 0, "");
    }
}