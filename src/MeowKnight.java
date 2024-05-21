import java.awt.Graphics;

public class MeowKnight extends Sprite {

	public static String[] pose = {"IdleLeft", "Idle", 
									"RunLeft", "Run",
									"AttackLeft_1","Attack_1",
									"DeathLeft", "Death",
									"Take_DamageLeft", "Take_Damage", 
									"AttackLeft_2","Attack_2",
									"DodgeLeft", "Dodge", 
									"JumpLeft","Jump",
									"ReflectLeft","Reflect"};
	
	public MeowKnight(int x, int y) {
		super("Meow-Knight", pose, x, y, 5, 10);
	}

	public void attack() {
		if (facingleft)action = 4;
		else action = 5;
		
		moving = true;
		Rect slash = new Rect2 (x, y, 80, 30);
	}
	
	public void attack2() {
		if (facingleft)action = 10;
		else action = 11;
		
		moving = true;
	}
	
	public void dodge(int dx) {
		if (facingleft) { 
			super.goLT(dx);
			action =12;
		}
		else {
			super.goRT(dx);
			action = 13;
		}
		moving = true;
	}
	
	/*public void draw(Graphics g) {
		super.draw(g);
	}*/
}
