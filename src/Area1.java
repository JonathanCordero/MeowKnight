import java.awt.*;

public class Area1 extends Area {
	
	Rect2 floor = new Rect2(363,919,1075,37);
	
	Rect2[] platform = {
		new Rect2(378,664,247,20),
		new Rect2(879,664,247,20),
		new Rect2(1120,459,247,20),
	};
	Rect2[] land = {
		new Rect2(-88,170,87,805),
		new Rect2(1,836,361,119),
		new Rect2(1612,829,317,26),
	};
	
	Rect2[] hill = {
		new Rect2(1418,906,109,99),
		new Rect2(1460,879,90,65),
		new Rect2(1503,853,90,65),
		new Rect2(1554,829,90,65),
	};
	
	Foe zombieBad = new Foe(400, 200);

	public Area1( boolean[] pressed) {
		super(pressed, "oak_woods_Area1.png");
	}
	
	public void inGameLoop() {
		
		if (pressed[UP]) MeowKnight.goUP(10);
		if (pressed[DN]) MeowKnight.goDN(10);
		if (pressed[LT]) MeowKnight.goLT(10);
		if (pressed[RT]) MeowKnight.goRT(10);
		if (pressed[A]) MeowKnight.attack();
				
		MeowKnight.move();
		
//		bad.evade(MeowKnight, 5);
		zombieBad.evade(MeowKnight,4);
		for (int i= 0; i<land.length; i++) {
				
			if (MeowKnight.overlaps(land[i])) {
				MeowKnight.pushOutof(land[i]);
			}
			if (zombieBad.overlaps(land[i])) {
				zombieBad.pushOutof(land[i]);
			}
				
		}
		
		for (int i=0; i<platform.length; i++) {
			if (MeowKnight.overlaps(platform[i])){
				if (MeowKnight.cameFromAbove(platform[i])) {
					MeowKnight.pushBackAbove(platform[i]);
					MeowKnight.vx *= MeowKnight.F;
				}
				if (zombieBad.cameFromAbove(platform[i])) {
					zombieBad.pushBackAbove(platform[i]);
					zombieBad.vx *= MeowKnight.F;
				}
			}
		}
		
		for (int i=0; i<hill.length; i++) {
			if (MeowKnight.overlaps(hill[i])) {
				if(MeowKnight.cameFromAbove(hill[i]) || MeowKnight.cameFromleft(hill[i])) {
					MeowKnight.pushBackAbove(hill[i]);
					MeowKnight.vx *= MeowKnight.F;
				}
			}
			if (zombieBad.overlaps(hill[i])) {
				if(zombieBad.cameFromAbove(hill[i]) || zombieBad.cameFromleft(hill[i])) {
					zombieBad.pushBackAbove(hill[i]);
					zombieBad.vx *= MeowKnight.F;
				}
			}
		}
				
		if (MeowKnight.overlaps(floor))	{
			//MeowKnight.x = 1800-30; teleport across screen. or shouldnt have put this on the floor.
			//if (MeowKnight.x 1950) MeowKnight.x = -50 and so on.
			MeowKnight.pushOutof(floor);
		}
		if (zombieBad.overlaps(floor)) {
			zombieBad.pushOutof(floor);
		}
		
		if (MeowKnight.x > 1920) {
			MeowKnight.x = 0;
			MeowKnight.y = 645;
			Area.setCurrentAreaTo(2);
		}
				
		//bad.chase(MeowKnight, 7);
		
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		background.draw(g);
		
		MeowKnight.draw(g);
		zombieBad.draw(g);
		
		floor.draw(g);
		
		for(int i=0 ; i<land.length;i++) {
			land[i].draw(g);
		}
		
		for(int i=0; i<hill.length; i++) {
			hill[i].draw(g);
		}
		
		for (int i=0; i<platform.length; i++) {
			platform[i].draw(g);
		}
	}

}
