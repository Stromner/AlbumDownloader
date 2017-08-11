package Interface.Components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class ButtonChooser extends JButton{
	private static final long serialVersionUID = 2333115081000661417L; // Generated serialVersion
	
	private JFileChooser chooser;
	
	public ButtonChooser(String title){
		super();
		
		setText(title);
		
		chooser = new JFileChooser();
		addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			}
			
		});
	}
}
