package codeday.rpg.interfaces;

public interface Enemy extends Attacker{
	public void takeTurn();
	//Between 1-5
	public int getStrenth();
}
