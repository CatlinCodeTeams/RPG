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
import janus.engine.SimpleGraphics;
import janus.engine.pens.SimplestPen;

public class Graphics extends SimpleGraphics{

	protected Graphics() {
		super(800, 600, "RPG");
		
	}
	public static TurnManager turner;

	public static Drawer drawer;
	
	public static ArrayList<Square> square_list;
	public static SimplestPen pen;
	public static int mapWidth;
	public static int mapLength;
	
	@Override
	public void start(SimplestPen pen) {
		this.endProgramOnClose=true;
		pen.setBackground(Color.WHITE);
		square_list= new ArrayList<Square>();
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
