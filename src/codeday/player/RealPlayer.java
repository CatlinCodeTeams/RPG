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
			temp_x = temp.getReal_X()
		}
		try{
		switch(c){
		case 'a':
			if(Graphics.square_array[this.getX()+1][this.getY()]==null){
				this.x+=1;
			}
			break;
		case 'd':
		if(Graphics.square_array[this.getX()-1][this.getY()]==null){
			this.x-=1;
		}
		break;
		case 'w':
			if(Graphics.square_array[this.getX()][this.getY()-1]==null){
				this.y-=1;
			}
			break;
		case 's':
			if(Graphics.square_array[this.getX()][this.getY()+1]==null){
				this.y+=1;
			}
			break;
		}
		}catch(Exception e){}
	}
	
	public void draw(SimplestPen pen){
		Vector vec = this.draw_location.make_vector(new Point(this.x, this.y));
		vec.normalize();
		
		this.draw_location.move(vec);
	}

}
