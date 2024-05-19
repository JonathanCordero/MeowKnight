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
	final int P = KeyEvent.VK_P;
	
	Image offScreenImg;
	Graphics offScreenG;
	
	
	static int screenWidth;
	static int screenHeight; 
	
	
	static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height-75;
    }
	
	public void init() {
		
		initialize();
		
		//(1920, 1200)
		offScreenImg= this.createImage(screenWidth, screenHeight);
		offScreenG = offScreenImg.getGraphics();
			
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
			
		requestFocus();
			
			
		Thread t = new Thread(this);
		t.start();
	}
	
	public abstract void initialize();
		
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
			//(0, 0, 2560, 1600)
			offScreenG.clearRect(0, 0, screenWidth, screenHeight );
			paint(offScreenG);
			g.drawImage(offScreenImg,0, 0, null);
		}

		
		public void keyPressed(KeyEvent e) {
			pressed[e.getKeyCode()] = true;
		}
		
		public void keyReleased( KeyEvent e){
			pressed[e.getKeyCode()] = false;
		}
		
		public void paint(Graphics g) {}
		

	public void keyTyped(KeyEvent e) {}

		//@Override
	public void mouseClicked(MouseEvent e) {
		}

		//@Override
	public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			mx = e.getX();
			my= e.getY();
		}

		//Override
	public void mouseReleased(MouseEvent e) {}

		//@Override
	public void mouseEntered(MouseEvent e) {}

		//@Override
	public void mouseExited(MouseEvent e) {}

		//@Override
	public void mouseDragged(MouseEvent e) {
		/*int nx = e.getX();
		int ny = e.getY();
		
		int dx = nx-mx;
		int dy = ny-my;*/
	}
		
	//@Override
	public void mouseMoved(MouseEvent e) {}
		
	
}
