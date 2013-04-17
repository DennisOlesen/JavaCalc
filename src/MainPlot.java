import plot.ExponentialPlot;
import plot.LinearPlot;
import plot.Plot;


public class MainPlot {

    public static void main(String[] args) {
        
        Plot plot1 = new ExponentialPlot(5, 1);
        plot1.showPlot();
        
        Plot plot2 = new LinearPlot(2, 1);
        plot2.showPlot();
        
        Plot plot3 = new ExponentialPlot(-2, 3);
        plot3.showPlot();
    }
    
}
