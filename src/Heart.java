import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Heart extends Rect {
    private boolean collected;
    private Image image;
    private AudioPlayer collectEffect;

    public Heart(int x, int y, int w) {
        super(x + (int) (Math.random() * (w - 20)), y - 20, 20, 20);
        this.collected = false;
        this.image = Toolkit.getDefaultToolkit().getImage("heart.png");
        collectEffect = new AudioPlayer();
        collectEffect.load("collect.wav");
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
        collectEffect.play();
    }
}
