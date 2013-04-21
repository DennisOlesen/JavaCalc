package plot;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import math.expression.Expression;

/**
 * Draws a plot given a formula (expression).
 * 
 * @author christoffer
 */
public class Plot extends JPanel {
    
    public final static int PLOT_FRAME_HEIGHT = 600;
    public final static int PLOT_FRAME_WIDTH = 600;
    
    private Expression formula;
    private int min;
    private int max;
    
    /**
     * Constructs a new plot. A plot is a defined by a formula of only one
     * variable (x). X-axis defaults to interval [-10; 10].
     * 
     * @param   formula Expression
     */
    public Plot(Expression formula) {
        this.formula = formula;
        this.min = -10;
        this.max = 10;
    }
    
    /**
     * Draws the plot.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int h = PLOT_FRAME_HEIGHT - 25;
        int w = PLOT_FRAME_WIDTH;
        
        // Draw plot axes
        g.drawLine(0, h/2, w, h/2); // x
        g.drawLine(w/2, 0, w/2, h); // y
        
        double max_d = (double) max;
        double min_d = (double) min;
        double w_d = (double) w;
        double h_d = (double) h;
        
        double c_x = w_d / (max_d - min_d);
        double c_y = h_d / (max_d - min_d);
        
        /* Draw the plot. */
        g.setColor(Color.RED);
        
        for (int i = min; i < max; i++) {
            int valueOfx1 = i;
            int valueOfy1 = formula.calculate(valueOfx1);
            
            int valueOfx2 = i+1;
            int valueOfy2 = formula.calculate(valueOfx2);
            
            int x1 = (w/2) + ((int) (valueOfx1*c_x));
            int y1 = (h/2) - ((int) (valueOfy1*c_y));
            
            int x2 = (w/2) + ((int) (valueOfx2*c_x));
            int y2 = (h/2) - ((int) (valueOfy2*c_y));
            
            g.drawLine(x1, y1, x2, y2);
        }
        
        /* Draw labels on both axes. */
        g.setColor(Color.BLACK);
        int amountOfLabels_x = 10;
        int amountOfLabels_y = 10;
        
        int max_y = getMaxY();
        int labelIncrement_x = (max - min) / amountOfLabels_x;
        int labelIncrement_y = (max_y) / amountOfLabels_y;
        
        /* Draw labels on x-axis. */
        for (int i = min; i < max; i += labelIncrement_x) {
            int x = (w/2) + ((int) (i*c_x));
            int y = (h/2);
            
            /* Don't draw zero. */
            if (i == 0)
                continue;
            
            g.drawLine(x, y - 5, x, y +5);
            g.drawString(Integer.toString(i), x - 5, y - 15);
        }
        
        /* Draw labels on y-axis. */
        int x = (w/2);
        for (int i = -max_y; i <= max_y; i += labelIncrement_y) {
            int y = (h/2) - ((int) (i*c_y));
            
            /* Don't draw zero. */
            if (i == 0)
                continue;
            
            g.drawLine(x - 5, y, x + 5, y);
            g.drawString(Integer.toString(i), x - 30, y + 7);
        }
    }
    
    private int getMaxY() {
        int temp;
        int max_y = formula.calculate(min);
        
        for (int i = min + 1; i <= max; i++) {
            temp = formula.calculate(i);
            if (temp > max_y)
                max_y = temp;
        }
        
        return max_y;
    }
    
    /**
     * Opens a new window and draws the plot in it.
     */
    public void showPlot() {   
        JFrame frame = new JFrame(toString());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(PLOT_FRAME_WIDTH, PLOT_FRAME_HEIGHT);
        frame.setContentPane(this);
        frame.setVisible(true);
    }
    
    /**
     * Set the borders of the x-axis.
     * 
     * @param from  Integer
     * @param to    Integer
     */
    public void setRange(int from, int to) {
        this.min = from;
        this.max = to;
    }
    
    @Override
    public String toString() {
        return "Plot: " + formula.toString();
    }
}
