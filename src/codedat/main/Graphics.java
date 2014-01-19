package codedat.main;
import java.awt.event.KeyEvent;

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
	@Override
	public void onKeyTyped(KeyEvent e,SimplestPen pen){
	}
}
