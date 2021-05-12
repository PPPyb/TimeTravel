package com.mygdx.timetravel;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.timetravel.Constants;

/*
---------------------------------------------------------------------\
皇家测试御用地图，用后即焚！
 */

public class TestMap {
    /*Viewport viewport;
    Azuna azuna;
    SpriteBatch batch;
    TiledMap map;
    OrthographicCamera cam;
    OrthogonalTiledMapRenderer testRender;
    CameraHelper camHp;
    TestMonster[] testMonster;
    int monsterCnt = 0;*/

    Level level;

    public TestMap()
    {
        level = new Level();
        init();
    }
    public void init()
    {
        level.map = new TmxMapLoader().load("testMap/testMap.tmx");
        level.collisionLayer = new String("ObjectLayer");
        level.camera = new OrthographicCamera();
        level.camera.setToOrtho(false,1280,720);
        level.mapRenderer = new OrthogonalTiledMapRenderer(level.map);
        level.batch =  new SpriteBatch();
        level.cameraHelper = new CameraHelper();
        level.testMonster = new TestMonster[10];


        {
            MapObjects objects = level.map.getLayers().get("PlayerLayer").getObjects();
            for (RectangleMapObject recObj : objects.getByType(RectangleMapObject.class)) {

                Rectangle r = recObj.getRectangle();
                level.azuna = new Azuna(r.x, r.y);
            }
        }
        {
            MapObjects objects = level.map.getLayers().get("EnemyLayer").getObjects();
            for (RectangleMapObject recObj : objects.getByType(RectangleMapObject.class)) {

                Rectangle r = recObj.getRectangle();
                System.out.println(r);
                level.testMonster[level.testMonsterCnt++] = new TestMonster(r.x,r.y);
            }
        }

    }
    public void render()
    {
        float x = 0;

        level.azuna.update(Gdx.graphics.getDeltaTime(),level);
        for(int i = 0;i < level.testMonsterCnt;i++)
            level.testMonster[i].update(Gdx.graphics.getDeltaTime(),level);
        level.cameraHelper.trackTarget(level.azuna);
        level.cameraHelper.applyTo(level.camera);
        level.camera.update() ;

        level.batch.setProjectionMatrix(level.camera.combined);
        level.batch.begin();

        level.mapRenderer.setView(level.camera);
        level.mapRenderer.render();

        level.azuna.draw(level.batch);
        for(int i = 0;i < level.testMonsterCnt;i++)
            level.testMonster[i].draw(level.batch);
        //batch.draw(azuna.curFrame,azuna.getX(),azuna.getY());
        level.batch.end();
        //stage.draw();
    }

}
