package math.expression;

/**
 * Expression class that can add two numbers.
 * 
 * @author christoffer
 */
public class Add extends Expression {

    private Expression a;
    private Expression b;
    
    /**
     * Creates an addition expression a+x.
     * 
     * @param   a   Integer
     */
    public Add(Expression a) {
        super(Expression.X_COMES_AFTER);
        this.a = a;
    }
    
    /**
     * Creates an addition expression a+b.
     * 
     * @param   a   Integer
     * @param   b   Integer
     */
    public Add(Expression a, Expression b) {
        super(Expression.X_IS_UNDEFINED);
        this.a = a;
        this.b = b;
    }
    
    @Override
    public int calculate(final int x) {
        switch (flag) {
            case Expression.X_COMES_AFTER:
                return a.calculate(x)+x;
            case Expression.X_COMES_BEFORE:
                return x+a.calculate(x);
            default:
                return a.calculate(x)+b.calculate(x);
        }
    }
    
    @Override
    public String toString() {
        switch (flag) {
            case Expression.X_COMES_AFTER:
                return a.toString() + " + X";
            case Expression.X_COMES_BEFORE:
                return "X + " + a.toString();
            default:
                return a.toString() + " + " + b.toString();
    }
    }

}
