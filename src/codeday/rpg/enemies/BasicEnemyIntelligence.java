package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.main.Graphics;
import codeday.rpg.interfaces.Enemy;
import codeday.rpg.interfaces.Square;

public abstract class BasicEnemyIntelligence implements Enemy {
	int speed;
	int damage;
	int health;
	int range;
	int x;
	int y;
<<<<<<< HEAD
	int strength;
=======
	int streanth;
>>>>>>> ec96287ef8950cfd12fbd4184aa05a4992f5f7db
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
		int [] [] map = int [width] [length];

	}
	
	private void die() {
	
	}
	
	public boolean isDead () {
		if (health <= 0) {
			return true;
		}
		return false;
	}
	public int getStrenth(){
		return streanth;
	}

	private Square [] distanceMap (Square square) {
		boolean [] [] available = new boolean [3] [3];
		for (int countX = 0; countX <= 2; countX ++) {
			for (int countY = 0; countY <= 2; countY ++) {
				available[countX] [countY] = true;
			}
		}
		//start crap
		available [1] [1] = false;
		if (square.getX() == 0) {
			for (int count = 0; count <= 2; count ++) {
				available [0] [count] = false;
			}
		}
		if (square.getX() == Graphics.mapWidth) {
			for (int count = 0; count <= 2; count ++) {
				available [Graphics.mapWidth] [count] = false;
			}
		}
		if (square.getY() == 0) {
			for (int count = 0; count <= 2; count ++) {
				available [count] [0] = false;
			}
		}
		if (square.getY() == Graphics.mapLength) {
			for (int count = 0; count <= 2; count ++) {
				available [count] [Graphics.mapLength] = false;
			}
		}
		//end crap
		Square [] adjacents = new Square [8];
		int indexCount = 0;
		for (int countX = 0; countX <= 2; countX ++) {
			for (int countY = 0; countY <= 2; countY ++) {
				if (available [countX] [countY]) {
					adjacents [indexCount] = 
				}
			}
		}
	}
}
