package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.rpg.enemies.BasicEnemyIntelligence;

public class Sword_Skeleton extends BasicEnemyIntelligence{
int x;
int y;
int life;
int dam;
int speed;
int range;
	public Sword_Skeleton(int in_x,int in_y){
		x = in_x;
		y = in_y;
		life = 30;
		dam = 6;
		speed = 1; 
		range = 1;
		
	}

}
