package Interface.Components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
		setLayout(new GridBagLayout());
		button = new JButton(buttonText);
		button.setMargin(new Insets(0,0,0,0)); // Removes the extra space around the button
				
		createChooser();
		addComponents();
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
	
	@Override
	protected void addComponents(){
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		add(header, c);
	
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0;
		c.anchor = GridBagConstraints.WEST;
		add(button, c);
		
		c.gridy = 1;
		c.gridx = 0;
		c.weightx = 1;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(informer, c);
	}
}
