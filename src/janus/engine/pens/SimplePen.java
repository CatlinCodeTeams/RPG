package janus.engine.pens;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class SimplePen extends Graphics {
	public Graphics2D pen;

	@Override
	public void clearRect(int x, int y, int width, int height) {
		pen.clearRect(x, y, width, height);
	}

	@Override
	public void clipRect(int x, int y, int width, int height) {
		pen.clipRect(x, y, width, height);
	}

	@Override
	public void copyArea(int x, int y, int width, int height, int dx, int dy) {
		pen.copyArea(x, y, width, height, dx, dy);
	}

	// Shell stuff
	@Override
	public Graphics create() {
		return pen.create();
	}

	@Override
	public void dispose() {
		pen.dispose();
	}

	@Override
	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		try {
			pen.drawArc(x, y, width, height, startAngle, arcAngle);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public boolean drawImage(Image img, int x, int y, Color bgcolor,
			ImageObserver observer) {
		try {
			return pen.drawImage(img, x, y, bgcolor, observer);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
			return false;
		}
	}

	@Override
	public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
		try {
			return pen.drawImage(img, x, y, observer);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
			return false;
		}
	}

	@Override
	public boolean drawImage(Image img, int x, int y, int width, int height,
			Color bgcolor, ImageObserver observer) {
		try {
			return pen.drawImage(img, x, y, width, height, observer);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
			return false;
		}
	}

	@Override
	public boolean drawImage(Image img, int x, int y, int width, int height,
			ImageObserver observer) {
		try {
			return pen.drawImage(img, x, y, observer);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
			return false;
		}
	}

	@Override
	public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2,
			int sx1, int sy1, int sx2, int sy2, Color bgcolor,
			ImageObserver observer) {
		try {
			return pen.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2,
					bgcolor, observer);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
			return false;
		}
	}

	@Override
	public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2,
			int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
		try {
			return pen.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2,
					observer);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
			return false;
		}
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		try {
			pen.drawLine(x1, y1, x2, y2);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public void drawOval(int x, int y, int width, int height) {
		try {
			pen.drawOval(x, y, width, height);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	public void drawPoint(int x, int y) {
		try {
			pen.drawRect(x, y, 1, 1);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
		try {
			pen.drawPolygon(xPoints, yPoints, nPoints);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
		try {
			pen.drawPolyline(xPoints, yPoints, nPoints);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public void drawRoundRect(int x, int y, int width, int height,
			int arcWidth, int arcHeight) {
		try {
			pen.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public void drawString(AttributedCharacterIterator iterator, int x, int y) {
		try {
			pen.drawString(iterator, x, y);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public void drawString(String str, int x, int y) {
		try {
			pen.drawString(str, x, y);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public void fillArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		try {
			pen.fillArc(x, y, width, height, startAngle, arcAngle);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public void fillOval(int x, int y, int width, int height) {
		try {
			pen.fillOval(x, y, width, height);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
		try {
			pen.fillPolygon(xPoints, yPoints, nPoints);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		try {
			pen.fillRect(x, y, width, height);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public void fillRoundRect(int x, int y, int width, int height,
			int arcWidth, int arcHeight) {
		try {
			pen.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
		} catch (final NullPointerException e) {
			System.err.println("Some error within java graphics activated!");
		}
	}

	@Override
	public Shape getClip() {
		return pen.getClip();
	}

	@Override
	public Rectangle getClipBounds() {
		return pen.getClipBounds();
	}

	@Override
	public Color getColor() {
		return pen.getColor();
	}

	@Override
	public Font getFont() {
		return pen.getFont();
	}

	@Override
	public FontMetrics getFontMetrics(Font f) {
		return pen.getFontMetrics();
	}

	@Override
	public void setClip(int x, int y, int width, int height) {
		pen.setClip(x, y, width, height);
	}

	@Override
	public void setClip(Shape clip) {
		pen.setClip(clip);
	}

	@Override
	public void setColor(Color c) {
		pen.setColor(c);
	}

	@Override
	public void setFont(Font font) {
		pen.setFont(font);
	}

	@Override
	public void setPaintMode() {
		pen.setPaintMode();
	}

	@Override
	public void setXORMode(Color c1) {
		pen.setXORMode(c1);
	}

	@Override
	public void translate(int x, int y) {
		pen.translate(x, y);
	}

	public SimplePen(Graphics2D pen) {
		this.pen = pen;
	}
}
