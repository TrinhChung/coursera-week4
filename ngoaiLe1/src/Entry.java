public class Entry {
    public static void main(String[] args) {
        Expression a1 = new Numeral(2);
        Expression a2 = new Numeral(0);
        Expression a3 = new Numeral(4);
        Expression a4 = new Square(a3);
        BinaryExpression sub = new Division(a1, a2);
        //System.out.println(sub.evaluate());
        BinaryExpression binaryExpression = new Addition(a1, a2);
        System.out.println(a4.toString());
    }
}
