import java.io.*;
import java.util.*;
import java.lang.Math;

public class RichardThePenguin3 {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt(); int k = s.nextInt();
        int nodes = (int)Math.pow(2*n, k);
        int nodename = 0, nodepointer = 1;
        int[][] arr = new int[nodes][k + 1];
        for(int i = 0; i < nodes; i++){
            for(int j = 0; j < k + 1; j++){
                if (j == 0) { arr[i][j] = nodename; nodename++; }
                else { arr[i][j] = nodepointer; nodepointer+=1;}
            }
        }

        //REMNOVE THIS AND USE AN ARAY LIST, ADDIng EVERY TIME WE NEED TO

        Queue<int[]> q = new LinkedList<>();
        q.add(arr[0]);
        boolean[] visited = new boolean[nodes];

        int totalCombinations = 0;

        while(!q.isEmpty()){ //s is the parent, its an array, the first one being its tag, and the rest its children
            int[] s = q.peek(); q.remove();
            visited[s[0]] = true;
            for (int i = 1; i < k + 1; i++) {
                ArrayList<Integer> whereItsBeen = new ArrayList<Integer>();
                System.out.println("where its been is " + whereItsBeen);
                //check if it is valid, if it is then add it to the queue
                int[] temp = arr[s[i]];
                int distanceTravelled = 0; //follow up the nodes to find the distance

                while (temp[0] != 0){
                    int[] parent = {0, 0, 0}; //get parrent
                    if (temp[0] < k) parent = arr[0];
                    else parent = arr[((temp[0] - 1) - (temp[0] - 1)%k)/k];
                    System.out.println("parent of " + Arrays.toString(temp) + " is " + Arrays.toString(parent));

                    if (temp[0] != 0) temp = parent;
                    if (temp[0] % 3 == 0) { distanceTravelled += 3; whereItsBeen.add(distanceTravelled + 1); } //add distance ADD TO AREY LIST
                    else { distanceTravelled += temp[0]%3; whereItsBeen.add(distanceTravelled + 1); } //ADD TO ARRAY LEST
                }
                if (distanceTravelled < n - 1) {
                    if (!visited[arr[s[i]][0]]) q.add(arr[s[i]]);
                } else if (distanceTravelled == n - 1) {
                    System.out.println("Found a valid combination" + whereItsBeen + " with distance " + distanceTravelled + " array to string " + Arrays.toString(temp));
                    totalCombinations++;
                } else {
                    continue;
                }
                System.out.println("2 where its been is " + whereItsBeen);
            }
        }

        System.out.println(totalCombinations);
    }   
}