import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CCC04J5Fractals {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int magnification = s.nextInt();
        int width = s.nextInt();
        width = (int)Math.round(Math.cbrt(width));
        int xCoordinate = s.nextInt();
        int[][] map = new int[3][3];
        map[1][0] = 1;
        int currentWidth = 3;
        for (int i = 0; i < width - 1; i++) {
            int[][] ogMap = map;
            currentWidth *= 3;
            map = new int[currentWidth][currentWidth];

            for (int j = 0; j < currentWidth; j++) { //x
                for (int k = 0; k < currentWidth; k++) { //y
                    int xGeneral = j/3;
                    int yGeneral = k/3;
                    if (ogMap[xGeneral][yGeneral] == 1) map[j][k] = 1;

                    if (0 < magnification - i - 1) {
                        //right
                        if (xGeneral + 1 < ogMap.length - 1) if (ogMap[xGeneral][yGeneral] == 0 && ogMap[xGeneral + 1][yGeneral] == 1 && j % 3 == 2 && k % 3 == 1) map[j][k] = 1;
                        //left
                        if (xGeneral - 1 >= 0) if (ogMap[xGeneral][yGeneral] == 0 && ogMap[xGeneral - 1][yGeneral] == 1 && j % 3 == 0 && k % 3 == 1) map[j][k] = 1;
                        //up
                        if (yGeneral - 1 >= 0) if (ogMap[xGeneral][yGeneral] == 0 && ogMap[xGeneral][yGeneral - 1] == 1 && j % 3 == 1 && k % 3 == 0) map[j][k] = 1;
                        if (ogMap[xGeneral][yGeneral] == 0 && yGeneral == 0 && j % 3 == 1 && k % 3 == 0) map[j][k] = 1;
                        //down
                        if (yGeneral + 1 < ogMap.length - 1) if (ogMap[xGeneral][yGeneral] == 0 && ogMap[xGeneral][yGeneral + 1] == 1 && j % 3 == 1 && k % 3 == 2) map[j][k] = 1;
                    }
                }
            }
        }

        ArrayList<Integer> yCoordinates = new ArrayList<Integer>();
        ArrayList<Integer> printed = new ArrayList<Integer>();

        for (int i = 0; i < currentWidth - 1; i++) {
            if (map[xCoordinate - 1][i] != map[xCoordinate][i]) {
                yCoordinates.add(i + 1);
                yCoordinates.add(i + 2);
            }
            if (i == 0) if (map[xCoordinate - 1][i] == 0 || map[xCoordinate][i] == 0) yCoordinates.add(i + 1);

            if (map[xCoordinate - 1][i] != map[xCoordinate - 1][i + 1] || map[xCoordinate][i] != map[xCoordinate][i + 1]) {
                yCoordinates.add(i + 2);
            }
        }

        for (int i = 0; i < yCoordinates.size(); i ++) {
            if (printed.contains(yCoordinates.get(i))) continue;
            printed.add(yCoordinates.get(i));
            System.out.println(yCoordinates.get(i));
        }
    }
}