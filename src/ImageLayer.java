import java.awt.*;

public class ImageLayer {
	
	public Image image;
	
	int x;
	int y;
	
	int z;
	
	public ImageLayer(String filename, int x, int y, int z) {
		image = Toolkit.getDefaultToolkit().getImage(filename);
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, 1920, 1000, null);
	}
}
