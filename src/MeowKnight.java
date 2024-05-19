
public class MeowKnight extends Sprite {

	public static String[] pose = {"Attack_1", "Attack_2", "Death", 
			"Dodge", "Idle", "IdleLeft", 
			"Jump","Reflect","Run", 
			"RunLeft","Take_Damage"};
	
	public MeowKnight(int x, int y) {
		super("Meow-Knight", pose, x, y, 5, 15);
	}

}
