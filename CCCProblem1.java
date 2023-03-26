import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int a = s.nextInt();
        int[] b1 = new int[a];
        int[] b2 = new int[a];
        for (int i = 0; i < a; i++) {
            b1[i] = s.nextInt();
        }
        for (int i = 0; i < a; i++) {
            b2[i] = s.nextInt();
        }

        if (a == 1) {
            if (b1[0] == 1 && b2[0] == 1) {
                System.out.println(4);
            } else if (b1[0] == 0 && b2[0] == 1) {
                System.out.println(3);
            } else if (b1[0] == 1 && b2[0] == 0) {
                System.out.println(3);
            } else {
                System.out.println(0);
            }
            return;
        }

        int counter = 0;

        for (int i = 1; i < a - 1; i++){
            if (b1[i] == 0) continue;
            if (i % 2 != 0) {
                int amountToAdd = 3;
                if (b1[i - 1] == 1) {
                    amountToAdd--;
                }
                if (b1[i + 1] == 1) {
                    amountToAdd--;
                }
                counter += amountToAdd;
               // System.out.println("i: " + i + " amountToAdd: " + amountToAdd);
            } else {
                int amountToAdd = 3;
                if (b1[i - 1] == 1) {
                    amountToAdd--;
                }
                if (b1[i + 1] == 1) {
                    amountToAdd--;
                }
                if (b2[i] == 1) {
                    amountToAdd--;
                }
                counter += amountToAdd;
                //System.out.println("i: " + i + " amountToAdd: " + amountToAdd);
            }
        }

        for (int i = 1; i < a - 1; i++){
            if (b2[i] == 0) continue;
            if (i % 2 != 0) {
                int amountToAdd = 3;
                if (b2[i - 1] == 1) {
                    amountToAdd--;
                }
                if (b2[i + 1] == 1) {
                    amountToAdd--;
                }
                counter += amountToAdd;
                //System.out.println("i: " + i + " amountToAdd: " + amountToAdd);
            } else {
                int amountToAdd = 3;
                if (b2[i - 1] == 1) {
                    amountToAdd--;
                }
                if (b2[i + 1] == 1) {
                    amountToAdd--;
                }
                if (b1[i] == 1) {
                    amountToAdd--;
                }
                counter += amountToAdd;
                //System.out.println("i: " + i + " amountToAdd: " + amountToAdd);
            }
        }

        if (b1[0] == 1) {
            int amountToAdd = 3;
            if (b1[1] == 1) {
                amountToAdd--;
            }
            if (b2[0] == 1) {
                amountToAdd--;
            }
            counter += amountToAdd;
            //System.out.println("i: amountToAdd: " + amountToAdd);
        }

        if (b2[0] == 1) {
            int amountToAdd = 3;
            if (b2[1] == 1) {
                amountToAdd--;
            }
            if (b1[0] == 1) {
                amountToAdd--;
            }
            counter += amountToAdd;
            //System.out.println("i: amountToAdd: " + amountToAdd);
        }

        if (b1[a - 1] == 1 && a % 2 != 0) {
            int amountToAdd = 3;
            if (b1[a - 2] == 1) {
                amountToAdd--;
            }
            if (b2[a - 1] == 1) {
                amountToAdd--;
            }
            counter += amountToAdd;
            //System.out.println("i: amountToAdd: " + amountToAdd);
        }

        if (b2[a - 1] == 1 && a % 2 != 0) {
            int amountToAdd = 3;
            if (b2[a - 2] == 1) {
                amountToAdd--;
            }
            if (b1[a - 1] == 1) {
                amountToAdd--;
            }
            counter += amountToAdd;
            //System.out.println("i: amountToAdd: " + amountToAdd);
        }

        if (b1[a - 1] == 1 && a % 2 == 0) {
            int amountToAdd = 3;
            if (b1[a - 2] == 1) {
                amountToAdd--;
            }
            counter += amountToAdd;
            //System.out.println("i: amountToAdd: " + amountToAdd);
        }

        if (b2[a - 1] == 1 && a % 2 == 0) {
            int amountToAdd = 3;
            if (b2[a - 2] == 1) {
                amountToAdd--;
            }
            counter += amountToAdd;
            //System.out.println("i: amountToAdd: " + amountToAdd);
        }

        System.out.println(counter);
    }
}