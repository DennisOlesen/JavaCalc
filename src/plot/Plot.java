package plot;

import javax.swing.JFrame;
import javax.swing.JPanel;

import math.expression.Expression;

public class Plot extends JPanel {
    
    public final static int PLOT_FRAME_HEIGHT = 400;
    public final static int PLOT_FRAME_WIDTH = 400;
    
    private Expression formula;
    
    /**
     * Constructs a new plot. A plot is a defined by a formula of only one
     * variable (x).
     * 
     * @param   formula Expression
     */
    public Plot(Expression formula) {
        this.formula = formula;
        drawPlot();
    }
    
    private void drawPlot() {
        
    }
    
    /**
     * Opens a new window and draws the plot in it.
     */
    public void showPlot() {   
        JFrame frame = new JFrame(toString());
        frame.setSize(PLOT_FRAME_WIDTH, PLOT_FRAME_HEIGHT);
        frame.add(this);
        frame.setVisible(true);
    }
    
    @Override
    public String toString() {
        return "Plot: " + formula.toString();
    }
}
