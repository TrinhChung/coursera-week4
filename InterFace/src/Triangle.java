import java.text.Format;

public class Triangle implements GeometricObject {
    private Point p1;
    private Point p2;
    private Point p3;

    /**khoi tao.*/
    public Triangle(Point p1, Point p2, Point p3) throws RuntimeException {
        if (!(p1.checkLap(p2) || p2.checkLap(p3) || p3.checkLap(p1) || p1.checkHang(p2, p3))) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
        } else {
            throw new RuntimeException();
        }
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    @Override
    public double getArea() {
        return (double) 0.5 * Math.abs((p2.getPointX() - p1.getPointX())
                * (p3.getPointY() - p1.getPointY())
                - (p3.getPointX() - p1.getPointX()) * (p2.getPointY() - p1.getPointY()));
    }

    @Override
    public double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    /**in.*/
    @Override
    public String getInfo() {
        return String.format("Triangle[(%.2f,%.2f),(%.2f,%.2f),(%.2f,%.2f)]",
                p1.getPointX(), p1.getPointY(), p2.getPointX(), p2.getPointY(),
                p3.getPointX(), p3.getPointY());
    }
}
