/**
 * Panel for choosing which site to download from, contains all the alternatives that the program supports.
 * 
 * @author David Strömner
 * @version 2017-05-31
 */

package Interface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.MediaTracker;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Utilities.GlobalPaths;
import Utilities.Logger;

public class SiteChoices extends JPanel{
	public static final int ICON_WIDTH = 16;
	public static final int ICON_HEIGHT = 16; 
	
	private static final long serialVersionUID = 736660268990724071L; // Generated serialVersion
	private List<SiteLabel> siteIcons;
	private List<JLabel> texts;
	private List<JRadioButton> radioButtons;
	private ButtonGroup group;
	
	public SiteChoices(){
		super();
		siteIcons = new ArrayList<SiteLabel>();
		texts = new ArrayList<JLabel>();
		radioButtons = new ArrayList<JRadioButton>();
		
		setLayout(new GridBagLayout());
		addSiteChoices();
		
		group = new ButtonGroup();
		for(int i=0;i<radioButtons.size();i++){
			group.add(radioButtons.get(i));
		}
	}
	
	private void addSiteChoices(){
		GridBagConstraints c = new GridBagConstraints();
		int y = 0;
		try {
			Scanner reader = new Scanner(new FileReader(GlobalPaths.SITEPATH));
			if(!reader.hasNextLine()){
				Logger.errorLogger("Nothing to read from " + GlobalPaths.SITEPATH);
				reader.close();
				throw new RuntimeException();
			}
			
			while(reader.hasNextLine()){
				c.gridy = y++;
				addComponentsForChoice(reader.nextLine(), c);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			Logger.errorLogger("File " + GlobalPaths.SITEPATH + " could not be read or does not exist");
			throw new RuntimeException();
		}
	}
	
	private void addComponentsForChoice(String dispName, GridBagConstraints c){	
		Logger.infoLogger("Creating site alternative " + dispName + " for interface");
		
		//
		// Icon
		//
		c.gridx = 0;
		ImageIcon icon = new ImageIcon(GlobalPaths.ICONPATH+dispName+GlobalPaths.ICONLIBEXTENSION);
		if(icon.getImageLoadStatus() != MediaTracker.ERRORED && icon.getImageLoadStatus() != MediaTracker.ABORTED){
			Logger.infoLogger("Found icon for " + dispName);
			siteIcons.add(new SiteLabel(icon, ICON_WIDTH, ICON_HEIGHT));
			add(siteIcons.get(siteIcons.size()-1), c);
		}
		else{
			Logger.infoLogger("Could not find icon for " + dispName);
			siteIcons.add(new SiteLabel("?"));
			add(siteIcons.get(siteIcons.size()-1), c);
		}
		
		//
		// Text
		//
		c.gridx = 1;
		texts.add(new JLabel(dispName));
		add(texts.get(texts.size()-1), c);
		
		//
		// RadioButton
		//
		c.gridx = 2;
		radioButtons.add(new JRadioButton());
		add(radioButtons.get(radioButtons.size()-1), c);
	}
}