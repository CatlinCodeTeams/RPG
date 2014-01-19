package janus.engine;

import java.awt.image.BufferedImage;

public class ImageRotator {
	public static BufferedImage getRotatedImage(BufferedImage givenImage,
			double angle) {
		return getRotatedImage(givenImage, givenImage.getWidth() / 2,
				givenImage.getHeight() / 2, Math.toRadians(angle));
	}

	public static BufferedImage getRotatedImage(BufferedImage givenImage,
			int rotationCenterX, int rotationCenterY, double angle) {

		final BufferedImage image = initRotatedImage(givenImage,
				rotationCenterX, rotationCenterY, angle);
		int rotatedX;
		int rotatedY;
		int maxY = -99999;
		int maxX = -99999;
		int minX = 99999;
		int minY = 99999;
		final int centerYOfImage = image.getHeight() / 2 + 1;
		final int centerXOfImage = image.getWidth() / 2 + 1;

		for (int x = 0; x < givenImage.getWidth(); x++) {
			for (int y = 0; y < givenImage.getHeight(); y++) {
				rotatedX = centerXOfImage
						+ calculateRotatedX(x - rotationCenterX, y
								- rotationCenterY, angle);
				rotatedY = centerYOfImage
						+ calculateRotatedY(x - rotationCenterX, y
								- rotationCenterY, angle);
				if (maxX < rotatedX) {
					maxX = rotatedX;
				}
				if (maxY < rotatedY) {
					maxY = rotatedY;
				}
				if (minX > rotatedX) {
					minX = rotatedX;
				}
				if (minY > rotatedY) {
					minY = rotatedY;
				}

				image.setRGB(rotatedX, rotatedY, givenImage.getRGB(x, y));

			}
		}

		return image.getSubimage(minX, minY, maxX - minX, maxY - minY);
	}

	private static int calculateRotatedX(int x, int y, double rotatingAngle) {
		final double angleBeforeRotation = Math.atan2(y, x);
		final double r = getRotatedLength(x, y);
		return (int) Math.round(r
				* Math.cos(angleBeforeRotation + rotatingAngle));
	}

	private static int calculateRotatedY(int x, int y, double rotatingAngle) {
		final double angleBeforeRotation = Math.atan2(y, x);
		final double r = getRotatedLength(x, y);
		return (int) Math.round(r
				* Math.sin(angleBeforeRotation + rotatingAngle));
	}

	private static double getR(int x0, int x1, int y0, int y1) {
		return Math.sqrt(Math.pow(x0 - x1, 2) + Math.pow(y0 - y1, 2));
	}

	private static double getRotatedLength(int x, int y) {
		return getR(x, 0, y, 0);
	}

	private static BufferedImage initRotatedImage(BufferedImage givenImage,
			int rotationCenterX, int rotationCenterY, double rotatingAngle) {
		double maxR = -99999;
		// double minR = 99999;
		final int maxX = givenImage.getWidth() - 1;
		final int maxY = givenImage.getHeight() - 1;
		final int minX = 0;
		final int minY = 0;

		double temp = getR(minX, rotationCenterX, minY, rotationCenterY);
		if (temp > maxR) {
			maxR = temp;
		}
		temp = getR(minX, rotationCenterX, maxY, rotationCenterY);
		if (temp > maxR) {
			maxR = temp;
		}
		temp = getR(maxX, rotationCenterX, maxY, rotationCenterY);
		if (temp > maxR) {
			maxR = temp;
		}
		temp = getR(maxX, rotationCenterX, minY, rotationCenterY);
		if (temp > maxR) {
			maxR = temp;
		}

		final int L = (int) Math.round(3 * maxR + 1);
		return new BufferedImage(L, L, givenImage.getType());
	}
}
