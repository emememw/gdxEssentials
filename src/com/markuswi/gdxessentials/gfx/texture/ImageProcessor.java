package com.markuswi.gdxessentials.gfx.texture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

public class ImageProcessor {

	private static String formatToHex(Color color) {
		String result = "";
		String hexValue = color.toString().substring(2);
		for (int i = hexValue.length() - 1; i >= 0; i -= 2) {
			result += hexValue.charAt(i - 1);
			result += hexValue.charAt(i);
		}
		return result;
	}

	public static String[][] getPixelsFromImage(String filename) {

		Pixmap pixmap = new Pixmap(Gdx.files.internal("data/" + filename));
		String[][] pixels = new String[pixmap.getWidth()][pixmap.getHeight()];
		for (int x = 0; x < pixmap.getWidth(); x++) {
			for (int y = 0; y < pixmap.getHeight(); y++) {
				int pixel = pixmap.getPixel(x, y);
				Color color = new Color();
				Color.rgba8888ToColor(color, pixel);
				pixels[x][y] = formatToHex(color);
			}
		}

		return pixels;
	}

}
