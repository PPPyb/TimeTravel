package com.mygdx.timetravel;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.timetravel.Constants ;

//这个类用来渲染世界
public class WorldRenderer implements Disposable {

    private WorldController worldController;
    private OrthographicCamera cam;
    TestMap testMap;

    public WorldRenderer(WorldController worldController)
    {
        this.worldController = worldController;
        init();
    }
    private void init()
    {
        cam = new OrthographicCamera();
        cam.setToOrtho(false,Constants.WINDOWS_WIDTH,Constants.WINDOWS_HEIGHT);
        testMap = new TestMap();
    }

    public void render()
    {
        testMap.render();
    }
    public void resize(int width,int height)
    {

    }

    @Override
    public void dispose()
    {

    }
}
