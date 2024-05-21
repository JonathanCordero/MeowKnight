import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//review code from professor.
public class MeowGame extends GameBase {
	
	
	/*
	 * Rect2 floor = new Rect2(363,919,1075,37);
	 * 
	 * 
	 * Rect2[] land = { new Rect2(84,94,87,805), new Rect2(1,836,361,119), new
	 * Rect2(378,664,247,20), new Rect2(879,664,247,20), new Rect2(1120,459,247,20),
	 * new Rect2(1612,829,317,26), };
	 * 
	 * Rect2[] hill = { new Rect2(1438,911,17,50), };
	 */
	
	
	//ImageLayer rock = new ImageLayer("rock_1.png", 0, 0, 1);
	//ImageLayer fen1 = new ImageLayer("fence_1.png", 0, 0, 1);
	//ImageLayer fen2 = new ImageLayer("fence_2.png",0, 0, 1);
		
	Area1 Area1 = new Area1(pressed);
	Area2 Area2 = new Area2(pressed);
	
	public void initialize() {
		setSize(1400,800);
		Area.setCurrentAreaTo(1);
	}
	
	public void inGameLoop() {
		//floor = Area1.floor;
		//land = Area1.land;
		//hill = Area1.hill;
		Area.inGameLoopStatic();		
	}

	public void paint(Graphics g) {
		Area.paintStatic(g);
	}
	
	public void keyPressed(KeyEvent e) {
		
		super.keyPressed(e);
		
		/*
		 * if (pressed[P]) { for (int i =0; i<land.length; i++) {
		 * System.out.println("new Rect2(" + land[i] +"),"); }
		 * System.out.println("new Rect2(" + floor +")"); } System.out.println();
		 */
	}
		
	public void mousePressed(MouseEvent e) {
		
		super.mousePressed(e);
		
		/*
		 * for (int i= 0; i <land.length; i++) { if (land[i].contains(mx,my))
		 * land[i].grabbed(); if (land[i].resizer.contains(mx, my))
		 * land[i].resizer.grabbed(); } if (floor.contains(mx, my)) floor.grabbed(); if
		 * (floor.resizer.contains(mx, my)) floor.resizer.grabbed();
		 */
	}
		
	public void mouseReleased(MouseEvent e) {
		
		/*
		 * for (int i= 0; i <land.length; i++) { land[i].dropped();
		 * land[i].resizer.dropped(); } floor.dropped(); floor.resizer.dropped();
		 */
	}
		
	public void mouseDragged(MouseEvent e) {
		int nx = e.getX();
		int ny = e.getY();
		
		int dx = nx-mx;
		int dy = ny-my;
		/*
		 * for (int i = 0; i<land.length;i++) { if (land[i].held) land[i].moveBy(dx,
		 * dy); if (land[i].resizer.held) land[i].resizeBy(dx,dy); }
		 * 
		 * if(floor.held) floor.moveBy(dx, dy); if(floor.resizer.held)
		 * floor.resizeBy(dx, dy);
		 */
		mx = nx;
		my = ny;
	}
	
}
