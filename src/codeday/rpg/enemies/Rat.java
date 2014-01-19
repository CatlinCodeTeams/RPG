package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.main.Graphics;


public class Rat extends BasicEnemyIntelligence{
	BufferedImage image;
	public Rat(int in_x,int in_y){
		x = in_x;
		y = in_y;
		health = 10;
		damage = 2;
		speed = 1; 
		range = 1;
		image = Graphics.img.get("spr_rat_down2"); 
		
		
	}

}
