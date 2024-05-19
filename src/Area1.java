import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Area1 extends Area {
	
	
	Rect2 floor = new Rect2(363,919,1075,37);
	
	Rect2[] platform = {
			
	};
	Rect2[] land = {
		new Rect2(84,94,87,805),
		new Rect2(1,836,361,119),
		new Rect2(378,664,247,20),
		new Rect2(879,664,247,20),
		new Rect2(1120,459,247,20),
		new Rect2(1612,829,317,26),
	};
	
	Rect2[] hill = {
			new Rect2(1438,911,17,50),
	};
	
	Rect bad = new Rect (1000, 700, 30, 30);

	public Area1( boolean[] pressed) {
		super(pressed, "oak_woods_Area1.png");
		
		
	}
	
	public void inGameLoop() {
		
		if (pressed[UP]) MeowKnight.goUP(10);
		if (pressed[DN]) MeowKnight.goDN(10);
		if (pressed[LT]) MeowKnight.goLT(10);
		if (pressed[RT]) MeowKnight.goRT(10);
				
		MeowKnight.move();
		
		bad.evade(MeowKnight, 5);
		for (int i= 0; i<land.length; i++) {
				
			if (MeowKnight.overlaps(land[i])) {
				MeowKnight.pushOutof(land[i]);
			}
			if (bad.overlaps(land[i])) {
				bad.pushOutof(land[i]);
			}
				
		}
				
		if (MeowKnight.overlaps(floor))	{
			//MeowKnight.x = 1800-30; teleport across screen. or shouldnt have put this on the floor.
			//if (MeowKnight.x 1950) MeowKnight.x = -50 and so on.
			MeowKnight.pushOutof(floor);
		}
		if (bad.overlaps(floor)) {
			bad.pushOutof(floor);
		}
				
		//bad.chase(MeowKnight, 7);
		
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		background.draw(g);
		
		MeowKnight.draw(g);
		bad.draw(g);
		
		floor.draw(g);
		
		for(int i=0 ; i<land.length;i++) {
			land[i].draw(g);
		}
		
		for(int i=0; i<hill.length; i++) {
			hill[i].draw(g);
		}
	}

}
