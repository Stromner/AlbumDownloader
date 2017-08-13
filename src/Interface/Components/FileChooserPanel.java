package Interface.Components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import Utilities.Logger;

public class FileChooserPanel extends AbstractInfoPanel{
	private static final long serialVersionUID = 3775754134504322648L;  // Generated serialVersion
	private JButton button;
	private JFileChooser chooser;
	
	public FileChooserPanel(String title, String buttonText){
		super(title);
		
		button = new JButton(buttonText);
		// TODO fix layout of this panel
		add(button);
		
		createChooser();
	}
	
	private void createChooser(){
		chooser = new JFileChooser();
		chooser.setDialogTitle("Select directory");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selection = chooser.showOpenDialog(button);
				
				if(selection == JFileChooser.APPROVE_OPTION){
					informer.setText(chooser.getSelectedFile().getPath()+'\\');
					Logger.infoLogger("User selected download path: " + informer.getText());
				}
			}
			
		});
	}
}
