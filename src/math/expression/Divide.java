package math.expression;

/**
 * Expression class that can Divide two numbers.
 * 
 * @author christoffer
 */
public class Divide extends Expression {

    private Expression a;
    private Expression b;
    
    /**
     * Creates a divide expression a / x.
     * 
     * @param   a   Integer
     */
    public Divide(Expression a) {
        super(Expression.X_COMES_AFTER);
        this.a = a;
    }
    
    /**
     * Creates a divide expression a / b.
     * 
     * @param   a   Integer
     * @param   b   Integer
     */
    public Divide(Expression a, Expression b) {
        super(Expression.X_IS_UNDEFINED);
        this.a = a;
        this.b = b;
    }
    
    /**
     * Creates a divide expression. The flag determines if the expression is
     * a / x or x / a.
     * 
     * @param   a       Integer
     * @param   flag    String - see constants in Expression class
     */
    public Divide(Expression a, String flag) {
        super(flag);
        this.a = a;
    }
    
    @Override
    public int calculate(final int x) {
        switch (flag) {
            case Expression.X_COMES_AFTER:
                return a.calculate(x) / x;
            case Expression.X_COMES_BEFORE:
                return x / a.calculate(x);
            default:
                return a.calculate(x) / b.calculate(x);
        }
    }
    
    @Override
    public String toString() {
        switch (flag) {
            case Expression.X_COMES_AFTER:
                return a.toString() + " / X";
            case Expression.X_COMES_BEFORE:
                return "X / " + a.toString();
            default:
                return a.toString() + " / " + b.toString();
        }
    }

}
