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

	@Override
	public int getAttack() {
		return damage;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public void takeDamage(int damage) {
		this.health -= damage;

	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return this.speed;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public BufferedImage getMyImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean drawBackground() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub

	}

}
