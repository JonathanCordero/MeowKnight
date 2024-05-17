
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MeowGame extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener{

		// x,y, width, height
		Rect2[] wall = {
			new Rect2( 148, 100, 30, 800),//left
			new Rect2 (1500, 200, 30, 800),//right
			new Rect2 (100, 350, 1600, 30),//top
			new Rect2(200, 800, 1600, 30)
		};
		
		int mx = -1;
		int my = -1;

		Rect bad = new Rect (1000, 700, 30, 30);
		//Rect r2 = new Rect(200,200,30,30);
		
		Image Grassbox = Toolkit.getDefaultToolkit().getImage("Grassbox.png");
		
		boolean UP_Pressed = false;
		boolean DN_Pressed = false;
		boolean LT_Pressed = false;
		boolean RT_Pressed = false;
		
		Image offScreenImg;
		Graphics offScreenG;
		
		String[] pose = {"Attack_1", "Attack_2", "Death", 
				"Dodge", "Idle", "IdleLeft", 
				"Jump","Reflect","Run", 
				"RunLeft","Take_Damage"};
		
		Sprite MeowKnight = new Sprite("Meow-Knight", pose, 150, 150, 5, 15);
		
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
				
				MeowKnight.moving = false;
				
				if (UP_Pressed)	MeowKnight.moveUP(5);
				if (DN_Pressed) MeowKnight.moveDN(10);
				if (LT_Pressed) MeowKnight.moveLT(10);
				if (RT_Pressed) MeowKnight.moveRT(10);
				
				
				//bad.chase(MeowKnight, 7);
				bad.evade(MeowKnight, 5);
				for (int i= 0; i<wall.length; i++) {
				
					if (MeowKnight.overlaps(wall[i])) MeowKnight.pushOutof(wall[i]);
					if (bad.overlaps(wall[i])) bad.pushOutof(wall[i]);
				
				}
				
				repaint();
				
				try {
					Thread.sleep(16);
				}
				catch(Exception x) {};
			}
		}
		
		public void update (Graphics g) {
			
			offScreenG.clearRect(0, 0, 2560, 1600);
			paint(offScreenG);
			g.drawImage(offScreenImg,0, 0, null);
		}

		
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			if (code == e.VK_UP) UP_Pressed = true;
			if (code == e.VK_DOWN) DN_Pressed = true;
			if (code == e.VK_LEFT) LT_Pressed = true;
			if (code == e.VK_RIGHT) RT_Pressed =  true;
			
			if (code == e.VK_P) {
				for (int i =0; i<wall.length; i++) {
					System.out.println("new Rec2(" + wall[i] +"),");
				}
			}
			System.out.println();
		}
		
		public void keyReleased( KeyEvent e){
			int code = e.getKeyCode();
			if (code == e.VK_UP) UP_Pressed = false;
			if (code == e.VK_DOWN) DN_Pressed = false;
			if (code == e.VK_LEFT) LT_Pressed = false;
			if (code == e.VK_RIGHT) RT_Pressed =  false;
			MeowKnight.still();
		}
		
		public void paint(Graphics g) {
			
			g.setColor(Color.black);
			
			if(MeowKnight.contains(mx, my)) g.setColor(Color.RED);
			
			g.drawImage(Grassbox, 0, 0, 1500, 900, null);
			//g.drawImage(animation.nextImage(), 100, 100, 200, 200, null);
			
			MeowKnight.draw(g);
			bad.draw(g);
			
			for(int i=0 ; i<wall.length;i++) {
				wall[i].draw(g);
			}
			
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
			for (int i= 0; i <wall.length; i++) {
				if (wall[i].contains(mx,my)) wall[i].grabbed();
				if (wall[i].resizer.contains(mx, my)) wall[i].resizer.grabbed();
			
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			for (int i= 0; i <wall.length; i++) {
				wall[i].dropped();
				wall[i].resizer.dropped();
			}
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
			for (int i = 0; i<wall.length;i++) {
				if (wall[i].held) wall[i].moveBy(dx, dy);
				if (wall[i].resizer.held) wall[i].resizeBy(dx,dy);
			}
			
			
			mx = nx;
			my = ny;
			
		}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}
		
}
