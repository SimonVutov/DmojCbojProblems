import java.util.Scanner;
import java.io.*;
import java.util.*;

public class DMOPC22Contest5P5TwosandThrees {
    public static Scanner s = new Scanner(System.in);
    public static boolean done = false;

    public static char[] around (int[][] locations, char[][] arr) {
        char[] around = new char[12];
        int adding = 0;
        for (int i = 0; i < locations.length; i++) {
            int row = locations[i][0];
            int col = locations[i][1];
            if (row - 1 >= 0) {
                around[adding + 0] = arr[row - 1][col];
            }
            if (row + 1 < arr.length) {
                around[adding + 1] = arr[row + 1][col];
            }
            if (col - 1 >= 0) {
                around[adding + 2] = arr[row][col - 1];
            }
            if (col + 1 < arr[row].length) {
                around[adding + 3] = arr[row][col + 1];
            }
            adding += 4;
        }
        return around;
    }

    public static char[][] insertOne (char[][] arr, int row, int col, int depth) {
        System.out.println(depth + " " + done);
        if (done) return arr;
        boolean insertion = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '#') {
                    
                    insertion = true;

                    if (i < row - 1) { //2 down
                        if (arr[i + 1][j] == '#') {
                            char letterChosen = 'A';
                            int[][] locations = {{i, j}, {i+1, j}};
                            for (int k = 0; k < 12; k++) {
                                if (around(locations, arr)[k] == letterChosen) {
                                    if (letterChosen == 'Z') letterChosen = 'A';
                                    else letterChosen++;
                                    k = 0;
                                    
                                }
                            }
                            arr[i][j] = letterChosen;
                            arr[i + 1][j] = letterChosen;
                            insertOne(arr, row, col, depth + 1);
                            arr[i][j] = '#';
                            arr[i + 1][j] = '#';
                        }
                    }

                    if (j < col - 1) { //2 right
                        if (arr[i][j + 1] == '#') {
                            char letterChosen = 'A';
                            int[][] locations = {{i, j}, {i, j + 1}};
                            for (int k = 0; k < 12; k++) {
                                if (around(locations, arr)[k] == letterChosen) {
                                    if (letterChosen == 'Z')  letterChosen = 'B';
                                    else letterChosen++;
                                    k = 0;
                                    
                                }
                            }
                            arr[i][j] = letterChosen;
                            arr[i][j + 1] = letterChosen;
                            insertOne(arr, row, col, depth + 1);
                            arr[i][j] = '#';
                            arr[i][j + 1] = '#';
                        }
                    }

                    if (i < row - 1 && j < col - 1) { //2 down, then 1 right
                        if (arr[i + 1][j] == '#' && arr[i + 1][j + 1] == '#') {
                            char letterChosen = 'A';
                            int[][] locations = {{i, j}, {i + 1, j}, {i + 1, j + 1}};
                            for (int k = 0; k < 12; k++) {
                                if (around(locations, arr)[k] == letterChosen) {
                                    if (letterChosen == 'Z')  letterChosen = 'B';
                                    else letterChosen++;
                                    k = 0;
                                    
                                }
                            }
                            arr[i][j] = letterChosen;
                            arr[i + 1][j] = letterChosen;
                            arr[i + 1][j + 1] = letterChosen;
                            insertOne(arr, row, col, depth + 1);
                            arr[i][j] = '#';
                            arr[i + 1][j] = '#';
                            arr[i + 1][j + 1] = '#';
                        }
                    }

                    if (i < row - 1 && j < col - 1) { //2 right, then 1 down
                        if (arr[i][j + 1] == '#' && arr[i + 1][j + 1] == '#') {
                            char letterChosen = 'A';
                            int[][] locations = {{i, j}, {i, j + 1}, {i + 1, j + 1}};
                            for (int k = 0; k < 12; k++) {
                                if (around(locations, arr)[k] == letterChosen) {
                                    if (letterChosen == 'Z')  letterChosen = 'B';
                                    else letterChosen++;
                                    k = 0;
                                    
                                }
                            }
                            arr[i][j] = letterChosen;
                            arr[i][j + 1] = letterChosen;
                            arr[i + 1][j + 1] = letterChosen;
                            insertOne(arr, row, col, depth + 1);
                            arr[i][j] = '#';
                            arr[i][j + 1] = '#';
                            arr[i + 1][j + 1] = '#';
                        }
                    }

                    if (i < row - 2) { //3 down
                        if (arr[i + 1][j] == '#' && arr[i + 2][j] == '#') {
                            char letterChosen = 'A';
                            int[][] locations = {{i, j}, {i + 1, j}, {i + 2, j}};
                            for (int k = 0; k < 12; k++) {
                                if (around(locations, arr)[k] == letterChosen) {
                                    if (letterChosen == 'Z')  letterChosen = 'B';
                                    else letterChosen++;
                                    k = 0;
                                    
                                }
                            }
                            arr[i][j] = letterChosen;
                            arr[i + 1][j] = letterChosen;
                            arr[i + 2][j] = letterChosen;
                            insertOne(arr, row, col, depth + 1);
                            arr[i][j] = '#';
                            arr[i + 1][j] = '#';
                            arr[i + 2][j] = '#';
                        }
                    }

                    if (j < col - 2) { //3 right
                        if (arr[i][j + 1] == '#' && arr[i][j + 2] == '#') {
                            char letterChosen = 'A';
                            int[][] locations = {{i, j}, {i, j + 1}, {i, j + 2}};
                            for (int k = 0; k < 12; k++) {
                                if (around(locations, arr)[k] == letterChosen) {
                                    if (letterChosen == 'Z')  letterChosen = 'B';
                                    else letterChosen++;
                                    k = 0;
                                    
                                }
                            }
                            arr[i][j] = letterChosen;
                            arr[i][j + 1] = letterChosen;
                            arr[i][j + 2] = letterChosen;
                            insertOne(arr, row, col, depth + 1);
                            arr[i][j] = '#';
                            arr[i][j + 1] = '#';
                            arr[i][j + 2] = '#';
                        }
                    }

                }
            }
        }

        if (!insertion) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
            done = true;
        }

        return arr;
    }
    public static void main(String[] args) {
        int rows = s.nextInt();
        int cols = s.nextInt();

        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = s.next();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        insertOne(grid, rows, cols, 0);

        if (!done) System.out.println("IMPOSSIBLE");
    }
}