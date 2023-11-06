public class Division extends BinaryExpression {
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String toString() throws ArithmeticException {
        if (right.evaluate() != 0) {
            return "(" + left.toString() + " / " + right.toString() + ")";
        } else {
            throw new ArithmeticException();
        }
    }

    @Override
    public double evaluate() throws ArithmeticException {
        if (right.evaluate() != 0) {
            return left.evaluate() / right.evaluate();
        } else {
            throw new ArithmeticException("Lỗi chia cho 0");
        }
    }
}
