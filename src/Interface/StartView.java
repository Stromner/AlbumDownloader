package Interface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Utilities.Logger;

public class StartView extends JPanel{
	private static final long serialVersionUID = 6137707129912966399L; // Generated serialVersion	
	private JPanel sitesPanel, infoPanel;
	private JButton startButton, exitButton;
	private BWindow root;
	
	public StartView(BWindow root){
		this.root = root;
		setLayout(new GridBagLayout());
		addPanels();
	}
	
	private void addPanels(){
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridy = 0;
		c.gridx = 0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.anchor = GridBagConstraints.NORTH;
		sitesPanel = new SitesPanel();
		add(sitesPanel, c);
		
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		infoPanel = new InfoPanel();
		add(infoPanel, c);
		
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.anchor = GridBagConstraints.SOUTHWEST;
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Logger.infoLogger("Closing program");
				System.exit(0);
			}
		});
		add(exitButton, c);
		
		// TODO startButton should not be able to be pressed without
		// a site alternative selected, album path entered and 
		// download path selected.
		c.gridy = 2;
		c.gridx = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.anchor = GridBagConstraints.SOUTHEAST;
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Logger.infoLogger("Starting downloading process ...");
				root.changeView();
			}
			
		});
		add(startButton, c);
	}
}
