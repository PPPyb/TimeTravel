package com.mygdx.game.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.MyGdxGame;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.timetravel.CurState;


public class Brick extends InteractiveTileObject {
    private static TiledMapTileSet tileSet;
    private final int BLANK_LAND=1170;
    public Brick(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        tileSet=map.getTileSets().getTileSet("6");
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.Brick_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Brick","Collision");
        setCategoryFilter(MyGdxGame.DESTROYED_BIT);
        getCell().setTile(tileSet.getTile(BLANK_LAND));
        CurState.curLevelNum = 2;
    }
}