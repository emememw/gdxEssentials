package com.markuswi.gdxessentials.gfx.font;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class FontManager {

	private static final FontManager INSTANCE = new FontManager();

	public static FontManager getInstance() {
		return FontManager.INSTANCE;
	}

	Map<String, BitmapFont> fonts = new HashMap<String, BitmapFont>();

	private FontManager() {
	}

	public void addFont(String identifier, String filename) {
		BitmapFont font = new BitmapFont(Gdx.files.internal("data/" + filename + ".fnt"), Gdx.files.internal("data/" + filename + ".png"), false);
		font.setScale(1);
		font.setColor(Color.WHITE);
		this.fonts.put(identifier, font);
	}

	public void disposeFonts() {
		for (Entry<String, BitmapFont> entry : this.fonts.entrySet()) {
			entry.getValue().dispose();
		}
	}

	public Map<String, BitmapFont> getFonts() {
		return this.fonts;
	}

}
