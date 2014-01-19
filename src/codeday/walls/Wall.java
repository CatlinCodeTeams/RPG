package codeday.walls;

import janus.engine.Point;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import codeday.rpg.interfaces.NonWalkable;

public class Wall implements NonWalkable{

	private Point location;
	private BufferedImage image;

	public Wall(int x, int y){
		this.location = new Point(x,y);
	}
	
	
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
		return this.image;
	}

	@Override
	public boolean drawBackground() {
		// TODO Auto-generated method stub
		return false;
	}

}
