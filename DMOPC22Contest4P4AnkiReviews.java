import java.util.Scanner;
import java.io.*;
import java.util.*;

public class DMOPC22Contest4P4AnkiReviews {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int N = s.nextInt();
        int D = s.nextInt();
        int[] reviews = new int[N];
        for (int i = 0; i < N; i++) {
            reviews[i] = s.nextInt();
        }

        int currentStreak = 0;
        int maxStreak = 0;
        int lastDayTime = reviews[0];
        for (int dayOffset = 0; dayOffset < D; dayOffset++) {
            for (int i = 0; i < N; i++) {
                if (reviews[i] - lastDayTime >= D && reviews[i] - lastDayTime <= dayOffset + D) {
                    currentStreak++;
                    lastDayTime = reviews[i];
                } else if (reviews[i] - lastDayTime > dayOffset + D) {
                    maxStreak = Math.max(maxStreak, currentStreak);
                    currentStreak = 0;
                }
            }
        }

        System.out.println(maxStreak + 1);
    }
}