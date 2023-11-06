import java.lang.Math;

public class Entry {
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            return a + b;
        } else {
            return gcd(b, a % b);
        }
}
    public static void main(String[] args) {
        Solution a = new Solution(0,2);
        Solution b = new Solution(1,2);
        a = a.subtract(b);
        System.out.println(a.getNumerator()+" / "+a.getDenominator());
    }
}




