package janus.engine;

public class Point {

	public double x;
	public double y;

	public double dist(Point them) {
		double a = x - them.x;
		double b = y - them.y;
		a = a * a;
		b = b * b;
		final double c = Math.sqrt(a + b);
		return c;
	}

	public int getIntX() {
		return (int) x;
	}

	public int getIntY() {
		return (int) y;
	}

	public Vector make_vector(Point them) {
		final double x = them.x - this.x;
		final double y = them.y - this.y;

		final Vector vec = new Vector(x, y);

		return vec;

	}

	public void move(Vector vector) {
		x += vector.horizontal;
		y += vector.vertical;
	}

	public Point(int px, int py) {
		x = px;
		y = py;

	}

	public Point(java.awt.Point p) {
		x = p.x;
		y = p.y;
	}

}
