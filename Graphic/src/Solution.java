import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
        int[] costs = new int[graph.size()];
        int UNIT_COST = 6;
        for (int i = 0; i < costs.length; i++) costs[i] = -1;
        costs[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i : graph.get(v)) {
                if (costs[i] == -1) {
                   q.add(i);
                   costs[i] = costs[v] + UNIT_COST;
                }
            }
        }
        return costs;
    }
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        Queue<Integer> a = new LinkedList<>();
        int[] b = new int[n];
        for(int i = 0; i < n; i ++) {
            b[i] = 0;
        }
        a.offer(s);
        while(! a.isEmpty()) {
            int tempt = a.poll();
            for(int i = 0; i < m; i++) {
                int x = edges.get(i).get(0);
                int y = edges.get(i).get(1);
                if (x == tempt) {
                    if ((b[y - 1] == 0) && y != s) {
                        b[y - 1] = b[x - 1] + 6;
                        a.offer(y);
                    }
                } else if (y == tempt) {
                    if ((b[x - 1] == 0) && x != s) {
                        b[x - 1] = b[y - 1] + 6;
                        a.offer(x);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < n; i ++) {
            if (i + 1 != s) {
                if (b[i] == 0) {
                    b[i] = -1;
                }
                result.add(b[i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; ++q) {
            int N, M, start;
            N = scanner.nextInt();
            M = scanner.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= N; ++i) {
                graph.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < M; ++i) {
                int n1, n2;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
            start = scanner.nextInt();
            int[] costs = findShortestReach(graph, start);
            for (int i = 1; i < costs.length; ++i) {
                if (i == start) continue;
                System.out.print(costs[i] + " ");
            }
            System.out.println();
        }
    }
}