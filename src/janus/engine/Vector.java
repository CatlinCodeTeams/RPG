package janus.engine;

public class Vector {

	public double horizontal;
	public double vertical;

	public void add(Vector them) {
		horizontal += them.horizontal;
		vertical += them.vertical;
	}

	public void divide(double num) {
		horizontal /= num;
		vertical /= num;
	}

	public double length() {
		final double a = vertical * vertical;
		final double b = horizontal * horizontal;
		final double c = Math.sqrt(a + b);
		return c;
	}

	public void multiply(double num) {
		horizontal *= num;
		vertical *= num;
	}

	public void normalize() {
		final double l = this.length();
		if (l != 0) {
			horizontal /= l;
			vertical /= l;

		}
	}

	public void substract(Vector them) {
		horizontal -= them.horizontal;
		vertical -= them.vertical;
	}

	public Vector(double horizontal, double vertical) {
		this.horizontal = horizontal;
		this.vertical = vertical;
	}
}
