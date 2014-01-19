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
		// TODO Auto-generated method stub

	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BufferedImage getMyImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean drawBackground() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub

	}

}
