import java.awt.*;
import java.awt.event.*;

public abstract class Area {
	
	static Area[] area = new Area[3];
	static int count = 0;
	
	ImageLayer background;
	
	final int UP = KeyEvent.VK_UP; 
	final int DN = KeyEvent.VK_DOWN; 
	final int LT = KeyEvent.VK_LEFT; 
	final int RT = KeyEvent.VK_RIGHT; 
	final int P = KeyEvent.VK_P;
	
	static Sprite MeowKnight = new MeowKnight(200, 200);
	static boolean[]pressed; 
	//static sprite foe;
	
	public Area(boolean[] pressed, String filename) {
		this.pressed = pressed;
		count++;
		area[count] = this;
		
		background = new ImageLayer(filename, 0, 0, 0);
	}
	
	public static void setCurrentAreaTo(int n) {
		area[0] = area[n];
	}
	
	public static void inGameLoopStatic() {
		area[0].inGameLoop();
	}
	
	public static void paintStatic(Graphics g) {
		area[0].paint(g);
	}
	
	public abstract void inGameLoop();
	
	public abstract void paint(Graphics g);
	
}
