package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.rpg.enemies.BasicEnemyIntelligence;

public class Minotaur extends BasicEnemyIntelligence{
int x;
int y;
int life;
int dam;
int speed;
int range;
	public Minotaur(int in_x,int in_y){
		x = in_x;
		y = in_y;
		life = 50;
		dam = 15;
		speed = 1; 
		range = 1;
		
	}

}
