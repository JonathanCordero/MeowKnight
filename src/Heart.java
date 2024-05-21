import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Heart extends Rect {
    private boolean collected;
    private Image image;

    public Heart(int x, int y, int w) {
        super(x + (int) (Math.random() * (w - 20)), y - 20, 20, 20);
        this.collected = false;
//        this.image =  new ImageLayer("heart.png", x, y, 1);
        this.image = Toolkit.getDefaultToolkit().getImage("heart.png");
//        this.image = new ImageIcon("heart.png").getImage(); // Ensure heart.png is in the project directory
    }

    public void draw(Graphics g) {
        if (!collected) {
        	g.drawImage(image, x, y, w, h, null);
//            image.draw(g);
        }
    }

    public boolean isCollected() {
        return collected;
    }

    public void collect() {
        this.collected = true;
    }
}
