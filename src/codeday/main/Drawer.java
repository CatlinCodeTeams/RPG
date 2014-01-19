package codeday.main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import codeday.rpg.interfaces.Enemy;
import codeday.rpg.interfaces.Square;
import codeday.walls.Wall;

public class Drawer {
	
	BufferedImage image;

	public Drawer(BufferedImage background_image){
		
		image = background_image;
	}
	

	public void draw(){

		//draw_grid();
		for(Enemy e:Graphics.en){
			Graphics.pen.drawImage(e.getMyImage(), e.getX()*40, e.getY()*40, 40, 40,0);
		}
		Graphics.pen.setColor(new Color(255,255,255));

		
		int x=-1;
		for (Square[] q2: Graphics.square_array){
			x++;
			int y=-1;
			for (Square q: q2){
				y++;
				if ((q !=null)&&(q.getMyImage()!=null)){
					
					
					if (q.drawBackground()){
						Graphics.pen.drawImage("stone_tile.png", q.getX(), q.getY(), 40, 40, 0);
					}


					Graphics.pen.drawImage(q.getMyImage(), q.getX(), q.getY(), 40, 40, 0);
					

				}
				else{
					Graphics.pen.drawImage("stone_tile.png", x*40, y*40, 40, 40, 0);
				}

			}

		}
		Graphics.pen.drawImage(Graphics.p.getMyImage(), Graphics.p.getX(), Graphics.p.getY(), 40, 40, 0);
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
