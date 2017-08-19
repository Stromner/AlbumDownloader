package Interface;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Utilities.Logger;

public class StartView extends JPanel{
	private static final long serialVersionUID = 6137707129912966399L; // Generated serialVersion	
	private JPanel sitesPanel, infoPanel;
	private JButton startButton;
	private BWindow root;
	
	public StartView(BWindow root){
		this.root = root;
		setLayout(new GridLayout(0,1));
		addPanels();
	}
	
	private void addPanels(){
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		
		sitesPanel = new SitesPanel();
		add(sitesPanel, c);
		
		infoPanel = new InfoPanel();
		add(infoPanel, c);
		
		// TODO startButton should not be able to be pressed without
		// a site alternative selected, album path entered and 
		// download path selected.
		// TODO shrink start button
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Logger.infoLogger("Starting downloading process ...");
				root.changeView();
			}
			
		});
		add(startButton);
	}
}
