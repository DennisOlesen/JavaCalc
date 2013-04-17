package plot;

import math.expression.Int;
import math.expression.Multiply;
import math.expression.Power;

/**
 * A class that defines an exponential plot.
 * 
 * @author christoffer
 */
public class ExponentialPlot extends Plot {

    private int a;
    private int b;
    
    /**
     * An exponential plot is defined by the formula f(x) = b*a^x.
     * 
     * @param a integer
     * @param b integer
     */
    public ExponentialPlot(int a, int b) {
        super(new Multiply(
                new Int(b),
                new Power(new Int(a)))
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
