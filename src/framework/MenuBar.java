package framework;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	
	public final static MenuBar instance = new MenuBar();
	
	private MenuBar() {
		this.setVisible(true);
		
		this.add(newFilesMenu());
	}
	
	
	private JMenu newFilesMenu() {
		JMenu Files = new JMenu("File");
		Files.add(newStuffItem());
		return Files;
	}
	
	private JMenuItem newStuffItem() {
		JMenuItem stuff = new JMenuItem("Stuff");
		return stuff;
	}
	
}
