/**
 * Basic window to host all the JPanels.
 * 
 * @author David Strömner
 * @version 2017-05-31
 */

package Interface;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BWindow {
	private JFrame frame;
	private JPanel mPanel, siteChoices;
	
	public BWindow(){
		frame = new JFrame("Album Downloader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 500)); // TODO remove this
		
		mPanel = new JPanel();
		mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.PAGE_AXIS));
		addPanels();
		
		frame.add(mPanel);
		frame.setVisible(true);
	}
	
	private void addPanels(){
		siteChoices = new SiteChoices();
		mPanel.add(siteChoices);
	}
}
