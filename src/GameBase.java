import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public abstract class GameBase extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener{
		
	int mx = -1;
	int my = -1;

	boolean[] pressed = new boolean[1024];
	
	final int UP = KeyEvent.VK_UP; 
	final int DN = KeyEvent.VK_DOWN; 
	final int LT = KeyEvent.VK_LEFT; 
	final int RT = KeyEvent.VK_RIGHT; 
	
		
	boolean UP_Pressed = false;
	boolean DN_Pressed = false;
	boolean LT_Pressed = false;
	boolean RT_Pressed = false;
		
	Image offScreenImg;
	Graphics offScreenG;
			
	public void init() {
			
		offScreenImg= this.createImage(1920, 1200);
		offScreenG = offScreenImg.getGraphics();
			
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
			
		requestFocus();
			
			
		Thread t = new Thread(this);
		t.start();
	}
		
	public void run() {
		//game Loop
		while(true) {
				
			inGameLoop();
			
			repaint();
				
			try {
				Thread.sleep(16);
			}
			catch(Exception x) {};
		}
	}
	
	public abstract void inGameLoop();
		
		public void update (Graphics g) {
			
			offScreenG.clearRect(0, 0, 2560, 1600);
			paint(offScreenG);
			g.drawImage(offScreenImg,0, 0, null);
		}

		
		public void keyPressed(KeyEvent e) {
			
			//pressed[e.getKeyCode()] = true;
			
			int code = e.getKeyCode();
			if (code == e.VK_UP) UP_Pressed = true;
			if (code == e.VK_DOWN) DN_Pressed = true;
			if (code == e.VK_LEFT) LT_Pressed = true;
			if (code == e.VK_RIGHT) RT_Pressed =  true;
	
		}
		
		public void keyReleased( KeyEvent e){
			
			//pressed[e.getKeyCode()] = false;
			
			int code = e.getKeyCode();
			if (code == e.VK_UP) UP_Pressed = false;
			if (code == e.VK_DOWN) DN_Pressed = false;
			if (code == e.VK_LEFT) LT_Pressed = false;
			if (code == e.VK_RIGHT) RT_Pressed =  false;
			//MeowKnight.still();
		}
		
		public void paint(Graphics g) {
			
		}
		

	public void keyTyped(KeyEvent e) {
			
		}

		@Override
	public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
	public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			mx = e.getX();
			my= e.getY();
		}

		@Override
	public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
	public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
	public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int nx = e.getX();
		int ny = e.getY();
		
		int dx = nx-mx;
		int dy = ny-my;
	}
		
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}
		
}
