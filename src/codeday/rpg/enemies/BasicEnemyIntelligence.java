package codeday.rpg.enemies;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
	public int getTrueX() {
		return x;
	}

	@Override
	public int getTrueY() {
		return y;
	}
	
	@Override
	public int getX() {
		return x * 40;
	}
	
	@Override
	public int getY() {
		return y * 40;
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
		Integer [] [] numberMap = new Integer [map.length] [map [0].length];
		boolean done = false;
		for (Square [] mapColumn : map) {
			for (Square mapCell : mapColumn) {
				if (mapCell instanceof Player) {
					numberMap [mapCell.getTrueX() / 40] [mapCell.getTrueY() / 40] = 0;
					distanceMap (mapCell, map, numberMap);
					done = true;
					break;
				}
			}
			if (done) {
				break;
			}
		}
		for (int n = 0; n < this.speed; n ++) {
			ArrayList<Square> possibleMoves = new ArrayList<Square> ();
			//start crap
			Square move = null;
			if (this.getTrueX() != 0) {
				move = map [this.getTrueX() - 1] [this.getTrueY()];
				if (move instanceof Walkable || move == null) {
					possibleMoves.add(move);
				}
			}
			if (this.getTrueX() != Graphics.mapWidth) {
				move = map [this.getTrueX() + 1] [this.getTrueY()];
				if (move instanceof Walkable || move == null) {
					possibleMoves.add(move);
				}
			}
			if (this.getTrueY() != 0) {
				move = map [this.getTrueX()] [this.getTrueY() - 1];
				if (move instanceof Walkable || move == null) {
					possibleMoves.add(move);
				}
			}
			if (this.getTrueX() != Graphics.mapLength) {
				move = map [this.getTrueX()] [this.getTrueY() + 1];
				if (move instanceof Walkable || move == null) {
					possibleMoves.add(move);
				}
			}
			//end crap
			if (!possibleMoves.isEmpty()) {
				Integer smallest = null;
				Square finalMove = null;
				for (Square option : possibleMoves) {
					if (numberMap [option.getTrueX()] [option.getTrueY()] < smallest || smallest == null) {
						smallest = numberMap [option.getTrueX()] [option.getTrueY()];
						finalMove = option;
					}
				}
				this.x = finalMove.getTrueX();
				this.y = finalMove.getTrueY();
			}
		}
	}

	private void distanceMap (Square square, Square [] [] map, Integer [] [] numberMap) {
		boolean [] available = new boolean [4];
		for (boolean bool : available) {
			bool = true;
			}
		//start crap
		if (square.getTrueX() == 0) {
			available [0] = false;
			}
		if (square.getTrueX() == Graphics.mapWidth) {
			available [1] = false;
			}
		if (square.getTrueY() == 0) {
			available[3] = false;
		}
		if (square.getTrueY() == Graphics.mapLength) {
			available [4] = false;
		}
		//end crap
		Square [] adjacents = new Square [4];
		for (int count = 0; count <= 3; count ++) {
			if (available [count]) {
				Square square2 = null;
				if (count == 0) {
					square2 = map [square.getTrueX() - 1] [square.getTrueY()];
				} else if (count == 1) {
					square2 = map [square.getTrueX() + 1] [square.getTrueY()];
				} else if (count == 2) {
					square2 = map [square.getTrueX()] [square.getTrueY() - 1];
				} else {
					square2 = map [square.getTrueX()] [square.getTrueY() + 1];
				}
				if ((square2 instanceof Walkable || square2 == null) && (numberMap [square2.getTrueX()] [square2.getTrueY()] == null || numberMap [square2.getTrueX()] [square2.getTrueY()] > numberMap [square.getTrueX()] [square.getTrueY()] + 1)) {
					numberMap [square2.getTrueX()] [square2.getTrueY()] = numberMap [square.getTrueX()] [square.getTrueY()] + 1;
					adjacents [count] = square2;
				}
			}
		}
		for (Square adjacent : adjacents) {
			distanceMap (adjacent, map, numberMap);
		}
	}
}
