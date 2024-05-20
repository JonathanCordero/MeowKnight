
public class Foe extends Sprite {

	public static String[] pose = {"Idleleft", "Idle", "WalkLeft", "Walk",
					"AttackLeft", "Attack", "DeadLeft", "Dead"};
	
	public Foe(int x, int y) {
		super("Zombie", pose, x, y, 5, 15);
	}
	
}
