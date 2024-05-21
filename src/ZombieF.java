
public class ZombieF extends Sprite {

	public static String[] pose = {"IdleLeft", "Idle", "WalkLeft", "Walk",
									"AttackLeft", "Attack", "DeathLeft", "Death"};
	
	public ZombieF(int x, int y) {
		super("Zombie-fm", pose, x, y, 5, 15);
	}
	//3/28
	//4/9
	//4/11

	public void attack() {
		
	}
	
	public void dodge(int dx) {
		
	}
}
