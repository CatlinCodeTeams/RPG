package codedat.main;
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

<<<<<<< HEAD

=======
	Drawer drawer;
	
	
	@Override
	public void draw(SimplestPen pen) {
		drawer.draw();
		
	}
>>>>>>> branch 'master' of https://github.com/CodeDayPortlandRPG/RPG.git

	@Override
	public void start(SimplestPen pen) {
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
<<<<<<< HEAD
	
<<<<<<< HEAD
	@Override
	public void draw(SimplestPen pen) {
		drawer.draw();
		
	}
	@Override
	public void onKeyTyped(KeyEvent e,SimplestPen pen){
=======
	private void loadImage(String name) {
		try {
			this.imgs.put(name,
					ImageIO.read(ImgRegulator.class.getResource(name)));
		} catch (IOException e) {
			e.printStackTrace();
		}
=======
>>>>>>> branch 'master' of https://github.com/CodeDayPortlandRPG/RPG.git

<<<<<<< HEAD
>>>>>>> branch 'master' of https://github.com/CodeDayPortlandRPG/RPG.git
	}
=======
	

>>>>>>> branch 'master' of https://github.com/CodeDayPortlandRPG/RPG.git

}
