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
	public boolean takeDamage(int damage) {
		health -= damage;
		if (health <= 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public BufferedImage getMyImage() {
		return image;
	}

	@Override
	public boolean drawBackground() {
		return true;
	}

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub

	}
	
	private void die() {
	
	}

}
