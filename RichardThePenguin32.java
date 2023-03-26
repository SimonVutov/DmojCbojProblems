import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;

public class RichardThePenguin32 {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt(); int k = s.nextInt();

        ArrayList<int[]> arr = new ArrayList<int[]>();

        arr.add(0, new int[]{1, 2, 3});
        Queue<int[]> q = new LinkedList<>();
        q.add(arr.get(0));
        System.out.println(Arrays.toString(arr.get(0)));

        int totalCombinations = 0;
        int[]temp2 = new int[k];

        while(!q.isEmpty()){
            int[] s = q.peek(); q.remove();
            for (int i = 0; i < k; i++) { //for each child in the parent
                //check if it is valid, if it is then add it to the queue
                for(int j = 0; j < k; j++){
                    temp2[j] = s[i] * k + j + 1;
                }
                arr.add(s[i], temp2);
                System.out.println("added: " + Arrays.toString(arr.get(s[i])) + " to " + s[i]);
                int[] temp = arr.get(s[i]);
                System.out.println("temp now set to " + Arrays.toString(temp) + " at index " + arr.indexOf(temp) + " s[i] " + s[i]);
                int distanceTravelled = 0; //follow up the nodes to find the distance

                while (arr.indexOf(temp) != 0){
                    int[] parent = {0, 0, 0}; //get parrent
                    if (arr.indexOf(temp) < k) { parent = arr.get(0); System.out.println("1parent of " + arr.indexOf(temp) + " is " + Arrays.toString(parent)); }
                    else { parent = arr.get(((temp[0] - 1) - (temp[0] - 1)%k)/k); System.out.println("2parent of " + arr.indexOf(temp) + " is " + Arrays.toString(parent)); }

                    if (temp[0] != 0) temp = parent;
                    if (temp[0] % 3 == 0) { distanceTravelled += 3; } //add distance ADD TO AREY LIST
                    else { distanceTravelled += temp[0]%3; } //ADD TO ARRAY LEST
                    //System.out.println("int loop parent: " + parent[0] + " dist trav: " + distanceTravelled + " temp: " + temp[0] + " s[i] " + s[i]);
                }
                if (distanceTravelled < n - 1) {
                    q.add(temp2);
                } else if (distanceTravelled == n - 1) {
                    System.out.println("Found a valid combination" + Arrays.toString(arr.get(s[i])) + " with distance " + distanceTravelled);
                    totalCombinations++;
                } else {
                    continue;
                }
            }
        }

        System.out.println(totalCombinations);
    }   
}