<<<<<<< HEAD
package codeday.rpg.enemies;

public class Bow_Skeleton {

}
=======
package codeday.rpg.enemies;

import java.awt.image.BufferedImage;

import codeday.rpg.enemies.BasicEnemyIntelligence;

public class Bow_Skeleton extends BasicEnemyIntelligence{
	public Bow_Skeleton(int in_x,int in_y){
		x = in_x;
		y = in_y;
		health = 15;
		damage = 4;
		speed = 1; 
		range = 5;
		
	}

}
>>>>>>> branch 'master' of https://github.com/CodeDayPortlandRPG/RPG.git
