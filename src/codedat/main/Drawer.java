package codedat.main;

import java.awt.image.BufferedImage;

import codeday.rpg.interfaces.Square;

public class Drawer {
	
	BufferedImage image;

	public Drawer(BufferedImage background_image){
		
		image = background_image;
	}
	

	public void draw(){
		
		draw_grid();
		
		for (Square q: Main.square_list){
			BufferedImage image = q.getMyImage();
			
			if (q.drawBackground()){
				Main.pen.simplePen.drawImage(this.image, q.getX(), q.getY(), 40, 40, null);
			}
			
			Main.pen.simplePen.drawImage(image, q.getX(), q.getY(), 40, 40, null);
		}
	
	}
	
	public void draw_grid(){
		for (int x=0; x<40; x++){
			Main.pen.drawLine(x*40, 0, x*40, 600);
		}
		
		for (int y=0; y<30; y++){
			Main.pen.drawLine(0, y*40, 800, y*40);
		}
	}
	
}
