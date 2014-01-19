package codeday.main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import codeday.rpg.interfaces.Square;
import codeday.rpg.resource.sprites.FileLoader;
import codeday.walls.Wall;
import janus.engine.SimpleGraphics;
import janus.engine.pens.SimplestPen;

public class Graphics extends SimpleGraphics{

	protected Graphics() {
		super(800, 600, "RPG");
		
	}
	public static TurnManager turner;

	public static Drawer drawer;
	
	public static Square[][] square_array;
	public static SimplestPen pen;
	public static int mapWidth;
	public static int mapLength;
	
	@Override
	public void start(SimplestPen pen) {
		square_array= new Square[40][30];
		
		loadImage("wall.png");
		
		for (int k=0; k<10; k++){
			square_array[5+k][10] =new Wall(this.imgs.get("wall.png"), 200+k*40,400);
		}
		
		this.endProgramOnClose=true;
		pen.setBackground(Color.WHITE);
		turner=new TurnManager(null,null);
		try {
			drawer=new Drawer(ImageIO.read(new File(FileLoader.class.getResource("spr_left.png").toURI())));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(SimplestPen pen) {
		Graphics.pen = this.myPen;
		
	}
	@Override
	public void draw(SimplestPen pen) {
		drawer.draw();
		
	}

	@Override
	public void onKeyTyped(KeyEvent e,SimplestPen pen){
		
	}
	private void loadImage(String name) {
		try {
			this.imgs.put(name,
					ImageIO.read(FileLoader.class.getResource(name)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
