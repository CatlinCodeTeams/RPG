package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.rpg.enemies.BasicEnemyIntelligence;

public class Rat extends BasicEnemyIntelligence{
int x;
int y;
int life;
int dam;
int speed;
int range;
	public Rat(int in_x,int in_y){
		x = in_x;
		y = in_y;
		life = 10;
		dam = 2;
		speed = 1; 
		range = 1;
		
	}

}
