package codeday.rpg.enemies;

import java.awt.image.BufferedImage;
import codeday.rpg.interfaces.*;

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
	int strength;
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
		Square [] [] map = Graphics.square_array;
		//attack shit
		move (map);
		
		

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
		return strength;
	}
	
	private void move (Square [] [] map) {
		Integer [] [] numberMap = new Integer [Graphics.mapWidth] [Graphics.mapLength];
		boolean done = false;
		for (Square [] mapColumn : map) {
			for (Square mapCell : mapColumn) {
				if (mapCell instanceof Player) {
					numberMap [mapCell.getX()] [mapCell.getY()] = 0;
					distanceMap (mapCell, map, numberMap);
					done = true;
					break;
				}
			}
			if (done) {
				break;
			}
		}
	}

	private void distanceMap (Square square, Square [] [] map, Integer [] [] numberMap) {
		boolean [] available = new boolean [4];
		for (boolean bool : available) {
			bool = true;
			}
		//start crap
		if (square.getX() == 0) {
			available [0] = false;
			}
		if (square.getX() == Graphics.mapWidth) {
			available [1] = false;
			}
		if (square.getY() == 0) {
			available[3] = false;
		}
		if (square.getY() == Graphics.mapLength) {
			available [4] = false;
		}
		//end crap
		Square [] adjacents = new Square [4];
		for (int count = 0; count <= 3; count ++) {
			if (available [count]) {
				if (count == 0) {
					Square square2 = map [square.getX() - 1] [square.getY()];
				}
				if (count == 1) {
					Square square2 = map [square.getX() + 1] [square.getY()];
				}
				if (count == 2) {
					Square square2 = map [square.getX()] [square.getY() - 1];
				}
				if (count == 3) {
					Square square2 = map [square.getX()] [square.getY() + 1];
				}
				if ((square2 instanceof Walkable || square2 == null) && (numberMap [square2.getX()] [square2.getY()] == null || numberMap [square2.getX()] [square2.getY()] > numberMap [square.getX()] [square.getY()] + 1)) {
					numberMap [square2.getX()] [square2.getY()] = numberMap [square.getX()] [square.getY()] + 1;
					adjacents [count] = square2;
				}
			}
		}
		for (Square adjacent : adjacents) {
			distanceMap (adjacent, map, numberMap);
		}
	}
}
