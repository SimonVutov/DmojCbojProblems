import java.util.Scanner;
import java.util.ArrayList;

public class CCC07S4Waterpark {
    public static Scanner s = new Scanner(System.in);
    public static class p {
        public ArrayList<Integer> list = new ArrayList<Integer>();
    }
    public static long slide(p[] points, int at, long[] memo) {
        if (points.length == at) return 1;
        if (memo[at - 1] != 0) return memo[at - 1];
        long total = 0;
        for (Integer i : points[at - 1].list) {
            if (i > at) total += slide(points, i, memo);
        }
        memo[at - 1] = total;
        return total;
    }

    public static void main(String[] args) {
        int n = s.nextInt();
        p[] points = new p[n];
        for (int i = 0; i < n; i++) points[i] = new p();
        int x = s.nextInt();
        int y = s.nextInt();
        while (!(x == 0 && y == 0)) {
            points[x - 1].list.add(y);
            x = s.nextInt();
            y = s.nextInt();
        }
        long[] memo = new long[n];
        System.out.println(slide(points, 1, memo));
    }
}
