package Interface.Components;

import java.awt.GridLayout;

public class SplitRowInfoPanel extends AbstractInfoPanel{
	private static final long serialVersionUID = -1730013103663611288L; // Generated serialVersion

	public SplitRowInfoPanel(String text){
		super(text);
		setLayout(new GridLayout(0, 1));
	}
}
