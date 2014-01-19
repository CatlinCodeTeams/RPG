package codeday.player;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

import codeday.rpg.interfaces.Player;
import codeday.rpg.resource.sprites.FileLoader;
public class RealPlayer implements Player{
	BufferedImage defualt;
	int health=20;
	int x;
	int y;
	public RealPlayer(int x,int y){
		this.x=x;
		this.y=y;
		try {
			this.defualt=ImageIO.read(new File(FileLoader.class.getResource("spr_main.png").toURI()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int getAttack() {
		return 3;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public boolean takeDamage(int damage) {
		health-=damage;
		return health>0;
	}

	@Override
	public int getSpeed() {
		return 1;
	}

	@Override
	public boolean isDead() {
		return health>0;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public BufferedImage getMyImage() {
		return null;
	}

	@Override
	public boolean drawBackground() {
		return false;
	}

	@Override
	public void charInput(char c) {
		//AI goes here
	}

}
