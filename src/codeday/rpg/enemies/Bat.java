package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.rpg.enemies.BasicEnemyIntelligence;

public class Bat extends BasicEnemyIntelligence{
int x;
int y;
int life;
int dam;
int speed;
int range;
	public Bat(int in_x,int in_y){
		x = in_x;
		y = in_y;
		life = 1;
		dam = 2;
		speed = 2; 
		range = 1;
		
	}

}
