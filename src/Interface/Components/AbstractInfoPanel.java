package Interface.Components;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class AbstractInfoPanel extends JPanel{
	private static final long serialVersionUID = 6848843263432226277L; // Generated serialVersion
	
	protected String title;
	protected JLabel header;
	protected JTextField informer;
	
	public AbstractInfoPanel(String title){
		super();
		
		this.title = title;
		
		header = new JLabel(title);
		informer = new JTextField("");
		
		add(header);
		add(informer);
	}
}
