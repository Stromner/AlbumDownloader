package Interface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import Interface.Components.AbstractInfoPanel;
import Interface.Components.ButtonChooser;
import Interface.Components.SharedRowInfoPanel;
import Interface.Components.SplitRowInfoPanel;

public class InfoPanel extends JPanel{
	private static final long serialVersionUID = -6861415211460869827L;// Generated serialVersion
	private AbstractInfoPanel albumPage, artist, albumName, downloadPath;
	private ButtonChooser chooser;
	
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
		
		// TODO When a download path is provided, send it to the data part
		// if artist and album tag can be found; auto fill the Artist and
		// Album Name panels
		c.gridy = 1;
		downloadPath = new SplitRowInfoPanel("Download Path");
		add(downloadPath, c);
		c.gridx = 1;
		chooser = new ButtonChooser("...");
		add(chooser, c);
		
		c.gridx = 0;
		c.gridy = 2;
		artist = new SharedRowInfoPanel("Artist");
		add(artist, c);

		c.gridy = 3;
		albumName = new SharedRowInfoPanel("Album Name");
		add(albumName, c);
	}

}
