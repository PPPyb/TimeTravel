package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Scanner;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
    public static final int V_WIDTH=520;
    public static final int V_HEIGHT=300;
    public static final int PPM=1;
    public static final short DEFAULT_BIT=1;
	public static final short MARIO_BIT=2;
	public static final short Brick_BIT=4;
	public static final short DOOR_BIT=8;
	public static final short DESTROYED_BIT=16;
	public static final short NPC_BIT=32;
	public static final short NPC_OBJECT_BIT=64;

	public static AssetManager manager;
	@Override
	public void create () {
		batch=new SpriteBatch();
		manager=new AssetManager();
		//manager.load("music/backgroundMusic.mp3", Music.class);
		//manager.finishLoading();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
		manager.update();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

}
