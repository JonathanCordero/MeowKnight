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
	
	public void moveLT(int dx) {
		 old_x = x;
		 action = 9;
		 x -= dx;
		 facingleft = true;
		 moving = true;
	}
	public void moveRT(int dx) {
		old_x = x;
		action = 8;
		x += dx;
		facingleft = false;
		moving = true;
	}
	
	public void moveUP(int dy) {
		old_y = y;
		action = 6;
		y -= dy;
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
	}
	
}