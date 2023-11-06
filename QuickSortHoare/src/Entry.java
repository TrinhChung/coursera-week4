import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.shuffle;
import static java.util.Collections.swap;

public class Entry {
    public static int partition(List<Integer> arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (arr.get(++i) <= arr.get(lo)) {
                if (i == hi) break;
            }
            while (arr.get(--j) >= arr.get(lo)) {
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    public static void sort(List<Integer> arr) {
        quickSort(arr, 0, arr.size() - 1);
    }

    public static void quickSort(List<Integer> arr, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(arr, lo, hi);
        if (j - 1== arr.size() / 2) {
            System.out.println(arr.get(j - 1));
            return;
        }
        quickSort(arr, lo, j - 1);
        quickSort(arr, j + 1, hi);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        sort(arr);
    }
}
