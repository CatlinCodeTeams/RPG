package codeday.rpg.interfaces;

public interface Animate extends Square{
	public int getHealth();
	public void takeDamage(int damage);
	public int getSpeed();
}
