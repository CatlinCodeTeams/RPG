package codeday.main;

import java.awt.Color;
import java.awt.image.BufferedImage;

import codeday.rpg.interfaces.Square;

public class Drawer {
	
	BufferedImage image;

	public Drawer(BufferedImage background_image){
		
		image = background_image;
	}
	

	public void draw(){
		
		draw_grid();
		
		Graphics.pen.setColor(new Color(255,255,255));
		
		for (Square q: Graphics.square_list){
			
			BufferedImage image = q.getMyImage();
			
			if (q.drawBackground()){
				Graphics.pen.simplePen.drawImage(this.image, q.getX(), q.getY(), 40, 40, null);
			}
			
			Graphics.pen.simplePen.drawImage(image, q.getX(), q.getY(), 40, 40, null);
		}
	
	}
	
	public void draw_grid(){
		for (int x=0; x<40; x++){
			Graphics.pen.drawLine(40*x, 0, 40*x, 600);
		}
		for (int y=0; y<30; y++){
			Graphics.pen.drawLine(0, 40*y, 800, 40*y);
			}
	}
	
}
