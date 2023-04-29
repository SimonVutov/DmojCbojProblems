import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC01S4Cookies {
    public static Scanner s = new Scanner(System.in);
    public static double d(double x, double y, double x1, double y1)
    {
        return Math.sqrt( (Math.pow(x - x1, 2) + Math.pow(y - y1, 2)) );
    }
    
    public static double[] findCircleCenter(double x1, double y1, double x2, double y2, double x3, double y3) {
        double a = x2 - x1;
        double b = y2 - y1;
        double c = x3 - x1;
        double d = y3 - y1;
        
        double e = a * (x1 + x2) + b * (y1 + y2);
        double f = c * (x1 + x3) + d * (y1 + y3);
        
        double g = 2 * (a * (y3 - y2) - b * (x3 - x2));
        
        if (g == 0) {
            // Points are collinear
            return null;
        }
        
        double centerX = (d * e - b * f) / g;
        double centerY = (a * f - c * e) / g;
        
        return new double[] {centerX, centerY};
    }

    public static void main(String[] args)
    {
        int n = s.nextInt();
        int[][] l = new int[n][2];
        for (int i = 0; i < n; i++) {
            l[i][0] = s.nextInt();
            l[i][1] = s.nextInt();
        }
        double min = 1000000000;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    double[] c = findCircleCenter(l[i][0], l[i][1], l[j][0], l[j][1], l[k][0], l[k][1]);
                    if (c != null) {
                        double r = d((double)l[i][0], (double)l[i][1], (double)c[0], (double)c[1]);
                        boolean valid = true;
                        innerloop1:
                        for (int m = 0; m < n; m++) {
                            if ((double)d(l[m][0], (double)l[m][1], (double)c[0], (double)c[1]) > r) {
                                valid = false;
                                break innerloop1;
                            }
                        }
                        if (valid) {
                            min = Math.min(min, r*2);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double r = d((double)l[i][0], (double)l[i][1], (double)l[j][0], (double)l[j][1]) / 2;
                double[] c = new double[2];
                c[0] = (double)(l[i][0] + l[j][0]) / 2;
                c[1] = (double)(l[i][1] + l[j][1]) / 2;
                boolean valid = true;
                innerloop:
                for (int m = 0; m < n; m++) {
                    if ((double)d(l[m][0], (double)l[m][1], (double)c[0], (double)c[1]) > r) {
                        valid = false;
                        break innerloop;
                    }
                }
                if (valid) {
                    min = Math.min(min, r*2);
                }

            }
        }

        System.out.println(String.format("%.2f", min));
    }
}