import java.util.Scanner;
import java.io.*;
import java.util.*;

public class AnAnimalContest2P2KoalaParty
{
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.nextInt();
        Arrays.sort(a);

        for (int i = 0; i < n; i++) {
            int left = i - 1; int right = i + 1;
            while (left >= 0 && right < n) {
                if (a[left] + a[right] == 2 * a[i]) {
                    System.out.println("3");
                    return;
                }
                else if (a[left] + a[right] < 2 * a[i]) right++;
                else left--;
            }
        }

        if (n >= 3) System.out.println("2");
        else {
            if((a[0] - a[1]) % 2 == 0) System.out.println("2");
            else System.out.println("1");
        }
    }
}