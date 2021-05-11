package com.mygdx.timetravel;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.timetravel.Constants;

public class TestMap {
    Viewport viewport;
    Stage stage;
    Stage bkgStage;
    Azuna azuna;
    SpriteBatch batch;
    TiledMap map;
    OrthographicCamera cam;
    OrthogonalTiledMapRenderer testRender;
    BackGround bkg;

    public TestMap()
    {
        init();
    }
    public void init()
    {
        bkg = new BackGround();
        map = new TmxMapLoader().load("testMap/testMap.tmx");
        cam = new OrthographicCamera();
        cam.setToOrtho(false,1280,720);
        testRender = new OrthogonalTiledMapRenderer(map);
        batch =  new SpriteBatch();
        viewport = new StretchViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        stage = new Stage(viewport);
        bkgStage = new Stage(viewport);
        azuna = new Azuna();
        bkgStage.addActor(bkg);
        stage.addActor(azuna);


    }
    public void render()
    {
        stage.act();
        bkgStage.draw();
        cam.update() ;
        testRender.setView(cam);
        testRender.render();
        stage.draw();
    }
}
