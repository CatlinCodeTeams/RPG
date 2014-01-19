package Traps;

import java.awt.image.BufferedImage;

import codeday.rpg.interfaces.Animate;

public class Fire_Trap extends BasicTrap{

	public Fire_Trap(int in_x, int in_y){
		x = in_x;
		y = in_y;
		damage = 5;
	}

	@Override
	public void trigger(Animate a) {
		a.takeDamage(damage);
		
	}

	
	
}
