import java.util.Scanner;
import java.io.*;
import java.util.*;

public class NetworkingProblem1 {
    public static Scanner s = new Scanner(System.in);
    public static double d (int x1, int y1, int x2, int y2)
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    public static class Node
    {
        public int id;
        public int x;
        public int y;
        ArrayList<Integer> edges = new ArrayList<Integer>();
    }
    public static void main(String[] args)
    {
        int a = s.nextInt();
        if (a == 1)
        {
            int x = s.nextInt();
            int y = s.nextInt();
            System.out.println(0);
            return;
        } else if (a == 2)
        {
            int x1 = s.nextInt();
            int y1 = s.nextInt();
            int x2 = s.nextInt();
            int y2 = s.nextInt();
            System.out.println(d(x1, y1, x2, y2) / 2);
            return;
        }
        Node[] z = new Node[a];
        for(int i = 0; i < a; i++)
        {
            z[i] = new Node();
            z[i].id = i;
            z[i].x = s.nextInt();
            z[i].y = s.nextInt();
        }

        for(int i = 0; i < a; i++)
        {
            double minDistance = Double.POSITIVE_INFINITY;
            int minIndex = 0;
            for(int j = 0; j < a; j++)
            {
                if (i != j)
                {
                    double distance = d(z[i].x, z[i].y, z[j].x, z[j].y);
                    if (distance < minDistance)
                    {
                        minDistance = distance;
                        minIndex = j;
                    }
                }
            }
            z[i].edges.add(minIndex);
        }

        int[] connectedNodes = new int[a];
        for (int i = 0; i < a; i++) connectedNodes[i] = -1;
        int[] notConnectedNodes = new int[a];
        for (int i = 0; i < a; i++) notConnectedNodes[i] = i;

        double maxDistance = 0;

        // start node is 0
        int startNode = 0;
        // get an array of all connected nodes and all not connected notes
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(startNode);
        connectedNodes[startNode] = startNode;
        notConnectedNodes[startNode] = -1;
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int n : z[c].edges) {
                if (connectedNodes[n] == -1) {
                    connectedNodes[n] = n;
                    notConnectedNodes[n] = -1;
                    q.add(n);
                }
            }
        }

        while (true) {
            //loop through every connected node, and find the node with the shortest distance to a not connected node
            //System.out.println("loop" + Arrays.toString(connectedNodes) + Arrays.toString(notConnectedNodes));
            double minDistance = Double.POSITIVE_INFINITY;
            int minIndexStart = 0;
            int minIndexEnd = 0;

            for (int i = 0; i < a; i++) {
                if (connectedNodes[i] != -1) {
                    for (int j = 0; j < a; j++) {
                        if (notConnectedNodes[j] != -1) {
                            double distance = d(z[i].x, z[i].y, z[j].x, z[j].y);
                            if (distance < minDistance) {
                                minDistance = distance;
                                minIndexStart = i;
                                minIndexEnd = j;
                            }
                        }
                    }
                }
            }
            //System.out.println("minDistance: " + minDistance + " minIndexStart: " + minIndexStart + " minIndexEnd: " + minIndexEnd);
            //if the shortest distance is greater than the max distance, set the max distance to the shortest distance
            maxDistance = Math.max(maxDistance, minDistance);
            //add the nearest node
            connectedNodes[minIndexEnd] = minIndexEnd;
            notConnectedNodes[minIndexEnd] = -1;
            z[minIndexStart].edges.add(minIndexEnd);
            z[minIndexEnd].edges.add(minIndexStart);

            //create a link to it between the smallest distance
            boolean good = true;
            for (int c : connectedNodes) {
                if (c == -1) {
                    good = false;
                }
            }
            if (good) {
                break;
            }
        }

        System.out.println(maxDistance / 2);
    }
}