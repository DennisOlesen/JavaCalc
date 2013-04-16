package math.expression;

public class Int extends Expression {

    private int value;
    
    public Int() {
        super(Expression.X_IS_UNDEFINED);
        this.value = 0;
    }
    
    public Int(int value) {
        super(Expression.X_IS_UNDEFINED);
        this.value = value;
    }
    
    public Int(int value, String flag) {
        super(flag);
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
