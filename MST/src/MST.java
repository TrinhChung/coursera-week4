import java.util.*;

class Cost implements Comparable<Cost> {
    public int r, v, w;

    public Cost(int cost, int vertex , int w) {
        r = cost;
        v = vertex;
        this.w = w;
    }

    @Override
    public int compareTo(Cost c) {
        if (r < c.r) return -1;
        if (r > c.r) return 1;
        if (v < c.v) return -1;
        if (v > c.v) return 1;
        if (w < c.w) return -1;
        if (w > c.w) return 1;
        return 0;
    }
}

class Edge implements Comparable<Edge> {
    public int i,dist;
    public Edge(int i, int dist) {
        this.i = i;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge e) {
        if (dist < e.dist) return -1;
        if (dist > e.dist) return  1;
        if (i < e.i) return -1;
        if (i > e.i) return 1;
        return 0;
    }
}

public class MST {
    public static Queue<Edge> pq = new PriorityQueue<>();
    public static void dijkstra(int[] distTo, ArrayList<ArrayList<Cost>> a, int start) {
        distTo[start] = 0;
        relex(start, a, distTo);
        while (!pq.isEmpty()) {
            Edge minE = pq.poll();
            relex(minE.i,a, distTo);
        }
    }
    public static void relex(int start, ArrayList<ArrayList<Cost>> a,int[] distTo) {
        for (int i = 0; i < a.get(start).size(); i++) {
            if (distTo[a.get(start).get(i).w] > distTo[start] + a.get(start).get(i).r) {
                distTo[a.get(start).get(i).w] = distTo[start] + a.get(start).get(i).r;
                pq.add(new Edge(a.get(start).get(i).w, distTo[a.get(start).get(i).w]));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int t = 0; t < q; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<ArrayList<Cost>> a = new ArrayList<ArrayList<Cost>>();
            for (int i = 0; i <= n; i++) {
                a.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int v = sc.nextInt();
                int w = sc.nextInt();
                int c = sc.nextInt();
                a.get(v).add(new Cost(c, v, w));
                boolean check = true;
                for (int j = 0; j < a.get(w).size(); j++) {
                    if (a.get(w).get(j).w == v && a.get(w).get(j).r == c) {
                        check = false;
                        break;
                    }
                }
                if (check) a.get(w).add(new Cost(c, w, v));

            }
            int[] distTo = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                distTo[i] = 100000000;
            }
            int start = sc.nextInt();
            dijkstra(distTo, a, start);
            for (int i = 1; i <= n; i++) {
                if (distTo[i] == 100000000) {
                    distTo[i] = -1;
                }
                if (i != start)
                System.out.print(distTo[i] + " ");
            }
            System.out.println();
        }
    }
}
