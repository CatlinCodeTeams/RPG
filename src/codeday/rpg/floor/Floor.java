package codeday.rpg.floor;

import java.awt.image.BufferedImage;

import codeday.rpg.interfaces.Animate;
import codeday.rpg.interfaces.Walkable;

public class Floor implements Walkable {
	int x;
	int y;
	BufferedImage image;
	
	public Floor (int xGiven, int yGiven) {
		x = xGiven;
		y = yGiven;
	}

	@Override
	public void trigger(Animate a) {
		// TODO Auto-generated method stub

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

}
