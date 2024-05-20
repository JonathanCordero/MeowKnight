import java.awt.Graphics;

public class Sprite extends Rect{

	Animation[] animation;
	boolean facingleft = false;
	boolean moving = false;
	
	int action =0;
	
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
		 action = 9;
		 facingleft = true;
		 moving = true;
	}
	public void goRT(int dx) {
		super.goRT(dx);
		action = 8;
		facingleft = false;
		moving = true;
	}
	
	public void goUP(int dy) {
		super.goUP(dy);
		action = 6;
		moving = true;
	}
	
	public void still() {
		
		if(facingleft) {
			action = 5;
		}
		else {
			action = 4;
		}
	}
	
	/*public void moveDN(int dy) {
		old_y = y;
		y += dy;
	}*/
	
	public void draw(Graphics g) {
		
		if(!moving && action != 4 && action !=5) g.drawImage(animation[action].stillImage(), x, y, w, h, null);
		else g.drawImage(animation[action].nextImage(), x, y, w, h, null);
		
		g.drawRect(x,y,w,h);
	}
	
}
