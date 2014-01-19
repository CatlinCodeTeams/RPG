package codeday.walls;

import janus.engine.Point;

import java.awt.image.BufferedImage;

import codeday.rpg.interfaces.NonWalkable;

public class Wall implements NonWalkable{

	private Point location;
	private BufferedImage image;
	
	@Override
	public int getX() {
		return (int)location.x;
	}

	@Override
	public int getY() {
		return (int)location.y;
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

}
