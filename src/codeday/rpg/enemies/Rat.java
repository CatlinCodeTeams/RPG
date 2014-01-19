package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.rpg.interfaces.Enemy;

public class Rat implements Enemy{

	public Rat(int x,int y){
		int life = 10;
		int dam = 10;
		
		
	}
	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return this.life;
	}

	@Override
	public void takeDamage(int damage) {
		this.life -= damage;
		
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
