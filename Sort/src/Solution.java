import javax.management.Query;
import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
public class Solution {
    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi)  a[k] = aux[i++];
            else if (aux[j] <= aux[i]) a[k] = aux[j++];
            else  a[k] = aux[i++];
        }
    }
    public static void sort(int[] arr, int[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) /2;
        sort(arr, aux, lo, mid);
        sort(arr,aux, mid + 1, hi);
        merge(arr, aux, lo,mid, hi);
    }
    public static int[] mergerSort(int[] arr) {
        int[] aux = new int[arr.length];
        sort(arr, aux, 0, arr.length - 1);
        return aux;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        mergerSort(a);
        int min = 1000;
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] < min) {
                min = a[i] - a[i - 1];
            }
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] == min) {
                System.out.print(a[i - 1] + " " + a[i] + " ");
            }
        }
    }
}
