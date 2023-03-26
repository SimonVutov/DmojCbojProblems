import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class S2EscapeRoom{
    public static Scanner s = new Scanner(System.in);

    class Cell {
        public int r;
        public int c;
    }

    private static boolean[][] searched = new boolean[1010][1010];
    //private static Vector<Vector<Cell>> vals = new Vector<Vector<Cell>>(1000010);
    private static Cell[][] vals = new Cell[1000010][1000010];

    public static String is_possible(Cell last_cell){
        Queue<Cell> q = new LinkedList<Cell>();
        q.add(last_cell);
        while (!q.isEmpty()) {
            Cell cell = q.peek();
            q.remove();
            Cell[] neighbors = vals[cell.r * cell.c];
            for (Cell neighbor: neighbors) {
                if (neighbor.r == 1 && neighbor.c == 1) {
                    return "yes";
                } else if (!searched[neighbor.r][neighbor.c]) {
                    searched[neighbor.r][neighbor.c] = true;
                    q.add(neighbor);
                }
            }
        }
        return "no";
    }

    public static void main(String[] args) {
        int rows = s.nextInt();
        int cols = s.nextInt();
        Cell last_Cell;
        
        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                int val = s.nextInt(); //get the value of the cell
                Cell cell = new Cell();
                cell.r = i; cell.c = j;
                vals[cell.r * cell.c][val] = cell;

                if (i == rows && j == cols) last_Cell = cell;
            }
        }
        
        System.out.println(is_possible(last_Cell));
    }
}