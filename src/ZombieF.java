
public class ZombieF extends Sprite {

	public static String[] pose = {"Idleleft", "Idle", "WalkLeft", "Walk",
									"AttackLeft", "Attack", "DeadLeft", "Dead"};
	
	public ZombieF(int x, int y) {
		super("Zombie-fm", pose, x, y, 5, 15);
	}
	
}
