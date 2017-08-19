package Interface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import Interface.Components.AbstractInfoPanel;
import Interface.Components.FileChooserPanel;
import Interface.Components.SharedRowInfoPanel;
import Interface.Components.SplitRowInfoPanel;

public class InfoPanel extends JPanel{
	private static final long serialVersionUID = -6861415211460869827L;// Generated serialVersion
	private AbstractInfoPanel albumURL, artist, albumName;
	private FileChooserPanel downloadPath;
	
	public InfoPanel(){
		setLayout(new GridBagLayout());
		addComponents();
	}
	
	private void addComponents(){
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		
		c.gridy = 0;
		albumURL = new SplitRowInfoPanel("Album URL");
		add(albumURL, c);
		
		// TODO When a download path is provided, send it to the data part
		// if artist and album tag can be found; auto fill the Artist and
		// Album Name panels
		c.gridy = 1;
		downloadPath = new FileChooserPanel("Download Path", "...");
		add(downloadPath, c);

		c.gridy = 2;
		artist = new SharedRowInfoPanel("Artist");
		add(artist, c);

		c.gridy = 3;
		albumName = new SharedRowInfoPanel("Album Name");
		add(albumName, c);
	}

}
