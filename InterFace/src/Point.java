public class Point {
    private double pointX;
    private double pointY;

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(other.getPointX() - getPointX(), 2)
                + Math.pow(other.getPointY() - getPointY(), 2));
    }

    public String getInfo() {
        return String.format("Point[(%.2f,%.2f)]", getPointX(), getPointY());
    }

    /**trung diem.*/
    public boolean checkLap(Point other) {
        if (other.getPointX() == getPointX() && other.getPointY() == getPointY()) {
            return true;
        } else {
            return false;
        }
    }

    /**check thang hang.*/
    public boolean checkHang(Point p2, Point p3) {
        double dx1 = p2.getPointX() - getPointX();
        double dy1 = p2.getPointY() - getPointY();
        double dx2 = p3.getPointX() - getPointX();
        double dy2 = p3.getPointY() - getPointY();
        if (dx1 * dy2 == dx2 * dy1) {
            return true;
        } else {
            return false;
        }
    }
}
