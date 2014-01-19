package codedat.main;

import java.awt.image.BufferedImage;

import codeday.rpg.interfaces.Square;

public class Drawer {
	
	BufferedImage image;

	public Drawer(BufferedImage background_image){
		
		image = background_image;
	}
	

	public void draw(){
		for (Square q: Main.square_list){
			BufferedImage image = q.getMyImage();
			
			if (q.drawBackground()){
				Main.pen.simplePen.drawImage(this.image, q.getX(), q.getY(), 40, 40, null);
			}
			
			Main.pen.simplePen.drawImage(image, q.getX(), q.getY(), 40, 40, null);
		}
	
	}
	
}
