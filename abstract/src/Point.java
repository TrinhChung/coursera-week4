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

    /**so sanh .*/
    public boolean equals(Object point) {
        if (Math.abs(pointX - ((Point) point).getPointX()) <= 0.01
                && Math.abs(pointY - ((Point) point).getPointY()) <= 0.01) {
            return true;
        }
        return false;
    }

    public double distance(Point point2) {
        return Math.sqrt(Math.pow(getPointX() - point2.getPointX(), 2)
                + Math.pow(getPointX() - point2.getPointX(), 2));
    }

    public String toString() {
        return "(" + pointX + "," + pointY + ")";
    }
}
