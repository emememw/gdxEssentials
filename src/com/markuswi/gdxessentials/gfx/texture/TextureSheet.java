package com.markuswi.gdxessentials.gfx.texture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureSheet {
	private Texture textureSheetTexture;
	private TextureRegion[][] textureRegions;

	public TextureSheet(String filename, int gridsize) {
		this.textureSheetTexture = new Texture(Gdx.files.internal("data" + filename));
		this.textureRegions = this.fillTextureRegionArray(this.textureSheetTexture, gridsize);
	}

	public void dispose() {
		this.textureSheetTexture.dispose();
	}

	private TextureRegion[][] fillTextureRegionArray(Texture texture, int gridSize) {

		TextureRegion[][] textureRegionArray = new TextureRegion[texture.getWidth() / gridSize][texture.getHeight() / gridSize];

		for (int y = 0; y < textureRegionArray[0].length; y++) {
			for (int x = 0; x < textureRegionArray.length; x++) {
				textureRegionArray[x][y] = new TextureRegion(texture, x * gridSize, y * gridSize, gridSize, gridSize);
			}
		}
		return textureRegionArray;
	}

	public TextureRegion[][] getTextureRegions() {
		return this.textureRegions;
	}

}
