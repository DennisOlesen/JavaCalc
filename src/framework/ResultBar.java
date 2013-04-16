package framework;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class ResultBar extends JPanel {
	
	public final static ResultBar instance = new ResultBar();
	
	private ResultBar() {
		this.setBackground(Color.black);
		this.setLayout(new GridLayout(1,0));
		this.setVisible(true);
		this.setAlignmentY(BOTTOM_ALIGNMENT);
		this.setSize(MainFrame.width, 20);
		
		JTextField ResultBarField = new JTextField();
		ResultBarField.setBackground(Color.black);
		this.add(ResultBarField);
	}

	

}
