import java.awt.Graphics;

public class MeowKnight extends Sprite {

	public static String[] pose = {"IdleLeft", "Idle", "RunLeft", "Run",
									"AttackLeft_1","Attack_1","DeathLeft", "Death",
									"Take_DamageLeft", "Take_Damage", "AttackLeft_2","Attack_2",
									"DodgeLeft", "Dodge", "JumpLeft","Jump",
									"ReflectLeft","Reflect"};
	
	public MeowKnight(int x, int y) {
		super("Meow-Knight", pose, x, y, 5, 15);
	}

	public void attack() {
		if (facingleft)action = 4;
		else action = 5;
		
		moving = true;
		Rect slash = new Rect (x, y, 80, 30);
	}
	
	/*public void draw(Graphics g) {
		super.draw(g);
	}*/
}
