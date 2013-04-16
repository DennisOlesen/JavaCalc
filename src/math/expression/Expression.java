package math.expression;

/**
 * Defines a mathematical expression.
 * 
 * @author christoffer
 */
public abstract class Expression {
    
    public static final String X_COMES_BEFORE = "x comes before a";
    public static final String X_COMES_AFTER = "x comes after a";
    public static final String X_IS_UNDEFINED = "x is undefined";
    
    protected String flag;
    
    public Expression(final String flag) {
        this.flag = flag;
    }
    
    /**
     * Calculates the value of the expression.
     * 
     * @param   x   The variable integer
     * @return  y
     */
    public abstract int calculate(final int x);
}
