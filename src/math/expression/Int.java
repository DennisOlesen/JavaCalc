package math.expression;

/**
 * Class that defines an integer expression.
 * 
 * @author christoffer
 */
public class Int extends Expression {

    private int value;
    
    /**
     * Creates an integer expression with value.
     */
    public Int() {
        super(Expression.X_IS_UNDEFINED);
        this.value = 0;
    }
    
    /**
     * Creates an integer expression with value.
     * 
     * @param   value   Integer
     */
    public Int(int value) {
        super(Expression.X_IS_UNDEFINED);
        this.value = value;
    }

    @Override
    public int calculate(int x) {
        return value;
    }
    
    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

}
