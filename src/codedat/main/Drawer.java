package codedat.main;

import java.awt.image.BufferedImage;

import codeday.rpg.interfaces.Square;

public class Drawer {


	public void draw(){
		for (Square q: Main.square_list){
			BufferedImage image = q.getMyImage();
			Main.pen.simplePen.drawImage(image, q.getX(), q.getY(), 40, 40, null);
		}
	
	}
	
}
