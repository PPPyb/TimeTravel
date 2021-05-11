package com.mygdx.timetravel;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.*;

/*
--------------------------
大家好，
我不想写注释!
但是我又不得不写。
下面介个类是我们的主类，
请大家不要是个东西就往主类里边放，
谢谢！
（因为我会往主类里面瞎放东西）
--------------------------
 */
public class TimeTravelMain extends ApplicationAdapter {

	private WorldController worldController;
	private WorldRenderer worldRenderer;

	@Override
	public void create ()
	{
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);
	}

	@Override
	public void resize(int width,int height)
	{
		worldRenderer.resize(width, height);
	}

	@Override
	public void render ()
	{
		worldController.update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		worldRenderer.render();
	}
	
	@Override
	public void dispose ()
	{
		worldRenderer.dispose();
	}
}
