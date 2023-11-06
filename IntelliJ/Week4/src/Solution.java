import java.lang.Object;

public class Solution {
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**set De. */
    public void setDenominator(int denominator) {
        if (this.denominator == 0) {
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
    }

    /**Khai bao.*/
    public Solution(int numerator, int denominator) {
            setNumerator(numerator);
            if (denominator == 0) {
                setDenominator(1);
            } else {
                setDenominator(denominator);
            }
    }

    /**Khong tham so. */
    public Solution() {
        this.numerator = 1;
        this.denominator = 1;
    }

    /**UCLN .*/
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            return a + b;
        } else {
            return gcd(b, a % b);
        }
    }

    /**Rut Gon. */
    public Solution reduce() {
        Solution a = new Solution();
        int u = gcd(this.numerator, this.denominator);
        a.numerator = this.numerator / u;
        a.denominator = this.denominator / u;
        return a;
    }

    /**Cong. */
    public Solution add(Solution x) {
        Solution a = new Solution();
        a.numerator = x.getNumerator() * getDenominator() + getNumerator() * x.getDenominator();
        a.denominator = x.getDenominator() * getDenominator();
        return a;
    }

    /**Tru. */
    public Solution subtract(Solution x) {
        if (x.denominator == 0 ) {
            Solution b = new Solution();
            b.denominator = denominator;
            b.numerator = numerator;
            return b;
        } else {
            Solution a = new Solution();
            a.numerator = this.numerator * x.getDenominator() - this.denominator * x.numerator;
            a.denominator = this.denominator * x.denominator;
            return a;
        }
    }

    /**Nhan. */
    public Solution multiply(Solution x) {
        Solution a = new Solution();
        a.numerator = x.getNumerator() * getNumerator();
        a.denominator = x.getDenominator() * getDenominator();
        return a;
    }

    /**Chia. */
    public Solution divide(Solution x) {
        Solution a = new Solution();
        a.numerator = getNumerator() * x.getDenominator();
        a.denominator = getDenominator() * x.getNumerator();
        return a;
    }

    /**So sanh. */
    public boolean equals(Object obj) {
        if (!(obj instanceof Solution)) {
            return false;
        } else {
            Solution a = new Solution();
            a.numerator = this.numerator;
            a.denominator = this.denominator;
            a = a.reduce();
            obj = ((Solution) obj).reduce();
            Solution b = new Solution();
            b.numerator = ((Solution) obj).numerator;
            b.denominator = ((Solution) obj).denominator;
            if (a.numerator == b.numerator && a.denominator == b.denominator) {
                return true;
            }
            return false;
        }
    }
}