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
    CameraHelper camHp;
    boolean cameraTracking = false;

    public TestMap()
    {
        init();
    }
    public void init()
    {
        map = new TmxMapLoader().load("testMap/testMap.tmx");
        cam = new OrthographicCamera();
        cam.setToOrtho(false,1280,720);
        testRender = new OrthogonalTiledMapRenderer(map);
        batch =  new SpriteBatch();
        viewport = new StretchViewport(cam.viewportWidth,cam.viewportHeight);
        azuna = new Azuna(new Texture(Gdx.files.internal("testMap/azuna.png")));
        camHp = new CameraHelper();


    }
    public void render()
    {
        float x = 0;

        azuna.update(Gdx.graphics.getDeltaTime(),map,"ObjectLayer");
        camHp.trackTarget(azuna);
        camHp.applyTo(cam);
        cam.update() ;
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        testRender.setView(cam);
        testRender.render();



        /*(MapObjects objects =  map.getLayers().get("ObjectLayer").getObjects();

        int cnt = 0;
        for(RectangleMapObject recobj: objects.getByType(RectangleMapObject.class))
        {

            Rectangle r1 = new Rectangle(azuna.getX(),azuna.getY(),azuna.curFrame.getRegionWidth(),azuna.curFrame.getRegionHeight());
            Rectangle r2 = recobj.getRectangle();
            //System.out.println(r2.x+" "+r2.y);
            if(Intersector.overlaps(r1,r2))
                System.out.println("collision!"+r1.toString());
        }*/

        batch.draw(azuna.curFrame,azuna.getX(),azuna.getY());
        batch.end();
        //stage.draw();
    }
}
