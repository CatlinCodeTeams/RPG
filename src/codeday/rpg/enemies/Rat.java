package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.rpg.interfaces.Enemy;

public class Rat implements Enemy{
int x;
int y;
int life;
int dam;
int speed;
	public Rat(int x,int y){
		x = x;
		y = y;
		life = 10;
		dam = 5;
		speed = 1; 
		
		
	}
	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return this.dam;
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
