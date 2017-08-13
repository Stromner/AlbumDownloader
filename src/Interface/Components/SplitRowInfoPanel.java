package Interface.Components;

import java.awt.GridLayout;

public class SplitRowInfoPanel extends AbstractInfoPanel{
	protected static final long serialVersionUID = -1730013103663611288L; // Generated serialVersion

	public SplitRowInfoPanel(String title){
		super(title);
		setLayout(new GridLayout(0, 1));
	}
}
