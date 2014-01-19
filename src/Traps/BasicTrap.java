package Traps;

import java.awt.image.BufferedImage;

import codeday.main.Graphics;
import codeday.rpg.interfaces.Inanimate;
import codeday.rpg.interfaces.Square;

public abstract class BasicTrap implements Inanimate {
	int damage;
	int x;
	int y;
	BufferedImage image;
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public BufferedImage getMyImage() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public boolean drawBackground() {
		// TODO Auto-generated method stub
		return true;
	}
}