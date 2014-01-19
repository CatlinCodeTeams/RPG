package codeday.player;

import janus.engine.Point;
import janus.engine.Vector;
import janus.engine.pens.SimplestPen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import codeday.main.Graphics;
import codeday.rpg.enemies.BasicEnemyIntelligence;
import codeday.rpg.interfaces.Enemy;
import codeday.rpg.interfaces.Player;
import codeday.rpg.resource.sprites.FileLoader;
public class RealPlayer implements Player{
	BufferedImage defualt;
	int health=20;
	int x;
	int y;
	int damage = 20;
	boolean attack_mode = false;
	
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
		ArrayList<Enemy>en = Graphics.en;
		this.attack_mode = false;
		try{
			switch(c){
			case 'j':
				this.attack_mode = true;
			}
		}catch(Exception e){}
		if (this.attack_mode == true){
			System.out.println("it works");
			Enemy _left_ = null;
			Enemy _up_ = null;
			Enemy _right_ = null;
			Enemy _down_ = null;
			for(int count = 0; count <= Graphics.en.size(); count ++){
				Enemy temp = Graphics.en.get(count);
				int play_x = this.getTrueX();
				int play_y = this.getTrueY();
				int temp_x = temp.getTrueX();
				int temp_y = temp.getTrueY();
				if ((play_x-temp_x) >-1 && (play_x-temp_x) < 1 && play_y == temp.getY()/40){
					if (temp_x < play_x){
						_left_ = en.get(count);
					}
					if (temp_x > play_x){
						_right_ = en.get(count);

					}
				}
				if ((play_y-temp_y) >-1 && (play_y-temp_y) < 1 && play_x == temp_x){
					if (temp_y < play_y){
						_up_ = en.get(count);
					}
					if (temp_y > play_y){
						_down_= en.get(count);
					}
				}
			}
			try{
				switch(c){
				case 'd':
					if (_right_ != null){
						_right_.takeDamage(this.damage);
						break;
					}
					break;
				case 'w':
					if (_up_ != null){
						_up_.takeDamage(this.damage);
					}

				case 's':
					if (_down_ != null){
						_down_.takeDamage(this.damage);
						break;
					}
				case 'a':
					if (_left_ != null){
						_left_.takeDamage(this.damage);
						break;
					}
				}
			}catch(Exception e){}
		}
		else if (this.attack_mode == false){
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
	}
	public void draw(SimplestPen pen){
		Vector vec = this.draw_location.make_vector(new Point(this.x, this.y));
		vec.normalize();
		
		this.draw_location.move(vec);
	}
	
	@Override
	public int getTrueX() {
		return x/40;
	}
	@Override
	public int getTrueY() {
		return x/40;
	}
}
