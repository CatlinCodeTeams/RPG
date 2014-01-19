
package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.rpg.enemies.BasicEnemyIntelligence;

public class Bat extends BasicEnemyIntelligence{
	public Bat(int in_x,int in_y){
		x = in_x;
		y = in_y;
		health = 1;
		damage = 2;
		speed = 2; 
		range = 1;
		
	}

}