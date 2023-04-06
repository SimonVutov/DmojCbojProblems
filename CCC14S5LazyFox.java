import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC14S5LazyFox {
    public static Scanner s = new Scanner(System.in);
    public static int travel (int[][] loc, double maxDistance, int x, int y, int candyCount) { //returns max points you can get starting at this house
        System.out.println(candyCount);
        for (int[] is : loc) {
            if (is[0] == x && is[1] == y) continue;
            if (Math.sqrt(Math.pow(Math.abs(y - is[1]) - is[0], 2) + Math.pow(Math.abs(y - is[1]), 2)) >= maxDistance) continue;
            candyCount = Math.max(candyCount, travel(loc, Math.sqrt(Math.pow(x - is[0], 2) + Math.pow(y - is[1], 2)), is[0], is[1], candyCount + 1));
        }
        return candyCount;
    }
    public static void main(String[] args) {
        int n = s.nextInt();
        int[][] locations = new int[n][2];
        for (int i = 0; i < n; i++) {
            locations[i][0] = s.nextInt();
            locations[i][1] = s.nextInt();
        }
        System.out.println("------" + travel(locations, Integer.MAX_VALUE, 0, 0, 0));
    }
}