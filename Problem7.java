import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

class Node {
    public int data;
    public Node nextChildren[];

    Node(int children, int data) {
        nextChildren = new Node[children];
        for (Node node : nextChildren) {
            node = null;
        }
        this.data = data;
    }

    setNextNodeChild(Node node) {
        for(int i = 0; i < nextChildren.length; i++){
            if (nextChildren[i] == null){
                this.nextChildren[i] = node;
                break;
            }
        }
    }

    Node getNextNode(Node node, int i) {
        return this.nextChildren[i];
    }
}

public class Problem7 {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int y = s.nextInt();
        int x = s.nextInt();
        int[][] room = new int[x][y];
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                room[i][j] = s.nextInt();
            }
        }
        
        //find how many spots you can go to from first spot
        ArrayList<Integer> xValues = new ArrayList<Integer>();
        for (int i = 1; i <= room[0][0]; i++){
            if (room[0][0] % i == 0)
                if (i <= x && (room[0][0] / i) <= y) xValues.add(i);
        }

        boolean escaped = false;
        Node root = new Node(2, room[0][0]);

        for (Integer integer : xValues) {
            root.setNextNodeChild(new Node(/*HOW MANY CHILDREN MAKE MERHOD*/ */, room[integer][room[0][0] / integer]));
        }

        while(!escaped){
            for (Node child : root.nextChildren) {

            }
        }
    }
}