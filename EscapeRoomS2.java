import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class EscapeRoomS2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        Cell[][] arr = new Cell[b][a];
        LargeList[] large = new LargeList[1000010];
        boolean[][] searched = new boolean[1010][1010];
        Queue<Cell> q = new LinkedList<>();

        for (int i = 0; i < a; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < b; j++) {
                int value = Integer.parseInt(str[j]);
                arr[j][i] = new Cell(value, j + 1, i + 1);
                if (large[value] == null) {
                    large[value] = new LargeList();
                }
                large[value].arrayOfList.add(arr[j][i]);
            }
        }
        q.add(arr[b - 1][a - 1]);

        while (!q.isEmpty()) {
            Cell c = q.poll();
            if (c.x == 1 && c.y == 1) {
                System.out.println("yes");
                return;
            }
            searched[c.x - 1][c.y - 1] = true;
            if (large[c.x * c.y] == null) {
                continue;
            }
            for (Cell cel : large[c.x * c.y].arrayOfList) {
                if (!searched[cel.x - 1][cel.y - 1] && cel.value == c.x * c.y) {
                    q.add(cel);
                }
            }
        }
        System.out.println("no");
    }

    public static class Cell {
        public int value;
        public int x;
        public int y;

        public Cell(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    public static class LargeList {
        public LinkedList<Cell> arrayOfList = new LinkedList<>();
    }
}
