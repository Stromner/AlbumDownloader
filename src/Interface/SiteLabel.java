/**
 * Custom JLabel with built in re-scaling of image-icon
 * 
 * @author David Strömner
 * @version 2017-05-31
 */

package Interface;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SiteLabel extends JLabel{
	private static final long serialVersionUID = 5743167818374644387L; // Generated serialVersion
	
	public SiteLabel(String text){
		super(text);
	}
	
	public SiteLabel(ImageIcon icon, int width, int height){
		super();
		ImageIcon newImage = new ImageIcon(getScaledImage(icon.getImage(), width, height));
		setIcon(newImage);
	}
	
	private Image getScaledImage(Image image, int width, int height){
		BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();
		
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(image, 0, 0, width, height, null);
		g2.dispose();
		
		return resizedImg;
	}
}
