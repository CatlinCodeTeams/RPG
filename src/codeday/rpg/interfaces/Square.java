package codeday.rpg.interfaces;

import java.awt.image.BufferedImage;

public interface Square {
	//returns x in array
	public int getTrueX();
	//returns y in array
	public int getTrueY();
	//returns x in array
	public int getX();
	//returns y in array
	public int getY();
	//returns Buffred Image
	public BufferedImage getMyImage();
	//returns whether to draw background
	public boolean drawBackground();
}
