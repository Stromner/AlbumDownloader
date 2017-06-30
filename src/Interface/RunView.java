package Interface;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RunView extends JPanel{
	private static final long serialVersionUID = -9015065654427981999L; // Generated serialVersion
	private JTextField textField;
	private JButton stopButton;
	
	public RunView(){
		setLayout(new GridLayout(0,1));
		addPanels();
	}
	
	private void addPanels(){
		textField = new JTextField();
		textField.setEditable(false);
		add(textField);
		
		stopButton = new JButton("Stop");
		//TODO notify data to stop downloading
		add(stopButton);
	}
}
