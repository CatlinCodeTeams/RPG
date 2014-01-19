package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.rpg.interfaces.Enemy;

public abstract class BasicEnemyIntelligence implements Enemy {
	int speed;
	int damage;
	int health;
	int range;
	int x;
	int y;
	BufferedImage image;

	@Override
	public int getAttack() {
		return damage;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
<<<<<<< HEAD
	public void takeDamage(int damage) {
		this.health -= damage;

=======
	public boolean takeDamage(int damage) {
		health -= damage;
		if (health <= 0) {
			return true;
		}
		return false;
>>>>>>> branch 'master' of https://github.com/CodeDayPortlandRPG/RPG.git
	}

	@Override
	public int getSpeed() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return this.speed;
=======
		return speed;
>>>>>>> branch 'master' of https://github.com/CodeDayPortlandRPG/RPG.git
	}

	@Override
	public int getX() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return this.x;
=======
		return x;
>>>>>>> branch 'master' of https://github.com/CodeDayPortlandRPG/RPG.git
	}

	@Override
	public int getY() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return this.y;
=======
		return y;
>>>>>>> branch 'master' of https://github.com/CodeDayPortlandRPG/RPG.git
	}

	@Override
	public BufferedImage getMyImage() {
		return image;
	}

	@Override
	public boolean drawBackground() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
=======
>>>>>>> branch 'master' of https://github.com/CodeDayPortlandRPG/RPG.git
		return true;
	}

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub

	}
	
	private void die() {
	
	}

}
