import plot.ExponentialPlot;
import plot.LinearPlot;
import plot.Plot;


public class MainPlot {

    public static void main(String[] args) {
        
        /*Plot plot1 = new ExponentialPlot(2, 10);
        plot1.setRange(-100, 100);
        plot1.showPlot();*/
        
        Plot plot2 = new LinearPlot(2, 15);
        plot2.setRange(-100, 100);
        plot2.showPlot();
    }
    
}
