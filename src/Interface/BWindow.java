/**
 * Basic window to host all the JPanels.
 * 
 * @author David Strömner
 * @version 2017-05-31
 */

package Interface;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BWindow {
	private JFrame frame;
	private JPanel mPanel, sitesPanel, infoPanel, runPanel;
	
	public BWindow(){
		frame = new JFrame("Album Downloader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		mPanel = new JPanel();
		mPanel.setLayout(new GridLayout(0,1));
		addPanels();
		
		frame.add(mPanel);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void addPanels(){
		sitesPanel = new SitesPanel();
		mPanel.add(sitesPanel);
		
		infoPanel = new InfoPanel();
		mPanel.add(infoPanel);
		
		runPanel = new RunPanel();
		mPanel.add(runPanel);
	}
}
