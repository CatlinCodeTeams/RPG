package codeday.player;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

import codeday.main.Graphics;
import codeday.rpg.interfaces.Player;
import codeday.rpg.resource.sprites.FileLoader;
public class RealPlayer implements Player{
	BufferedImage defualt;
	int health=20;
	int x;
	int y;
	BufferedImage image;
	public RealPlayer(BufferedImage image, int x,int y){
		
		this.image = image;
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
		return this.image;
	}

	@Override
	public boolean drawBackground() {
		return true;
	}

	@Override
	public void charInput(char c) {
		if ((c=='a')&&(Graphics.square_array[this.getX()/40-1][getY()/40]==null)){
			this.x-=40;
		}
		else if ((c=='d')&&(Graphics.square_array[this.getX()/40+1][getY()/40]==null)){
			this.x+=40;
		}
		else if ((c=='w')&&(Graphics.square_array[this.getX()/40][getY()/40-1]==null)){
			this.y-=40;
		}
		else if ((c=='s')&&(Graphics.square_array[this.getX()/40][getY()/40+1]==null)){
			this.y+=40;
		}
	}

}
