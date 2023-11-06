import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Number {
    public int value;
    public int stt;

    public Number(int value, int stt) {
        this.value = value;
        this.stt = stt;
    }

    public Number(Number number) {
        this.value = number.value;
        this.stt = number.stt + 1;
    }

    public int compareTo(Number number) {
        if (value > number.value) {
            return 1;
        } else if (value < number.value) {
            return -1;
        } else if (stt > number.stt) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class Median {
    public static List<Double> runningMedian(double[] arr) {
        // Write your code here
        List<Double> b = new ArrayList<>();
        TreeSet<Double> c = new TreeSet<>();
        c.add(arr[0]);
        c.add(arr[1]);
        b.add(arr[0]);
        b.add((arr[0] + arr[1]) * 0.5);
        int size = 2;
        double median = (arr[0] + arr[1]) * 0.5;
        for (int i = 2; i < arr.length; i++) {
            c.add(arr[i]);
            size++;
            double t = arr[i];
            if (size % 2 != 0) {
                if (t > median) {
                    double j = c.higher(median);
                    b.add(j);
                    median = j;
                } else if (t < median) {
                    double j = c.lower(median);
                    b.add(j);
                    median = j;
                } else {
                    b.add(median);
                }
            } else {
                if (t > median) {
                    double j = (c.higher(median) + median) * 0.5;
                    b.add(j);
                    median = j;
                } else if (t < median) {
                    double j = (c.lower(median) + median) * 0.5;
                    b.add(j);
                    median = j;
                } else {
                    b.add(median);
                }
            }
        }
        return b;
    }

    public static void main(String[] args) {

    }
}
