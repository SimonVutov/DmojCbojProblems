import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC21S3LunchConcert {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        long[] location = new long[n];
        long[] walkSpeed = new long[n];
        long[] hearDistance = new long[n];
        for (int i = 0; i < n; i++) {
            location[i] = s.nextLong();
            walkSpeed[i] = s.nextLong();
            hearDistance[i] = s.nextLong();
        }

        long minWalkTime = Long.MAX_VALUE;
        long position = 500000000;
        long jumpDistance = 250000000;
        int counter = 0;

        while (counter < 1000) {
            counter++;
            long maxTimeRight = 0;
            long maxTimeLeft = 0;

            for (int i = 0; i < n; i++) {
                long thisTime = Math.max(0, Math.abs(location[i] - position) - hearDistance[i]) * walkSpeed[i];
                if (location[i] > position) maxTimeRight += thisTime;
                else if (location[i] < position) maxTimeLeft += thisTime;
            }

            if (maxTimeRight > maxTimeLeft) {
                position += jumpDistance;
                if (maxTimeRight + maxTimeLeft < minWalkTime) minWalkTime = maxTimeRight + maxTimeLeft;
            } else if (maxTimeRight < maxTimeLeft) {
                position -= jumpDistance;
                if (maxTimeLeft + maxTimeRight < minWalkTime) minWalkTime = maxTimeLeft + maxTimeRight;
            }

            jumpDistance /= 2;
            if (jumpDistance == 2) jumpDistance = 1;
            if (jumpDistance < 1) jumpDistance = 1;
        }

        if (n == 1) System.out.println(0);
        else System.out.println(minWalkTime);
    }
}