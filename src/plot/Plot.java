package plot;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import math.expression.Expression;

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
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int h = PLOT_FRAME_HEIGHT - 25;
        int w = PLOT_FRAME_WIDTH;
        
        // Draw plot axes
        g.drawLine(0, h/2, w, h/2); // x
        g.drawLine(w/2, 0, w/2, h); // y
        
        ArrayList<Integer> ys = new ArrayList<Integer>();
        
        /* Find the maximum and minimum of the y-axis. */
        int max_y = formula.calculate(-10);
        ys.add(max_y);
        int min_y = max_y;
        for (int x = -9; x <= 10; x++) {
            int y = formula.calculate(x);
            ys.add(y);
            
            if (y > max_y)
                max_y = y;
            
            if (y < min_y)
                min_y = y;
        }
        
        /* Draw the plot. */
        g.setColor(Color.RED);
        int amountOfLabels = ys.size();
        int c_x = w / amountOfLabels;
        int c_y = h / amountOfLabels;
        for (int i = 0; i < amountOfLabels - 1; i++) {
            int x1 = i;
            int x2 = i+1;
            
            int y1 = ys.get(i);
            int y2 = ys.get(i+1);
            
            g.drawLine(x1 * c_x, (h/2) - (y1 * c_y), x2 * c_x, (h/2) - (y2 * c_y));
        }
    }
    
    /**
     * Opens a new window and draws the plot in it.
     */
    public void showPlot() {   
        JFrame frame = new JFrame(toString());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(PLOT_FRAME_WIDTH, PLOT_FRAME_HEIGHT);
        frame.add(this);
        frame.setVisible(true);
    }
    
    @Override
    public String toString() {
        return "Plot: " + formula.toString();
    }
}
