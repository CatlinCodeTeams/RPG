package codeday.rpg.enemies;


public class Rat extends BasicEnemyIntelligence{
	public Rat(int in_x,int in_y){
		x = in_x;
		y = in_y;
		health = 10;
		damage = 2;
		speed = 1; 
		range = 1;
		
	}

}
