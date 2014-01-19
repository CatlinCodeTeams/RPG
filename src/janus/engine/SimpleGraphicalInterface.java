package janus.engine;

import janus.engine.pens.SimplestPen;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface SimpleGraphicalInterface {

	public void draw(SimplestPen pen);

	public void onKeyPressed(KeyEvent event, SimplestPen pen);

	public void onKeyReleased(KeyEvent event, SimplestPen pen);

	public void onKeyTyped(KeyEvent event, SimplestPen pen);

	public void onMouseClicked(MouseEvent event, SimplestPen pen);

	public void onMouseEntered(MouseEvent event, SimplestPen pen);

	public void onMouseExited(MouseEvent event, SimplestPen pen);

	public void onMousePressed(MouseEvent event, SimplestPen pen);

	public void onMouseReleased(MouseEvent event, SimplestPen pen);

	public void onResize(SimplestPen pen);

	public void start(SimplestPen pen);

	public void update(SimplestPen pen);
}
