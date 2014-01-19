package codedat.main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

import codeday.rpg.resource.sprites.FileLoader;
import janus.engine.SimpleGraphics;
import janus.engine.pens.SimplestPen;

public class Graphics extends SimpleGraphics{

	protected Graphics() {
		super(800, 600, "RPG");
		
	}
	TurnManager turner;

	Drawer drawer;
	
	
	@Override
	public void start(SimplestPen pen) {
		pen.setBackground(new Color(255,255,255));
		
		// TODO Auto-generated method stub
		turner=new TurnManager(null,null);
		try {
			drawer=new Drawer(ImageIO.read(new File(FileLoader.class.getResource("spr_left.png").toURI())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(SimplestPen pen) {
		Main.pen = this.myPen;
		
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
