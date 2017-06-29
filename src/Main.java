import javax.swing.UIManager;

import Interface.BWindow;
import Utilities.Logger;

public class Main {
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
				BWindow window = new BWindow();
			}
		});
	}
}
