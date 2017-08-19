package Interface.Components;

import java.awt.GridLayout;

public class SharedRowInfoPanel extends AbstractInfoPanel{
	private static final long serialVersionUID = -140346836464505600L; // Generated serialVersion

	public SharedRowInfoPanel(String title){
		super(title);
		setLayout(new GridLayout(1, 0));
		informer.setEditable(false);
		
		addComponents();
	}
}
