import java.util.List;

public class ShapeUtil {
    /**tra ve.*/
    public static String printInfo(List<GeometricObject> shapes) {
        if (shapes.size() == 0) {
            return "";
        } else {
            String s = "";
            boolean checkC = true;
            boolean checkR = true;
            for (int i = 0; i < shapes.size(); i++) {
                if (shapes.get(i) instanceof Circle) {
                    if (checkC) {
                        s += "Circle:\n";
                        checkC = false;
                    }
                    s = s + shapes.get(i).getInfo() + "\n";
                }
            }
            for (int i = 0; i < shapes.size(); i++) {
                if (shapes.get(i) instanceof Triangle) {
                    if (checkR) {
                        s += "Triangle:\n";
                        checkR = false;
                    }
                    s = s + shapes.get(i).getInfo() + "\n";
                }
            }
            return s;
        }
    }
}
