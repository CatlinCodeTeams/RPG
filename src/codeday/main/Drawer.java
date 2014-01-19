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
		for (Square[] q2: Graphics.square_array){
			for (Square q: q2){
			
				if (q !=null){
				
				if (q.drawBackground()){
					Graphics.pen.drawImage(this.image, q.getX(), q.getY(), 40, 40, 0);
				}
				
				Graphics.pen.drawImage(q.getMyImage(), q.getX(), q.getY(), 40, 40, 0);
				
				}
				
				}
				
			}
		
		for (int x=0; x<40; x++)
			for (int y=0; y<30; y++){
				
				if (Graphics.square_array[x][y]==null)
					Graphics.pen.drawImage(this.image, x*40, y*40, 40, 40, 0);
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
