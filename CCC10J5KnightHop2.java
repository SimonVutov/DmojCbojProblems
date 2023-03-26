import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class CCC10J5KnightHop2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int x = s.nextInt();
        int y = s.nextInt();
        int xFind = s.nextInt();
        int yFind = s.nextInt();
        int[] board = {0, 3, 2, 3, 2, 3, 4, 5,
            3, 4, 1, 2, 3, 4, 3, 4,
            2, 1, 4, 3, 2, 3, 4, 5,
            3, 2, 3, 2, 3, 4, 3, 4,
            2, 3, 2, 3, 4, 3, 4, 5,
            3, 4, 3, 4, 3, 4, 5, 4,
            4, 3, 4, 3, 4, 5, 4, 5,
            5, 4, 5, 4, 5, 4, 5, 6};
        System.out.println(board[Math.abs(xFind - x) + Math.abs(yFind - y) * 8]);
    }
}