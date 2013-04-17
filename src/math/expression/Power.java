package math.expression;

/**
 * Expression class that can Power two numbers.
 * 
 * @author christoffer
 */
public class Power extends Expression {

    private Expression a;
    private Expression b;
    
    /**
     * Creates a power expression a^x.
     * 
     *@param    a   Integer
     */
    public Power(Expression a) {
        super(Expression.X_COMES_AFTER);
        this.a = a;
    }
    
    /**
     * Creates a power expression a^b.
     * 
     * @param   a   Integer
     * @param   b   Integer
     */
    public Power(Expression a, Expression b) {
        super(Expression.X_IS_UNDEFINED);
        this.a = a;
        this.b = b;
    }
    
    /**
     * Creates a power expression. The flag defines if the expression is a^x or
     * x^a.
     * 
     * @param   a       Integer
     * @param   flag    String - see constants in Expression class
     */
    public Power(Expression a, String flag) {
        super(flag);
        this.a = a;
    }
    
    @Override
    public int calculate(final int x) {
        switch (flag) {
            case Expression.X_COMES_AFTER:
                return (int) Math.pow(a.calculate(x), x);
            case Expression.X_COMES_BEFORE:
                return (int) Math.pow(x, a.calculate(x));
            default:
                return (int) Math.pow(a.calculate(x), b.calculate(x));
        }
    }

    @Override
    public String toString() {
        switch (flag) {
            case Expression.X_COMES_AFTER:
                return "("  + a.toString() + ") ^ X";
            case Expression.X_COMES_BEFORE:
                return "X ^ (" + a.toString() + ")";
            default:
                return "(" + a.toString() + ") ^ (" + b.toString() + ")";
        }
    }
    
}
