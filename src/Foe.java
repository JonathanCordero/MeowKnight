
public class Foe extends Sprite {

	public static String[] pose = {"IdleLeft", "Idle", "WalkLeft", "Walk",
									"AttackLeft", "Attack", "DeathLeft", "Death"};
	
	public Foe(int x, int y) {
		super("Zombie", pose, x, y, 5, 15);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
}
