package codeday.rpg.enemies;

import java.awt.image.BufferedImage;


public class Rat extends BasicEnemyIntelligence{
	BufferedImage image;
	public Rat(BufferedImage image, int in_x,int in_y){
		x = in_x;
		y = in_y;
		health = 10;
		damage = 2;
		speed = 1; 
		range = 1;
		this.image = image;
		
		
	}

}
