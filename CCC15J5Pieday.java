import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC15J5Pieday {
    public static Scanner s = new Scanner(System.in);
    public static int[][][] dp = new int[251][251][251];
    public static int pie (int pies, int people, int min) {
        if (dp[pies][people][min] != 0) return dp[pies][people][min];
        if (pies == people || people == 1) return 1;
        for (int i = min; i <= (int)Math.floor(pies / people); i++) dp[pies][people][min] += pie(pies - i, people - 1, i);
        return dp[pies][people][min];
    }
    public static void main(String[] args)
    {
        int a = s.nextInt(); int b = s.nextInt();
        System.out.println(pie(a, b, 1));
    }
}