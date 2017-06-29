package Interface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import Interface.Components.AbstractInfoPanel;
import Interface.Components.SharedRowInfoPanel;
import Interface.Components.SplitRowInfoPanel;

public class InfoPanel extends JPanel{
	private static final long serialVersionUID = -6861415211460869827L;// Generated serialVersion
	private AbstractInfoPanel albumPage, artist, albumName, downloadPath;
	
	public InfoPanel(){
		setLayout(new GridBagLayout());
		addComponents();
	}
	
	private void addComponents(){
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.gridy = 0;
		albumPage = new SplitRowInfoPanel("Album Page");
		add(albumPage, c);
		
		c.gridy = 1;
		downloadPath = new SplitRowInfoPanel("Download Path");
		add(downloadPath, c);
		
		c.gridy = 2;
		artist = new SharedRowInfoPanel("Artist");
		add(artist, c);
		
		c.gridy = 3;
		albumName = new SharedRowInfoPanel("Album Name");
		add(albumName, c);
	}

}
