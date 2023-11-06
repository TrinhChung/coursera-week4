public class Entry {
    public static void main(String[] args) {
        Point point = new Point(1, 2);
        Shape s1 = new Circle(point, 11.0, "RED", false);
        Shape s2 = new Circle(point, 11.0, "RED", false);
        Shape s3 = new Rectangle(point, 3, 4, "WHITE", false);
        Shape s4 = new Rectangle(point, 3, 4, "RED", false);
        Shape s5 = new Square(point, 1,"WHITE", true);
        Layer layer = new Layer();
        layer.addShape(s1);
        layer.addShape(s3);
        layer.addShape(s4);
        layer.addShape(s5);
        layer.addShape(s4);
        layer.addShape(s3);

        layer.removeDuplicates();
        System.out.println(layer.getInfo());
    }
}
