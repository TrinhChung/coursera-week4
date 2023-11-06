public class Square extends Rectangle {
    public Square() {

    }

    public  Square(double side) {
        this.width = side;
        this.length = side;
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public Square(Point point, double side, String color, boolean filled) {
        super(point, side, side, color, filled);
    }

    public double getSide() {
        return length;
    }

    public void setSide(double side) {
        this.length = side;
        this.width = side;
    }

    /**sosanh.*/
    @Override
    public boolean equals(Object object) {
        if (topLeft.equals(((Square) object).topLeft)
                && Math.abs(((Square) object).getSide() - getSide()) <= 0.001) {
            return  true;
        }
        return false;
    }

    @Override
    public void setWidth(double side) {
        this.length = side;
        this.width = side;
    }

    @Override
    public void setLength(double side) {
        this.length = side;
        this.width = side;
    }

    @Override
    public String toString() {
        return "Square[topLeft=(" + topLeft.getPointX() + "," + topLeft.getPointY()
                + "),side=" + length + ",color=" + color + ",filled=" + filled + "]";
    }
}
