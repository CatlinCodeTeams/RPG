package codeday.walls;

import janus.engine.Point;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import codeday.rpg.interfaces.Animate;
import codeday.rpg.interfaces.NonWalkable;

public class Wall implements NonWalkable{

	private Point location;
	private BufferedImage image;

	public Wall(BufferedImage image, int x, int y){
		this.location = new Point(x,y);
		this.image = image;
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


	@Override
	public void trigger(Animate a) {
		// TODO Auto-generated method stub
		
	}

}
