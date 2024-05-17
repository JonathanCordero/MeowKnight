import java.awt.Graphics;

public class Rect2 extends Rect {

	Rect resizer;
	
	public Rect2 (int x, int y, int w, int h) {
		super(x,y,w,h);
		
		resizer = new Rect(x+w-10, y+h-10, 10, 10);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		resizer.draw(g);
	}
	
	public void moveBy(int dx, int dy) {
		super.moveBy(dx, dy);
		
		resizer.moveBy(dx, dy);
	}
	
	public void resizeBy(int dx, int dy) {
		super.resizeBy(dx, dy);
		
		resizer.moveBy(dx, dy);
	}
	
}