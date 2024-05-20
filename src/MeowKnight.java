
public class MeowKnight extends Sprite {

	public static String[] pose = {"IdleLeft", "Idle", "RunLeft", "Run",
					"Attack_1","Attack_1Left","DeathLeft", "Death",
					"Take_DamageLeft", "Take_Damage", "Attack_2Left","Attack_2",
					"DodgeLeft", "Dodge", "JumpLeft","Jump",
					"ReflectLeft","Reflect"};
	
	public MeowKnight(int x, int y) {
		super("Meow-Knight", pose, x, y, 5, 15);
	}

}
