import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CBOJExecSelectionContest2Problem5ObligatoryDataStructureProblem {
    public static Scanner s = new Scanner(System.in);

    public static class node {
        public int leftRange = 0;
        public int rightRange = 0;
        public int sum = 0;
        public node left;
        public node right;
    }

    public static void main(String[] args) {
        int nodes = s.nextInt();
        int querries = s.nextInt();
        int[] arr = new int[nodes];
        for (int i = 0; i < nodes; i++) arr[i] = s.nextInt();

        node root = new node();
        root.leftRange = 0;
        root.rightRange = nodes - 1;
        root.sum = 0;
        for (int i = 0; i < nodes; i++) root.sum += arr[i];
        buildTree(root, arr);

        for (int i = 0; i < querries; i++) {
            int n = s.nextInt();
            if (n == 1) {
                int index = s.nextInt() - 1;
                int value = s.nextInt();
                update(root, index, value);
            } else {
                int from = s.nextInt() - 1;
                int to = s.nextInt() - 1;
                System.out.println(sum(root, from, to));
            }
        }
    }

    public static void buildTree(node root, int[] arr) {
        if (root.leftRange == root.rightRange) return;
        int mid = (root.leftRange + root.rightRange) / 2;
        root.left = new node();
        root.left.leftRange = root.leftRange;
        root.left.rightRange = mid;
        root.right = new node();
        root.right.leftRange = mid + 1;
        root.right.rightRange = root.rightRange;
        buildTree(root.left, arr);
        buildTree(root.right, arr);
        root.sum = root.left.sum + root.right.sum;
    }
}