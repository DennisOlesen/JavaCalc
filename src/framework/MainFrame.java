package framework;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	public static final int width = 500;
	public static final int height = 500;
	public final static MainFrame instance = new MainFrame();
	
	private MainFrame() {
    	this.setLayout(new BorderLayout());
    	this.setResizable(false);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setJMenuBar(MenuBar.instance);
    	this.setSize(width, height);
    	
    	this.setContentPane(new MainPanel());
    	
    	this.setVisible(true);
	}
	
	private class MainPanel extends JPanel {
	    
	    private MainPanel() {
	        super(new BorderLayout());
	        this.add(ResultBar.instance, BorderLayout.PAGE_START);
	        this.add(ButtonBar.instance, BorderLayout.CENTER);
	        this.add(StatusBar.instance, BorderLayout.PAGE_END);
	    }
	    
	}
	
}
