import java.util.*;
import java.io.*;
import java.util.Scanner;

public class CCC18S3RoboThieves {
    public static Scanner s = new Scanner(System.in);

    public static boolean check (int H, int W, char[][] grid, int[][] dir) {
        for (int i = 0; i < 4; i++) {
            int currentH = H;
            int currentW = W;
            do {
                currentH += dir[i][0];
                currentW += dir[i][1];
            } while (grid[currentH][currentW] != 'C' && grid[currentH][currentW] != 'W');
            if (grid[currentH][currentW] == 'C') return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int h = s.nextInt();
        int w = s.nextInt();

        char[][] grid = new char[h][w];
        int [][] distance = new int[h][w];

        for (int i = 0; i < h; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        Integer[] start = new Integer[2];

        for (int i = 0; i < h; i++) {
            String line = s.next();
            for (int j = 0; j < w; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'S') {
                    distance[i][j] = 0;
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<Integer[]> q = new LinkedList<>();
        q.add(start);
        boolean[][] visited = new boolean[h][w];

        boolean cancel = (check(start[0], start[1], grid, d));

        while (!q.isEmpty() && cancel) {
            Integer[] current = q.poll();
            if (visited[current[0]][current[1]]) continue;
            visited[current[0]][current[1]] = true;

            if (grid[current[0]][current[1]] == 'W' || grid[current[0]][current[1]] == 'C') continue;

            for (int i = 0; i < 4; i++) {
                int newH = current[0] + d[i][0];
                int newW = current[1] + d[i][1];
                char s = grid[newH][newW];
                if (newH >= 0 && newH < h && newW >= 0 && newW < w) {
                    if (!(s == 'W' || s == 'C')) {
                        if (s == '.' || s == 'S') {
                            if (check(newH, newW, grid, d)) {
                                distance[newH][newW] = Math.min(distance[current[0]][current[1]] + 1, distance[newH][newW]);
                                Integer[] a = {newH, newW};
                                if (grid[newH][newW] != 'W' && grid[newH][newW] != 'C') q.add(a);
                            } else {
                                distance[newH][newW] = -1;
                            }
                        } else if (s == 'U' || s == 'D' || s == 'L' || s == 'R') {
                            Integer[] a = {newH, newW};
                            
                            int iterations = 0;
                            while (grid[a[0]][a[1]] == 'U' || grid[a[0]][a[1]] == 'D' || grid[a[0]][a[1]] == 'L' || grid[a[0]][a[1]] == 'R') {
                                if (iterations > 100) break;
                                iterations++;

                                if (grid[a[0]][a[1]] == 'U' && grid[a[0] - 1][a[1]] != 'W' && grid[a[0] - 1][a[1]] != 'C' && grid[a[0] - 1][a[1]] != 'D') {
                                    a[0] = a[0] - 1;
                                    a[1] = a[1];
                                    distance[a[0]][a[1]] = Math.min(distance[current[0]][current[1]] + 1, distance[a[0]][a[1]]);

                                } else if (grid[a[0]][a[1]] == 'D' && grid[a[0] + 1][a[1]] != 'W' && grid[a[0] + 1][a[1]] != 'C' && grid[a[0] + 1][a[1]] != 'U') {
                                    a[0] = a[0] + 1;
                                    a[1] = a[1];
                                    distance[a[0]][a[1]] = Math.min(distance[current[0]][current[1]] + 1, distance[a[0]][a[1]]);

                                } else if (grid[a[0]][a[1]] == 'L' && grid[a[0]][a[1] - 1] != 'W' && grid[a[0] - 1][a[1]] != 'C' && grid[a[0]][a[1] - 1] != 'R') {
                                    a[0] = a[0];
                                    a[1] = a[1] - 1;
                                    distance[a[0]][a[1]] = Math.min(distance[current[0]][current[1]] + 1, distance[a[0]][a[1]]);

                                } else if (grid[a[0]][a[1]] == 'R' && grid[a[0]][a[1] + 1] != 'W' && grid[a[0] + 1][a[1]] != 'C' && grid[a[0]][a[1] + 1] != 'L') {
                                    a[0] = a[0];
                                    a[1] = a[1] + 1;
                                    distance[a[0]][a[1]] = Math.min(distance[current[0]][current[1]] + 1, distance[a[0]][a[1]]);

                                }
                            }

                            if (check(a[0], a[1], grid, d)){
                                distance[a[0]][a[1]] = Math.min(distance[a[0]][a[1]], distance[current[0]][current[1]] + 1);
                                q.add(a);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '.') {
                    if (distance[i][j] == Integer.MAX_VALUE) System.out.println(-1);
                    else System.out.println(distance[i][j]);
                }
            }
        }
    }
}