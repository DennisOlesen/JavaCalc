package framework;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public static final int width = 500;
	public static final int height = 500;
	public final static MainFrame instance = new MainFrame();
	
	private MainFrame() {
	this.setLayout(new FlowLayout());
	this.setResizable(false);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setJMenuBar(MenuBar.instance);
	this.setSize(width, height);
	this.setVisible(true);
	this.add(StatusBar.instance);
	this.add(ButtonBar.instance);
	this.add(ResultBar.instance);

	}
	
	
}
