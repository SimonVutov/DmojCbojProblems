import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CCC01S5PostsCorrespondenceProblem {
    public static Scanner s = new Scanner(System.in);
    public static boolean done = false;
    public static void send (String[] aArr, String[] bArr, String aStr, String bStr, int iterations, int[] sequence) {
        if (done) {
            System.exit(0);
            return;
        }
        if (iterations > 11) return;
        if (aStr.length() < bStr.length()) {
            if (!aStr.equals(bStr.substring(0, aStr.length()))) return;
        } else if (aStr.length() > bStr.length()){
            if (!bStr.equals(aStr.substring(0, bStr.length()))) return;
        } else if (aStr.equals(bStr) && aStr.length() != 0) {
            System.out.println(iterations);
            for (int i : sequence) System.out.println(i + 1);
            done = true;
            return;
        }

        int[] newSeq = new int[sequence.length + 1];
        for (int i = 0; i < sequence.length; i++) newSeq[i] = sequence[i];

        for (int i = 0; i < aArr.length; i++) {
            newSeq[newSeq.length - 1] = i;
            send(aArr, bArr, aStr + aArr[i], bStr + bArr[i], iterations + 1, newSeq);
        }

    }
    public static void main(String[] args)
    {
        int m = s.nextInt();
        int n = s.nextInt();
        String[] a = new String[n];
        String[] b = new String[n];

        for(int i = 0; i < n; i++) a[Math.max(0, i - 1)] = s.nextLine();
        a[n - 1] = s.nextLine();
        for(int i = 0; i < n; i++) b[i] = s.nextLine();

        int[] sequ = new int[0];

        send(a, b, "", "", 0, sequ);

        if (!done) System.out.println("No solution.");
    }
}