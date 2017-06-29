package Interface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RunPanel extends JPanel{
	private static final long serialVersionUID = -1531384202996167030L; // Generated serialVersion
	private JButton cancel, start;
	
	public RunPanel(){
		setLayout(new GridBagLayout());
		addComponents();
	}

	private void addComponents(){
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.WEST;
		cancel = new JButton("Cancel");
		add(cancel);
		
		c.anchor = GridBagConstraints.EAST;
		start = new JButton("Start");		
		add(start);
	}
}
