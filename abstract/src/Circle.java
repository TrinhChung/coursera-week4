public class Circle extends Shape {
    protected Point center;
    protected double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**khai bao .*/
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.center = center;
        this.radius = radius;
    }


    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    /**equals .*/
    public boolean equals(Object object) {
        if (center.equals(((Circle) object).center)
        && Math.abs(((Circle) object).getRadius() - getRadius()) <= 0.001) {
            return  true;
        }
        return false;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[center=(" + center.getPointX() + "," + center.getPointY()
                + "),radius=" + radius + ",color=" + color + ",filled=" + filled + "]";
    }
}
