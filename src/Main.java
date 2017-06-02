import javax.swing.UIManager;

import Interface.BWindow;
import Utilities.Logger;

public class Main {
	// TODO Put it on github

	public static void main(String[] args) {
		Logger.infoLogger("Starting program");
		
		
		// Run the UI in its own thread
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
				} catch( Exception e ) {
					e.printStackTrace();
				}
				Logger.infoLogger("Starting interface");
				BWindow window = new BWindow();
			}
		});
	}
}
