package codedat.main;
import java.io.IOException;

import javax.imageio.ImageIO;

import plat.resource.sprites.ImgRegulator;
import janus.engine.SimpleGraphics;
import janus.engine.pens.SimplestPen;
public class Graphics extends SimpleGraphics{

	protected Graphics() {
		super(800, 600, "RPG");
	}
	
	Drawer drawer = new Drawer(background_image);

	@Override
	public void draw(SimplestPen pen) {
		drawer.draw();
		
	}

	@Override
	public void start(SimplestPen pen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SimplestPen pen) {
		Main.pen = this.myPen;
		
	}
	
	private void loadImage(String name) {
		try {
			this.imgs.put(name,
					ImageIO.read(ImgRegulator.class.getResource(name)));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
