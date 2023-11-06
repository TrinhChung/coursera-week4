import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

import static java.util.Collections.emptyNavigableSet;
import static java.util.Collections.swap;


public class Entry {
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) break;
            }
            while (less(a[lo], a[--j])) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return  j;
    }
    public static void findMedian(int[] a, int lo, int hi) {
        if(a.length == 0) {
            return;
        }
        if (lo == a.length/2) {
            System.out.println(a[lo]);
        } else {
            int p = partition(a, lo, hi);
            findMedian(a, lo, p - 1);
            findMedian(a, p+1, hi);
        }
    }

    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(int comparable, int comparable1) {
        if(comparable <= comparable1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        findMedian(a, 0, 8);
    }
}
