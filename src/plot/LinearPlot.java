package plot;

import math.expression.Add;
import math.expression.Int;
import math.expression.Multiply;

/**
 * A class that defines a linear plot.
 * 
 * @author christoffer
 */
public class LinearPlot extends Plot {

    private int a;
    private int b;
    
    /**
     * A linear plot is defined by the formula f(x) = a*x+b.
     * 
     * @param a integer
     * @param b integer
     */
    public LinearPlot(int a, int b) {
        super(new Add(
                new Multiply(new Int(a)),
                new Int(b))
        );
        this.a = a;
        this.b = b;
    }
    
    public int getA() {
        return this.a;
    }
    
    public int getB() {
        return this.b;
    }
}
