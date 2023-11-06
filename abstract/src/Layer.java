import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Layer {
    private List<Shape> shapes = new ArrayList<>();


    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**xoa tron .*/
    public void removeCircles() {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof Circle) {
                shapes.remove(i);
                i--;
            }
        }
    }

    /**chuoi return .*/
    public String getInfo() {
        String s = "Layer of crazy shapes:\n";
        for (int i = 0; i < shapes.size(); i++) {
            s += shapes.get(i).toString() + "\n";
        }
        return s;
    }

    /**xoa lap .*/
    public void removeDuplicates() {
        List<Shape> list = new ArrayList<>();
        list.add(shapes.get(0));
        for (int i = 1; i < shapes.size(); i++) {
            boolean checkC = true;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) instanceof Circle && shapes.get(i) instanceof Circle) {
                    if (list.get(j).equals(shapes.get(i))) {
                        checkC = false;
                        break;
                    }
                } else if (list.get(j) instanceof Square && shapes.get(i) instanceof Square) {
                    if (list.get(j).equals(shapes.get(i))) {
                        checkC = false;
                        break;
                    }
                } else if (list.get(j) instanceof Rectangle && shapes.get(i) instanceof Rectangle
                        && !(list.get(j) instanceof Square) && !(shapes.get(i) instanceof Square)) {
                    if (list.get(j).equals(shapes.get(i))) {
                        checkC = false;
                        break;
                    }
                }
            }
            if (checkC) {
                list.add(shapes.get(i));
            }
        }
        shapes.clear();
        shapes.addAll(list);
    }
}
