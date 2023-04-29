import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CCC11S5Switch {
    public static Scanner s = new Scanner(System.in);
    public static boolean allOnOff(int[] switches)
    {
        boolean allOn = true;
        boolean allOff = true;
        for (int i = 0; i < switches.length; i++)
        {
            if (switches[i] == 1)
            {
                allOff = false;
            }
            else
            {
                allOn = false;
            }
        }
        return allOn || allOff;
    }

    public static int[] reset(int[] switches)
    {
        int onConsecutive = 0;
        for (int i = 0; i < switches.length; i++) {
            if (switches[i] == 1) {
                onConsecutive++;
            }
            else {
                if (onConsecutive >= 4) {
                    for (int j = i - onConsecutive; j < i; j++) {
                        switches[j] = 0;
                    }
                }
                onConsecutive = 0;
            }
        }
        if (onConsecutive >= 4) {
            for (int j = switches.length - onConsecutive; j < switches.length; j++) {
                switches[j] = 0;
            }
        }
        return switches;
    }
    public static void main(String[] args)
    {
        int n = s.nextInt();

        int[] switches = new int[n];

        for (int i = 0; i < n; i++)
        {
            switches[i] = s.nextInt();
        }

        int count = 0;

        while (!allOnOff(switches)) {
            count++;
            int highestImpact = 0;
            int highestImpactIndex = 0;
            int highestNormalImpact = 0;
            boolean set = false;

            for (int i = 0; i < n; i++)
            {
                if (switches[i] == 0)
                {
                    int impact = 0;
                    for (int j = Math.max(0, i - 3); j < Math.min(n, i + 3); j++)
                    {
                        if (switches[j] == 1) impact++;
                    }
                    int semtimpact = Math.max(0, 3 - i) + Math.max(0, 3 - (n - i - 1));
                    if (impact + semtimpact > highestImpact && impact > highestNormalImpact)
                    {
                        highestImpact = impact + semtimpact;
                        highestNormalImpact = impact;
                        highestImpactIndex = i;
                        set = true;
                    }
                }
            }

            if (set) switches[highestImpactIndex] = 1;

            switches = reset(switches);
        }

        System.out.println(count);
    }
}