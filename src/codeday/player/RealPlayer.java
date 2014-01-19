package codeday.player;

import janus.engine.Point;
import janus.engine.Vector;
import janus.engine.pens.SimplestPen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

import codeday.main.Graphics;
import codeday.rpg.interfaces.Enemy;
import codeday.rpg.interfaces.Player;
import codeday.rpg.resource.sprites.FileLoader;
public class RealPlayer implements Player{
	BufferedImage defualt;
	int health=20;
	int damage=5;
	int x;
	int y;
	
	Point draw_location;
	
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
		return this.damage;
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
		boolean attack_mode = false;
		for (int count = 0; count < Graphics.en.size(); count ++){
			Enemy temp = Graphics.en.get(count);
			int temp_x = temp.getX();
		}
		
		if ((c == 'a')&&(Graphics.square_array[this.getX()/40-1][this.getY()/40]==null)){
			this.x -=40;
		}
		if ((c=='d')&&(Graphics.square_array[this.getX()/40+1][this.getY()/40]==null)){
			this.x+=40;
		}
		if ((c=='w')&&(Graphics.square_array[this.getX()/40][this.getY()/40-1]==null)){
			this.y-=40;
		}
		if ((c=='s')&&(Graphics.square_array[this.getX()/40][this.getY()/40+1]==null)){
			this.y+=40;
		}
		
		
	}
	
	public void draw(SimplestPen pen){
		Vector vec = this.draw_location.make_vector(new Point(this.x, this.y));
		vec.normalize();
		
		this.draw_location.move(vec);
	}

}
