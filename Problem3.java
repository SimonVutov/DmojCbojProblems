import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

// Java implementation of the approach
class Problem3 {

    public static Scanner s = new Scanner(System.in);
 
    // Class for the node of the tree
    static class Node {
        int data;
 
        // List of children
        Node children[];
 
        Node(int n, int data)
        {
            children = new Node[n];
            this.data = data;
        }
    }
 
    // Function to print the inorder traversal
    // of the n-ary tree
    static void inorder(Node node)
    {
        if (node == null)
            return;
 
        // Total children count
        int total = node.children.length;
        // All the children except the last
        for (int i = 0; i < total - 1; i++)
            inorder(node.children[i]);
 
        // Print the current node's data
        System.out.print("" + node.data + " ");
 
        // Last child
        inorder(node.children[total - 1]);
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int cities = s.nextInt();
        int distance = s.nextInt();

        int[][] city = new int[cities][3];
        for (int i = 0; i < cities; i++) {
            city[i][0] = s.nextInt();
            city[i][1] = s.nextInt();
            city[i][2] = s.nextInt();
        }

        int n = cities;
        Node root = new Node(n, 0);

        for (int h = 0; h < cities; h++){ //for each city
            int reachableCities = reachableCities(city, distance, city[h][0], city[h][1]);
        }
 
        /* Create the following tree
                   1
                /  |  \
               2   3   4
             / | \
            5  6  7
        */
        /*int n = 3;
        Node root = new Node(n, 1);
        root.children[0] = new Node(n, 2);
        root.children[1] = new Node(n, 3);
        root.children[2] = new Node(n, 4);
        root.children[0].children[0] = new Node(n, 5);
        root.children[0].children[1] = new Node(n, 6);
        root.children[0].children[2] = new Node(n, 7);
 
        inorder(root); */
    }

    public static int reachableCities(int[][] city, double distance, double x, double y){
        int reachableCities = 0;
        for (int j = 0; j < city.length; j++){
            if ( Math.sqrt(Math.pow((x) - (city[j][0]), 2) + Math.pow((y) - (city[j][1]), 2)) <= (distance)) reachableCities++;
        }
        return reachableCities;
    }
}