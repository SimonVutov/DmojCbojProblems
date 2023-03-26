import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class FloorPlan
{
    public static Scanner s = new Scanner(System.in);
    public static Integer bfs (char[][] floor, int i, int j)
    {
        int counter = 0;
        Queue<Integer> r = new LinkedList<Integer>();
        Queue<Integer> c = new LinkedList<Integer>();
        r.add(i);
        c.add(j);
        boolean visited[][] = new boolean[floor.length][floor[0].length];
        
        while (!r.isEmpty()){
            int row = r.poll();
            int col = c.poll();

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int[] dir : directions)
            {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < floor.length && newCol >= 0 && newCol < floor[0].length && floor[newRow][newCol] == '.' && !visited[newRow][newCol])
                {
                    visited[newRow][newCol] = true;
                    r.add(newRow);
                    c.add(newCol);
                    floor[newRow][newCol] = 'O';
                    counter++;
                    
                }
            }
        }

        return counter;
    }

    public static void main(String[] args)
    {
        int p = s.nextInt();
        int r = s.nextInt();
        int c = s.nextInt();

        int counter = 0;
        char[][] floor = new char[r][c];
        for (int i = 0; i < r; i++)
        {
            String line = s.next();
            for (int j = 0; j < c; j++)
            {
                counter++;
                floor[i][j] = line.charAt(j);
            }
        }

        //arraylist of room sizes
        ArrayList<Integer> roomSizes = new ArrayList<Integer>();

        boolean[][] visited = new boolean[r][c];

        //loop through every char
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (!visited[i][j] && floor[i][j] == '.')
                {
                    roomSizes.add(bfs(floor, i, j));
                }
            }
        }

        roomSizes.sort(Collections.reverseOrder());

        int roomsPainted = 0;

        for (int i : roomSizes)
        {
            if (p - i >= 0) { p -= i; roomsPainted++; }
            else break;
        }

        if (roomsPainted != 1) {
            System.out.println(roomsPainted + " rooms, " + p + " square metre(s) left over");
        } else {
            System.out.println(roomsPainted + " room, " + p + " square metre(s) left over");
        }
    }
}