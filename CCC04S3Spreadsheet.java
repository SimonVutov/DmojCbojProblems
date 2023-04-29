import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CCC04S3Spreadsheet {
    public static Scanner s = new Scanner(System.in);
    public static class cell {
        public int value = -2; //-1 means undefined, -2 means not calculated
        public String formula = "";
        ArrayList<Integer> xVal = new ArrayList<Integer>(); //num
        ArrayList<Integer> yVal = new ArrayList<Integer>(); //letter
    }
    public static void main(String[] args)
    {
        cell[][] spreadsheet = new cell[10][9]; //y, x
        Dictionary<String, Integer> dict = new Hashtable<String, Integer>();
        dict.put("A", 0);
        dict.put("B", 1);
        dict.put("C", 2);
        dict.put("D", 3);
        dict.put("E", 4);
        dict.put("F", 5);
        dict.put("G", 6);
        dict.put("H", 7);
        dict.put("I", 8);
        dict.put("J", 9);

        for (int i = 0; i < 10; i++)
        {
            String line = s.nextLine();
            String[] split = line.split(" ");
            for (int j = 0; j < 9; j++)
            {
                spreadsheet[i][j] = new cell();
                spreadsheet[i][j].formula = split[j];
                if (split[j].toUpperCase() == split[j].toLowerCase()) {
                    spreadsheet[i][j].value = Integer.parseInt(split[j]);
                } else {
                    String[] split2 = split[j].split("\\+");
                    for (int k = 0; k < split2.length; k++)
                    {
                        spreadsheet[i][j].yVal.add(dict.get(split2[k].substring(0, 1)));
                        spreadsheet[i][j].xVal.add(Integer.parseInt(split2[k].substring(1, 2)) - 1);
                    }
                }
            }
        }

        int runs = 0;

        while (runs < 100) {
            runs++;

            for (int i = 0; i < 10; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    if (spreadsheet[i][j].value == -2) {
                        boolean setable = true;
                        boolean undefined = false;
                        int sum = 0;
                        innerloop:
                        for (int k = 0; k < spreadsheet[i][j].xVal.size(); k++) {
                            int c = spreadsheet[spreadsheet[i][j].yVal.get(k)][spreadsheet[i][j].xVal.get(k)].value;
                            if (c == -1) {
                                undefined = true;
                                break innerloop;
                            } else if (c == -2) {
                                setable = false;
                                break innerloop;
                            } else {
                                sum += c;
                            }
                        }
                        if (setable) {
                            spreadsheet[i][j].value = sum;
                        }
                        if (undefined) {
                            spreadsheet[i][j].value = -1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (spreadsheet[i][j].value == -1 || spreadsheet[i][j].value == -2) {
                    System.out.print("* ");
                } else {
                    System.out.print(spreadsheet[i][j].value + " ");
                }
            }
            System.out.println();
        }
    }
}