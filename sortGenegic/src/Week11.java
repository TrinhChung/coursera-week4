import java.util.Collections;
import java.util.List;

public class Week11 {
    /**
     * sap xep noi bot.
     */
    public static <T> List<T> sortGeneric(List<T> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (less(arr.get(i), arr.get(j)) <= 0) {
                    Collections.swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    /**
     * so sanh.
     */
    public static <T> int less(T t1, T t2) {
        if (t1 instanceof Integer) {
            return ((Integer) t1).compareTo((Integer) t2);
        } else {
            return ((String) t1).compareTo((String) t2);
        }
    }
}
