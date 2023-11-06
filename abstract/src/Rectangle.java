public class Rectangle extends Shape {
    protected Point topLeft;
    protected double width;
    protected double length;


    public Rectangle() {

    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    /**so sanh .*/
    @Override
    public boolean equals(Object object) {
        if (topLeft.equals(((Rectangle) object).topLeft)
                && Math.abs(((Rectangle) object).getWidth() - getWidth()) <= 0.001
                && Math.abs(((Rectangle) object).getLength() - getLength()) <= 0.001) {
            return  true;
        }
        return false;
    }

    @Override
    public double getArea() {
        return 1.0 * length * width;
    }

    @Override
    public double getPerimeter() {
        return  2.0 * (length + width);
    }

    @Override
    public String toString() {
        return "Rectangle[topLeft=(" + topLeft.getPointX()
                + "," + topLeft.getPointY() + "),width=" + width + ",length="
                + length + ",color=" + color + ",filled=" + filled + "]";
    }

    /**truyen tham so .*/
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /** khoi tao 6 tham so .*/
    public Rectangle(Point point, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
        this.topLeft = point;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}
