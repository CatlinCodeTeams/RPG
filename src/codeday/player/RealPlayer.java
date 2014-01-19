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
	int _top_;
	int _right_;
	int _down_;
	int _left_;
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
<<<<<<< HEAD
		for (int count = 0; count < Graphics.en.size(); count ++){
			Enemy temp = Graphics.en.get(count);
			int temp_x = temp.getX();
=======
		int play_x = this.getX()/40;
		int play_y = this.getY()/40;
		try{
			switch(c){
			case 'j':
				attack_mode = true;
			}
		}catch(Exception e){}
		if (attack_mode == true){
			for (int count = 0; count < Graphics.en.size(); count ++){
				Enemy temp = Graphics.en.get(count);
				int temp_x = temp.getX();
				int temp_y = temp.getY();
				_top_ = -1;
				_right_ = -1;
				_down_ = -1;
				_left_ = -1;
				if (play_x-temp_x >=-1 && play_x-temp_x <=1 && play_y == temp_y){
					if (play_x-temp_x < 0){
						_right_ = count;
					}
					else{
						_left_ = count;
					}
				}
				if (play_y-temp_y >=-1 && play_y-temp_y <=1 && play_x == temp_x){
					if (play_y - temp_y < 0){
						_down_ = count;
					}
					else{
						_top_ = count;
					}
				}
			}
		}

		if (attack_mode == false){
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
		if (attack_mode == true){
			try{
				switch(c){
				case 'a':
					if(_left_ != -1){
						Graphics.en.get(_left_).takeDamage(this.damage);
					}
					break;
				case 'd':
					if(_right_ != -1){
						Graphics.en.get(_right_).takeDamage(this.damage);
					}
					break;
				case 'w':
					if(_top_ != -1){
						Graphics.en.get(_top_).takeDamage(this.damage);
					}
					break;
				case 's':
					if(_down_ != -1){
						Graphics.en.get(_down_).takeDamage(this.damage);
					}
					break;
				}
			}catch(Exception e){}


>>>>>>> branch 'master' of https://github.com/CodeDayPortlandRPG/RPG.git
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
		if ((c=='s')&&(Graphics.square_array[this.getX()/40][this.getY()/40s]==null)){
			this.y+=40;
		}
		
		
	}
	
	public void draw(SimplestPen pen){
		Vector vec = this.draw_location.make_vector(new Point(this.x, this.y));
		vec.normalize();

		this.draw_location.move(vec);
	}

}
