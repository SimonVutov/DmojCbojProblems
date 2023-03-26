import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC02S4BridgeCrossing {
    public static Scanner s = new Scanner(System.in);
    public static class person {
        String name;
        int speed;
    }
    public static int cross (int a, person[] p) {
        if (p.length == 1) return p[0].speed;
        int minTime = 0;
        for (int i = 0; i < a; i++) {
            int timeForThesePeople = 0;
            for (int j = 0; j < i; j++) { timeForThesePeople += p[j].speed;
            minTime = Math.min(timeForThesePeople + cross(a, p), minTime);
        }
        return 0;
    }
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        person[] people = new person[b];
        for (int i = 0; i < b; i++) {
            people[i].name = s.nextLine();
            people[i].speed = s.nextInt();
        }
        System.out.println(cross(a, people));
    }
}