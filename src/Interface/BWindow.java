/**
 * Basic window to host all the JPanels.
 * 
 * @author David Strömner
 * @version 2017-05-31
 */

package Interface;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BWindow{
	private JFrame frame;
	private JPanel startView, runView;
	
	public BWindow(){
		// TODO set a better size for the window
		frame = new JFrame("Album Downloader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		
		startView = new StartView(this);
		runView = new RunView();
		
		packFrame(startView);
	}

	public void changeView(){
		packFrame(runView);
	}
	
	private void packFrame(Component view){
		frame.getContentPane().removeAll();
		frame.add(view);
		frame.pack();
		frame.setVisible(true);
	}
}