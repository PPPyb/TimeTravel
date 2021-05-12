package com.mygdx.timetravel;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Level {
    //绘制
    SpriteBatch batch;
    OrthographicCamera camera;
    CameraHelper cameraHelper;
    //地图
    TiledMap map;
    OrthogonalTiledMapRenderer mapRenderer;
    String collisionLayer;
    //主角
    Azuna azuna;
    //敌人
    TestMonster[] testMonster;
    int testMonsterCnt;

}
