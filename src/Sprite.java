import java.awt.Graphics;

public class Sprite extends Rect{

	Animation[] animation;
	boolean facingleft = false;
	boolean moving = false;
	
	int action = 0;
	
	public Sprite(String name, String [] pose, int x, int y, int count, int duration) {
		
		super(x,  y,  50,  100);
		animation = new Animation[pose.length];
		
		if(!moving) {
			for (int i = 0; i< animation.length; i++) {
				animation[i] = new Animation(name + "_" + pose[i], count, duration);
			}
		}
		else {
			for (int i = 0; i< animation.length; i++) {
				animation[i] = new Animation(name + "_" + pose[i], count, duration);
			}
		}
		
	}
	
	public void goLT(int dx) {
		 super.goLT(dx);
		 action = 2;
		 facingleft = true;
		 moving = true;
	}
	public void goRT(int dx) {
		super.goRT(dx);
		action = 3;
		facingleft = false;
		moving = true;
	}
	
	public void goUP(int dy) {
		super.goUP(dy);
		action = 15;
		moving = true;
	}
	
	public void chase(Rect r, int dx) {
		if (isLeftOf(r)) goRT(dx);
		if (isRightOf(r)) goLT(dx);
		
		move();
		
		}
	
	public void evade(Rect r, int dx) {
		if (isLeftOf(r)) goLT(dx);
		if (isRightOf(r)) goRT(dx);
		
		move();
		
	}
	
	public void still() {
		
		if(facingleft) {
			action = 0;
		}
		else {
			action = 1;
		}
	}
	
	/*public void moveDN(int dy) {
		old_y = y;
		y += dy;
	}*/
	
	public void draw(Graphics g) {
		if(!moving ) {
			still();
			g.drawImage(animation[action].stillImage(), x, y, w, h, null);
		}
		
		else {
			g.drawImage(animation[action].nextImage(), x, y, w, h, null);
			moving = false;
		
		
		g.drawRect(x,y,w,h);
	}
	
}
