import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class Problem2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int cities = s.nextInt();
        int distance = s.nextInt();

        int[][] city = new int[cities][3];
        for (int i = 0; i < cities; i++) {
            city[i][0] = s.nextInt();
            city[i][1] = s.nextInt();
            city[i][2] = s.nextInt();
        }

        for (int h = 0; h < cities; h++){ //for each city
            int reachableCities = reachableCities(city, distance, city[h][0], city[h][1]);
        }
    }

    public static int reachableCities(int[][] city, double distance, double x, double y){
        int reachableCities = 0;
        for (int j = 0; j < city.length; j++){
            if ( Math.sqrt(Math.pow((x) - (city[j][0]), 2) + Math.pow((y) - (city[j][1]), 2)) <= (distance)) reachableCities++;
        }
        return reachableCities;
    }
}