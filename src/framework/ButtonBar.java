package framework;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonBar extends JPanel {

	public final static ButtonBar instance = new ButtonBar();
	
	private ButtonBar() {
		this.setVisible(true);
		this.setAlignmentY(BOTTOM_ALIGNMENT);
		this.setVisible(true);
		this.setSize(MainFrame.width, 400);
		this.add(new JButton("BinaryStuff"));
	}

	
}
