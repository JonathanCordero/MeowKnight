import java.awt.*;
import java.awt.event.*;

public abstract class Area {

	
	 private static final int ORIGINAL_SCREEN_WIDTH = 1920; private static final
	 int ORIGINAL_SCREEN_HEIGHT = 1000;
	  
	 static int screenWidth; static int screenHeight;
	  
	 static { Toolkit toolkit = Toolkit.getDefaultToolkit(); Dimension screenSize = toolkit.getScreenSize(); screenWidth = screenSize.width; screenHeight =
	 screenSize.height-75; }
	  
	  
	 double scaleX = (double) screenWidth / ORIGINAL_SCREEN_WIDTH; double scaleY = (double) screenHeight / ORIGINAL_SCREEN_HEIGHT;
	 

	static Area[] area = new Area[3];
	static int count = 0;

	ImageLayer background;

	final int UP = KeyEvent.VK_UP;
	final int DN = KeyEvent.VK_DOWN;
	final int LT = KeyEvent.VK_LEFT;
	final int RT = KeyEvent.VK_RIGHT;
	final int P = KeyEvent.VK_P;
	final int A = KeyEvent.VK_A;
	final int S = KeyEvent.VK_S;
	final int Z = KeyEvent.VK_Z;

	static MeowKnight MeowKnight = new MeowKnight(200, 200);
	static boolean[] pressed;

	public Area(boolean[] pressed, String filename) {
		this.pressed = pressed;
		count++;
		area[count] = this;

		// add 1 to z DO NOT PUT 0
		background = new ImageLayer(filename, 0, 0, 1);
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
