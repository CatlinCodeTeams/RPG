package codeday.main;

import java.util.List;

import codeday.rpg.interfaces.Enemy;
import codeday.rpg.interfaces.Player;

public class TurnManager {
	public boolean running=false;
	public Player player;
	public List<Enemy> enimies;
	public TurnManager(Player p,List<Enemy> es){
		player=p;
		enimies=es;
	}
	public void input(char input){
		if(!running){
			running=true;
			player.charInput(input);
			for(Enemy e: enimies){
				//e.takeTurn();
			}
			running=false;
		}
	}
}
