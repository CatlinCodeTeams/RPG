

package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.rpg.enemies.BasicEnemyIntelligence;

public class Sword_Skeleton extends BasicEnemyIntelligence{
	public Sword_Skeleton(int in_x,int in_y){
		x = in_x;
		y = in_y;
		health = 30;
		damage = 6;
		speed = 1; 
		range = 1;
		
	}

}
