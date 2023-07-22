import java.util.Scanner;
import java.io.*;
import java.util.*;

public class COCI08Contest62Bazen {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        double xValue = s.nextInt();
        double yValue = s.nextInt();

        double inputLoop = 0;
        double finalLoop = 0;

        if (xValue == 0) { //on vertical
            inputLoop = yValue;
        } else if (yValue == 0) { //on horizontal
            inputLoop = 853.553390593 - xValue;
        } else { //on diagonal
            inputLoop = 250.0 + Math.sqrt(Math.pow(250.0 - yValue, 2) + Math.pow(250.0 - xValue, 2));
        }

        finalLoop = 853.553390593 / 2 + inputLoop;
        if (finalLoop > 853.553390593) finalLoop -= 853.553390593;

        double area1 = 0;
        double area2 = 31250;
        double moveUnits = 100;

        while (Math.abs(area1 - area2) > 0.1 && moveUnits > 0.001) {
            System.out.println(" ||| " + finalLoop + " " + area1 + " " + area2 + " " + moveUnits);
            if (area1 < area2) finalLoop += moveUnits;
            else finalLoop -= moveUnits;

            if (finalLoop > 853.553390593) finalLoop -= 853.553390593;
            if (finalLoop < 0) finalLoop += 853.553390593;

            moveUnits /= 1.1;
            if (moveUnits < 0.001) {
                moveUnits = 0.001;
            }

            double xFinal = 0;
            double yFinal = 0;

            if (finalLoop < 250) {
                xFinal = 0;
                yFinal = finalLoop;
            } else if (finalLoop < 603.553390593) {
                xFinal = (finalLoop - 250) / Math.sqrt(2);
                yFinal = 250 - ( (finalLoop - 250) / Math.sqrt(2) );
            } else {
                xFinal = 853.553390593 - finalLoop;
                yFinal = 0;
            }

            if (xValue == 0 && yValue != 0 && xFinal != 0 && yFinal == 0) { //v to h
                area1 = yValue * xFinal / 2;
            } else if (xFinal == 0 && yFinal != 0 && xValue != 0 && yValue == 0) { //h to v
                area1 = xValue * yFinal / 2;
            } else if (xValue != 0 && yValue == 0 && xFinal != 0 && yFinal != 0) { //h to d
                area1 = (250 - xValue) * (yFinal) / 2;
            } else if (xFinal != 0 && yFinal == 0 && xValue != 0 && yValue != 0) { //d to h
                area1 = (250 - xFinal) * (yValue) / 2;
            } else if (yFinal != 0 && xFinal == 0 && yValue != 0 && xValue != 0) { //v to d
                area1 = (250 - yFinal) * (xValue) / 2;
            } else if (yValue != 0 && xValue == 0 && yFinal != 0 && xFinal != 0) { //d to v
                area1 = (250 - yValue) * (xFinal) / 2;
            }

            area2 = 31250 - area1;

            if (area1 > area2) {
                double temp = area1;
                area1 = area2;
                area2 = temp;
            }
            System.out.println(yFinal + " " + xFinal);
        }

        System.out.println(area1);
    }
}