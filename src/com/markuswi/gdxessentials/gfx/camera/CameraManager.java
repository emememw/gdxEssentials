package com.markuswi.gdxessentials.gfx.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class CameraManager {
	private static final CameraManager INSTANCE = new CameraManager();

	public static CameraManager getInstance() {
		return CameraManager.INSTANCE;
	}

	private OrthographicCamera camera;

	private CameraManager() {
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	public OrthographicCamera getCamera() {
		return this.camera;
	}

	public Vector3 translateToWorldCoordinates(float x, float y) {
		Vector3 worldCoordinates = new Vector3(x, y, 0);
		this.camera.unproject(worldCoordinates);
		return worldCoordinates;
	}

}
