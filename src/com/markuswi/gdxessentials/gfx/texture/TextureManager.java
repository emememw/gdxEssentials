package com.markuswi.gdxessentials.gfx.texture;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TextureManager {

	private static final TextureManager INSTANCE = new TextureManager();

	public static TextureManager getInstance() {
		return TextureManager.INSTANCE;
	}

	private Map<String, TextureSheet> textureSheets = new HashMap<String, TextureSheet>();

	private TextureManager() {
	}

	public void addTextureSheet(String identifier, String filename, int gridsize) {
		this.textureSheets.put(identifier, new TextureSheet(filename, gridsize));
	}

	public void disposeTextures() {
		for (Entry<String, TextureSheet> entry : this.textureSheets.entrySet()) {
			entry.getValue().dispose();
		}
	}

	public Map<String, TextureSheet> getTextureSheets() {
		return this.textureSheets;
	}
}
