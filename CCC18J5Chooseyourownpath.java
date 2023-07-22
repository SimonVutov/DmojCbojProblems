import java.util.*;

public class CCC18J5Chooseyourownpath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPages = scanner.nextInt();
        List<List<Integer>> pages = new ArrayList<>();
        for (int i = 0; i < numPages; i++) {
            int numChoices = scanner.nextInt();
            List<Integer> choices = new ArrayList<>();
            for (int j = 0; j < numChoices; j++) {
                choices.add(scanner.nextInt());
            }
            pages.add(choices);
        }
        scanner.close();

        boolean[] reachable = new boolean[numPages];
        int[] shortestPath = new int[numPages];
        Arrays.fill(reachable, false);
        Arrays.fill(shortestPath, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        reachable[0] = true;
        shortestPath[0] = 1;

        while (!queue.isEmpty()) {
            int currentPage = queue.poll();
            List<Integer> choices = pages.get(currentPage);
            for (int nextPage : choices) {
                if (nextPage < numPages) {
                    if (!reachable[nextPage]) {
                        reachable[nextPage] = true;
                        shortestPath[nextPage] = shortestPath[currentPage] + 1;
                        queue.add(nextPage);
                    }
                }
            }
        }

        boolean allReachable = true;
        for (boolean isReachable : reachable) {
            if (!isReachable) {
                allReachable = false;
                break;
            }
        }

        if (allReachable) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }

        System.out.println(shortestPath[numPages - 1]);
    }
}
