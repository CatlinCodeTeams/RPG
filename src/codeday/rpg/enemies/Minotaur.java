<<<<<<< HEAD
package codeday.rpg.enemies;

public class Minotaur {

}
=======
package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.rpg.enemies.BasicEnemyIntelligence;

public class Minotaur extends BasicEnemyIntelligence{
	public Minotaur(int in_x,int in_y){
		x = in_x;
		y = in_y;
		health = 50;
		damage = 15;
		speed = 1; 
		range = 1;
		
	}

}
>>>>>>> branch 'master' of https://github.com/CodeDayPortlandRPG/RPG.git
