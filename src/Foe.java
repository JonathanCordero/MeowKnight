
public class Foe extends Sprite{
	public static String[] pose = {"Attack", "Idle", "Walk", "Death"};
	
	public Foe(int x, int y) {
		super("Zombie_", pose, x, y, 5, 15);
	}
	
	
}
