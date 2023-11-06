import java.util.*;


public class Entry {
    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> tv = new ArrayList<>();
        final int n = a.size() / 2;
        Queue<Integer> max = new PriorityQueue<>();
        Queue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < a.size(); i++) {
            if (min.isEmpty()) {
                min.add(a.get(i));
            } else if (max.size() == min.size()) {
                if (a.get(i) < max.peek()) {
                    min.add(a.get(i));
                } else {
                    max.add(a.get(i));
                    min.add(max.poll());
                }
            } else if (max.size() < min.size()) {
                if (a.get(i) > min.peek()) {
                    max.add(a.get(i));
                } else {
                    min.add(a.get(i));
                    max.add(min.poll());
                }
            }
            if (max.size() == min.size()) tv.add(Double.valueOf((max.peek() + min.peek())/2.0));
            else tv.add(Double.valueOf(min.peek()));
        }
        return tv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> a = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        /*List<Double> b = runningMedian(a);
        for (int i = 0; i < b.size(); i++) {
            System.out.print(b.get(i) + " ");
        }*/
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < 6; i++) {
            queue.add(i);
        }
        while(queue.size() > 0) {
            System.out.println(queue.remove());
        }
    }
}