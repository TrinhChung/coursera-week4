import java.lang.Math;

public class Week4 {
    /**
     *
     * @param a
     * @param b
     * @return max of $a and $b
     */
    public static int max2Int(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     *
     * @param arr
     * @return min of array $arr
     */
    public static int minArray(int[] arr) {
        int n = arr.length;
        int min = 10000000;
        for (int i = 0; i < n; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     *
     * @param weight: in kg
     * @param height: in m
     * @return BMI index
     */
    public static String calculateBMI(double weight, double height) {
        double b = weight / (height * height);
        b = (double)Math.round(b * 10) / 10;
        if (b >= 25) {
            return "Béo phì";
        }
        if (b <= 24.9 && b >= 23) {
            return "Thừa cân";
        }
        if (b >= 18.5 && b <= 22.9) {
            return "Bình thường";
        }
        return "Thiếu cân";
    }
}