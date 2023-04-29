import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC00S2BabblingBrooks {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = s.nextInt();
        ArrayList<Double> arr = new ArrayList<Double>();
        for(int i = 0; i < n; i++) arr.add((double)s.nextInt());

        do {
            n = s.nextInt();
            if (n == 99) {
                int location = s.nextInt();
                int ratio = s.nextInt();
                double startAmount = arr.get(location - 1);
                arr.set(location - 1, arr.get(location - 1) * ratio / 100);
                arr.add(location, startAmount - arr.get(location - 1));
            } else if (n == 88) {
                int location = s.nextInt();
                arr.set(location - 1, arr.get(location - 1) + arr.get(location));
                arr.remove(location);
            }
        } while (n != 77);

        for (int i = 0; i < arr.size(); i++) {
            System.out.print((int)Math.round(arr.get(i)) + " ");
        } System.out.println();
    }
}