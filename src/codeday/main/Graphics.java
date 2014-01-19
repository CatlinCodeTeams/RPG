package codeday.main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;

import Traps.Fire_Trap;
import codeday.player.RealPlayer;
import codeday.rpg.enemies.Rat;
import codeday.rpg.interfaces.Enemy;
import codeday.rpg.interfaces.Player;
import codeday.rpg.interfaces.Square;
import codeday.rpg.resource.sprites.FileLoader;
import codeday.walls.Wall;
import janus.engine.SimpleGraphics;
import janus.engine.pens.SimplestPen;

public class Graphics extends SimpleGraphics{

	protected Graphics() {
		super(800, 600, "RPG");
		
	}
	public static Player p;
	public static TurnManager turner;

	public static Drawer drawer;
	
	public static Square[][] square_array;
	public static SimplestPen pen;
	public static int mapWidth;
	public static int mapLength;
	public static HashMap<String,BufferedImage> img;
	
	@Override
	public void start(SimplestPen pen) {
		img=imgs;
		ArrayList<Square> s=new ArrayList<Square>();
		square_array= new Square[40][30];
		ArrayList<Enemy> en=new ArrayList<Enemy>();
		en.add(new Rat(1,1));
		loadImage("wall.png");
		loadImage("spr_main.png");
		loadImage("spr_rat_down2.png");
		loadImage("spr_sprite.png");
		loadImage("stone_tile.png");
		ArrayList<ArrayList<Square>> ls=new ArrayList<ArrayList<Square>>();
		BufferedReader reader=null;
		try {
			reader = new BufferedReader(new FileReader(new File(FileLoader.class.getResource("map1.txt").toURI())));
		} catch (FileNotFoundException | URISyntaxException e) {
			e.printStackTrace();
		}
		String line;
		try {
			int one=-1;
			while ((line = reader.readLine()) != null) {
				one++;
				int two=-1;
				ls.add(new ArrayList<Square>());
				for(char c:line.toCharArray()){
					two++;
					if(c=='w'){                                               //Random blocks were dissapearing when called to draw, swithcing one and two seems to fix it.
						ls.get(ls.size()-1).add(new Wall(this.imgs.get("wall.png"),two*40,one*40));
					}
					else if(c==' '){
						ls.get(ls.size()-1).add(null);
					}
					else if(c=='t'){
						ls.get(ls.size()-1).add(new Fire_Trap(two*40,one*40));
					}
				}
			}
			line=null;
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		square_array = new Square[ls.get(0).size()][ls.size()];

		for(int x=0;x<ls.get(0).size();x++){
			for(int y=0;y<ls.size();y++){
				square_array[x][y]=ls.get(y).get(x);
			}
		}
		chuckNorris(square_array);
//		
//		
//		for (int k=0; k<10; k++){
//			square_array[5+k][10] =new Wall(this.imgs.get("wall.png"), 200+k*40,400);
//		}
//		RealPlayer player = new RealPlayer(this.imgs.get("spr_main.png"), 120,120);
//		square_array[3][3] = player;
//		
		this.endProgramOnClose=true;
		pen.setBackground(new Color(50,50,50));
		turner=new TurnManager(p,en);
		try {
			drawer=new Drawer(ImageIO.read(new File(FileLoader.class.getResource("stone_tile.png").toURI())));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void chuckNorris(Square[][] s){
		int num1=new Random().nextInt(s.length);
		Square[] ch=s[num1];
		int num=new Random().nextInt(ch.length);
		if(ch[num]==null){
			p=new RealPlayer(this.imgs.get("spr_main.png"), num*40, num1*40);
			ch[num]= p;
		}
		else{
			chuckNorris(s);
		}
	}
	@Override
	public void update(SimplestPen pen) {
		Graphics.pen = this.myPen;
		Graphics.pen.setCameraPosition(p.getX(), p.getY());

	}
	@Override
	public void draw(SimplestPen pen) {
		drawer.draw();
		
	}

	@Override
	public void onKeyTyped(KeyEvent e,SimplestPen pen){
		if(e.getKeyChar()=='r'){
			pen.restart();
			return;
		}
		turner.input(e.getKeyChar());
	}
	private void loadImage(String name) {
		try {
			this.imgs.put(name,
					ImageIO.read(FileLoader.class.getResource(name)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
/*	public void onKeyPressed(KeyEvent event, SimplestPen pen) {
		p.charInput(event.getKeyChar());
		}*/

	}
