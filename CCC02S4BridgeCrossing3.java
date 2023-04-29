import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;

public class CCC02S4BridgeCrossing3 {
    public static int send (int[] time, String[] people, int maxPeople, int peopleSent, int timeSoFar, boolean sendNumber) {
        if (time.length - peopleSent <= maxPeople) {
            int Slowest = Integer.MIN_VALUE;
            for (int i = peopleSent; i < time.length; i++) {
                if (time[i] > Slowest) Slowest = time[i];
            }
            if (sendNumber) return time.length - peopleSent;
            else return timeSoFar + Slowest;
        }

        int minTime = Integer.MAX_VALUE;
        int Slowest = Integer.MIN_VALUE;
        int bestAmountOfPeople = 0;

        for (int i = peopleSent; i < peopleSent + maxPeople; i++) {
            for (int j = peopleSent; j <= i; j++) {
                if (time[j] > Slowest) Slowest = time[j];
            }
            int t = send(time, people, maxPeople, i + 1, timeSoFar + Slowest, false);
            if (t < minTime) { minTime = t; bestAmountOfPeople = i - peopleSent + 1; }
        }
        if (sendNumber) return bestAmountOfPeople;
        else return minTime;
    }

    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int maxPeople = s.nextInt();
        int people = s.nextInt();

        int[] time = new int[people];
        String[] name = new String[people];

        for (int i = 0; i < people; i++) {
            name[i] = s.next();
            time[i] = s.nextInt();
        }

        System.out.println("Total Time: " + send(time, name, maxPeople, 0, 0, false));
        int peopleSent = 0;
        while (peopleSent < people) {
            int amountOfPeople = send(time, name, maxPeople, peopleSent, 0, true);
            for (int i = peopleSent; i < peopleSent + amountOfPeople; i++) {
                System.out.print(name[i] + " ");
            }
            System.out.println();
            peopleSent += amountOfPeople;
        }
    }
}