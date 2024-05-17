import java.awt.Graphics;

public class Rect {

	int x;
	int y;
	
	int w;
	int h;
	
	int old_x;
	int old_y;
	
	boolean held = false;
	
	public Rect(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		old_x = x;
		old_y = y;
	}
	
	public void grabbed() {
		held = true;
	}
	
	public void dropped() {
		held = false;
	}
	
	public void draw(Graphics g) {
		g.drawRect(x, y, w, h);
	}
	
	public void moveLT(int dx) {
		 old_x = x;
		 x -= dx;
	}
	public void moveRT(int dx) {
		old_x = x;
		x += dx;
	}
	
	public void moveUP(int dy) {
		old_y = y;
		y -= dy;
	}
	
	public void moveDN(int dy) {
		old_y = y;
		y += dy;
	}
	
	public void moveBy(int dx, int dy) {
		
		x += dx;
		y += dy;
		
	}
	
	public void resizeBy(int dw, int dh) {
		w += dw;
		h += dh;
	}
	
	public boolean overlaps(Rect r) {
		return	(x+w >= r.x) && 
				(r.x+r.w >= x) && 
				(y+h >= r.y) && 
				(r.y +r.h >= y);
	}
	
	public void pushOutof(Rect r) {
		 if (cameFromAbove(r)) pushBackAbove(r);
		 
		 if (cameFromBelow(r)) pushBackBelow(r);
		 
		 if (cameFromleft(r))  pushbackLeft(r);
		 
		 if (cameFromRight(r)) pushbackRight(r);
		
	}
	
	public boolean cameFromleft(Rect r) {
		return old_x + w < r.x;
	}
	
	public boolean cameFromRight(Rect r) {
		return r.x +r.w < old_x;
	}
	
	public boolean cameFromAbove(Rect r) {
		return old_y +h < r.y;
	}
	
	public boolean cameFromBelow(Rect r) {
		return r.y + r.h < old_y;
	}
	
	public void pushbackLeft(Rect r) {
	 	x = r.x - w - 1;
	}
	
	public void pushbackRight(Rect r) {
		x = r.x + r.w + 1; 
	}
	
	public void pushBackAbove(Rect r) {
		y = r.y - h - 1;
	}
	
	public void pushBackBelow(Rect r) {
		y = r.y +h +1;
	}
	
	public boolean isLeftOf(Rect r)
	{
		return x+w < r.x;
	}
	
	public boolean isRightOf(Rect r) {
		return r.x +r.w <x;
	}
	
	public boolean isAbove(Rect r) {
		return y+h <r.y;
	}
	
	public boolean isBelow(Rect r) {
		return r.y +r.h <y;
	}
	
	public void chase(Rect r, int dx) {
		if (isLeftOf(r)) moveRT(dx);
		if (isRightOf(r)) moveLT(dx);
		if (isAbove(r)) moveDN(dx);
		if (isBelow(r)) moveUP(dx);
		}
	public void evade(Rect r, int dx) {
		if (isLeftOf(r)) moveLT(dx);
		if (isRightOf(r)) moveRT(dx);
		if (isAbove(r)) moveUP(dx);
		if (isBelow(r)) moveDN(dx);
	}
	
	public boolean contains (int mx, int my) {
		return (mx>= x) &&
				(mx <= x+w) &&
				(my >= y) &&
				(my <= y+h);
	}
	public String toString() {
		return "" + x + "," + y + "," + w + "," + h;
	}
	
}
 