import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MeowGame extends GameBase {

	// x,y, width, height
	Rect2 floor = new Rect2(70,879,1559,62);
	
	Rect2[] wall = {
		new Rect2(84,94,87,805),
		new Rect2(1499,98,68,801),
		new Rect2(100,350,1600,30),
	};
	
	Rect bad = new Rect (1000, 700, 30, 30);
	//Rect r2 = new Rect(200,200,30,30);
	
	Image Grassbox = Toolkit.getDefaultToolkit().getImage("Grassbox.png");
		
	String[] pose = {"Attack_1", "Attack_2", "Death", 
					"Dodge", "Idle", "IdleLeft", 
					"Jump","Reflect","Run", 
					"RunLeft","Take_Damage"};
		
	Sprite MeowKnight = new Sprite("Meow-Knight", pose, 150, 150, 5, 15);
		
	public void inGameLoop() {
			
		MeowKnight.moving = false;
				
		if (UP_Pressed)	MeowKnight.goUP(5);
		if (DN_Pressed) MeowKnight.goDN(10);
		if (LT_Pressed) MeowKnight.goLT(10);
		if (RT_Pressed) MeowKnight.goRT(10);
				
		MeowKnight.move();
				
		//bad.chase(MeowKnight, 7);
		bad.evade(MeowKnight, 5);
		for (int i= 0; i<wall.length; i++) {
				
			if (MeowKnight.overlaps(wall[i])) {
				MeowKnight.pushOutof(wall[i]);
			}
			if (bad.overlaps(wall[i])) {
				bad.pushOutof(wall[i]);
			}
				
		}
				
		if (MeowKnight.overlaps(floor))	{
			MeowKnight.pushOutof(floor);
		}
		if (bad.overlaps(floor)) {
			bad.pushOutof(floor);
		}
		
	}

	public void paint(Graphics g) {
		
		g.setColor(Color.black);
		
		if(MeowKnight.contains(mx, my)) g.setColor(Color.RED);
		
		g.drawImage(Grassbox, 0, 0, 1500, 900, null);
		
		MeowKnight.draw(g);
		bad.draw(g);
		
		floor.draw(g);
		
		for(int i=0 ; i<wall.length;i++) {
			wall[i].draw(g);
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		//pressed[e.getKeyCode()] = true;
		
		int code = e.getKeyCode();
		if (code == e.VK_UP) UP_Pressed = true;
		if (code == e.VK_DOWN) DN_Pressed = true;
		if (code == e.VK_LEFT) LT_Pressed = true;
		if (code == e.VK_RIGHT) RT_Pressed =  true;
		
		if (code == e.VK_P) {
			for (int i =0; i<wall.length; i++) {
				System.out.println("new Rect2(" + wall[i] +"),");
			}
			System.out.println("new Rect2(" + floor +")");
		}
		System.out.println();
	}
	
	public void keyReleased( KeyEvent e){
		
		//pressed[e.getKeyCode()] = false;
		
		int code = e.getKeyCode();
		if (code == e.VK_UP) UP_Pressed = false;
		if (code == e.VK_DOWN) DN_Pressed = false;
		if (code == e.VK_LEFT) LT_Pressed = false;
		if (code == e.VK_RIGHT) RT_Pressed =  false;
		MeowKnight.still();
	}
		
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mx = e.getX();
		my= e.getY();
		for (int i= 0; i <wall.length; i++) {
			if (wall[i].contains(mx,my)) wall[i].grabbed();
			if (wall[i].resizer.contains(mx, my)) wall[i].resizer.grabbed();
		}
		if (floor.contains(mx, my)) floor.grabbed();
		if (floor.resizer.contains(mx, my)) floor.resizer.grabbed();
	}
		
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	for (int i= 0; i <wall.length; i++) {
			wall[i].dropped();
			wall[i].resizer.dropped();
		}
		floor.dropped();
		floor.resizer.dropped();
	}
		
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
		
		if(floor.held) floor.moveBy(dx, dy);
		if(floor.resizer.held) floor.resizeBy(dx, dy);
		
		mx = nx;
		my = ny;
	}
	
}
