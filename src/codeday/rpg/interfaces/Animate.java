package codeday.rpg.interfaces;

public interface Animate extends Square{
	public int getHealth();
	public boolean takeDamage(int damage);
	public int getSpeed();
}
