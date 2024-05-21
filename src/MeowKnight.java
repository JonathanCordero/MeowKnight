import java.awt.Color;
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
	
	private int health;
    private int maxHealth;
    private boolean hasStartedMoving; 
    
	public MeowKnight(int x, int y) {
		super("Meow-Knight", pose, x, y, 5, 10);
		hasStartedMoving = false;
        this.maxHealth = 100;
        this.health = this.maxHealth;
	}

	public void attack() {
		if (facingleft)action = 4;
		else action = 5;
		
		moving = true;
		hasStartedMoving = true;
		Rect slash = new Rect2 (x, y, 80, 30);
	}
	
	public void attack2() {
		if (facingleft)action = 10;
		else action = 11;
		
		moving = true;
		hasStartedMoving = true;
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
		hasStartedMoving = true;
	}
	  public void takeDamage(int damage) {
	        this.health -= damage;
	        if (this.health < 0) {
	            this.health = 0;
	            // handle death
	        }
	    }
	  
	    public void heal(int amount) {
	        this.health += amount;
	        if (this.health > this.maxHealth) {
	            this.health = this.maxHealth;
	        }
	    }
	    
	    @Override
	    public void goLT(int dx) {
	        super.goLT(dx);
	        hasStartedMoving = true; // Set flag when moving
	    }

	    @Override
	    public void goRT(int dx) {
	        super.goRT(dx);
	        hasStartedMoving = true; // Set flag when moving
	    }

	    @Override
	    public void goUP(int dy) {
	        super.goUP(dy);
	        hasStartedMoving = true; // Set flag when moving
	    }
	    
	    public boolean hasStartedMoving() {
	        return hasStartedMoving;
	    }
	
	    public void draw(Graphics g) {
	        super.draw(g);
	        drawHealthBar(g);
	    }

	    private void drawHealthBar(Graphics g) {
	        int barWidth = 50;
	        int barHeight = 5;
	        int barX = x + (w - barWidth) / 2;
	        int barY = y - barHeight - 5; // Position the bar above the character

	        g.setColor(Color.RED);
	        g.fillRect(barX, barY, barWidth, barHeight);

	        g.setColor(Color.GREEN);
	        g.fillRect(barX, barY, (int) ((barWidth * health) / (double) maxHealth), barHeight);

	        g.setColor(Color.BLACK);
	        g.drawRect(barX, barY, barWidth, barHeight);
	    }
	/*public void draw(Graphics g) {
		super.draw(g);
	}*/
}
