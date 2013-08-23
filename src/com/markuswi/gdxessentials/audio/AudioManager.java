package com.markuswi.gdxessentials.audio;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {
	private static final AudioManager INSTANCE = new AudioManager();

	public static AudioManager getInstance() {
		return AudioManager.INSTANCE;
	}

	private Map<String, Sound> sounds = new HashMap<String, Sound>();

	private Map<String, Music> songs = new HashMap<String, Music>();

	private AudioManager() {
	}

	public void addSong(String identifier, String filename) {
		this.songs.put(identifier, Gdx.audio.newMusic(Gdx.files.internal("data/" + filename)));
	}

	public void addSound(String identifier, String filename) {
		this.sounds.put(identifier, Gdx.audio.newSound(Gdx.files.internal("data/" + filename)));
	}

	public Map<String, Music> getSongs() {
		return this.songs;
	}

	public Map<String, Sound> getSounds() {
		return this.sounds;
	}

}
