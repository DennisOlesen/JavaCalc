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
    
    /**
     * Constructs a new plot. A plot is a defined by a formula of only one
     * variable (x).
     * 
     * @param   formula Expression
     */
    public Plot(Expression formula) {
        this.formula = formula;
    }
    
    /**
     * Draws the plot.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int h = PLOT_FRAME_HEIGHT - 25;
        int w = PLOT_FRAME_WIDTH;
        
        int min = -200;
        int max = 200;
        
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
            int x1 = i;
            int y1 = formula.calculate(x1);
            
            int x = (w/2) + ((int) (x1*c_x));
            int y = (h/2) - ((int) (y1*c_y));
            
            //g.drawLine(x1 * c_x, (h/2) - (y1 * c_y), x2 * c_x, (h/2) - (y2 * c_y));
            if (y <= h && y >= 0)
                g.fillOval(x, y, 2, 2);
        }
        
        /* Draw labels on both axes. */
        g.setColor(Color.BLACK);
        int amountOfLabels_x = 10;
        int amountOfLabels_y = 10;
        
        int labelIncrement_x = w / amountOfLabels_x;
        int labelIncrement_y = h / amountOfLabels_y;
        
        /* Draw labels on x-axis. */
        for (int i = min; i < max; i += labelIncrement_x) {
            int x = (w/2) + ((int) (i*c_x));
            int y = (h/2);
            
            g.drawLine(x, y - 5, x, y +5);
            g.drawString(Integer.toString(i), x - 10, y - 20);
        }
        
        /* Draw labels on x-axis. */
        for (int i = min; i < max; i += labelIncrement_y) {
            int x = (w/2);
            int valueOfy = formula.calculate(i);
            int y = (h/2) - ((int) (valueOfy*c_y));
            
            g.drawLine(x - 5, y, x + 5, y);
            g.drawString(Integer.toString(valueOfy), x - 30, y + 7);
        }
    }
    
    /**
     * Opens a new window and draws the plot in it.
     */
    public void showPlot() {   
        JFrame frame = new JFrame(toString());
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(PLOT_FRAME_WIDTH, PLOT_FRAME_HEIGHT);
        frame.setContentPane(this);
        frame.setVisible(true);
    }
    
    @Override
    public String toString() {
        return "Plot: " + formula.toString();
    }
}
