import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC11S3AliceThroughtheLookingGlass {
    public static Scanner s = new Scanner(System.in);

    public static boolean check (double decimalx, double decimaly, int z, int s) {
        int coordx = (int)(decimalx * Math.pow(5, s - z) * 5 + 0.00001);
        int coordy = (int)(decimaly * Math.pow(5, s - z) * 5 + 0.00001);
        if (z == 1 || z < 1) {
            if (coordx == 1 && coordy == 0) return true;
            else if (coordx == 2 && coordy == 0) return true;
            else if (coordx == 3 && coordy == 0) return true;
            else if (coordx == 2 && coordy == 1) return true;
            else return false;
        } else {
            if (coordx == 1 && coordy == 0) return true;
            else if (coordx == 2 && coordy == 0) return true;
            else if (coordx == 3 && coordy == 0) return true;
            else if (coordx == 2 && coordy == 1) return true;
            else if (coordx == 0 && coordy == 0) return false;
            else if (coordx == 0 && coordy == 1) return false;
            else if (coordx == 0 && coordy == 2) return false;
            else if (coordx == 0 && coordy == 3) return false;
            else if (coordx == 0 && coordy == 4) return false;
            else if (coordx == 1 && coordy == 2) return false;
            else if (coordx == 1 && coordy == 3) return false;
            else if (coordx == 1 && coordy == 4) return false;
            else if (coordx == 2 && coordy == 3) return false;
            else if (coordx == 2 && coordy == 4) return false;
            else if (coordx == 3 && coordy == 3) return false;
            else if (coordx == 3 && coordy == 4) return false;
            else if (coordx == 4 && coordy == 0) return false;
            else if (coordx == 4 && coordy == 1) return false;
            else if (coordx == 4 && coordy == 2) return false;
            else if (coordx == 4 && coordy == 3) return false;
            else if (coordx == 4 && coordy == 4) return false;
        }
        return check(decimalx % 0.2, decimaly % 0.2, z - 1, s);
    }
    public static void main(String[] args)
    {
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int z = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();

            double decimalX = (double)x / (double)Math.pow(5, z);
            double decimalY = (double)y / (double)Math.pow(5, z);

            if (check(decimalX, decimalY, z, z)) System.out.println("crystal");
            else System.out.println("empty");
        }
    }
}