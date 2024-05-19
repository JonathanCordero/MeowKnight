import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Area2 extends Area {
	
	/* New Image here.*/Image Grassbox = Toolkit.getDefaultToolkit().getImage("Grassbox.png");

	public Area2(boolean[] pressed) {
		super(pressed,  "oak_woods_Area2.png");
	}
	
	public void inGameLoop() {
		
		if (pressed[UP]) MeowKnight.goUP(5);
		if (pressed[DN]) MeowKnight.goDN(10);
		if (pressed[LT]) MeowKnight.goLT(10);
		if (pressed[RT]) MeowKnight.goRT(10);
				
		MeowKnight.move();
		
	}

	public void paint(Graphics g) {
		g.drawImage(Grassbox, 0, 0, 1500, 900, null);
		MeowKnight.draw(g);
	}

}
