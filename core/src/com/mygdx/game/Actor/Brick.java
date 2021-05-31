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
    private final int BLANK_LAND1=589;
    private final int BLANK_LAND2=629;
    private final int BLANK_LAND3=630;
    private final int BLANK_LAND4=670;
    public Brick(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        tileSet=map.getTileSets().getTileSet("snowMap");
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.Brick_BIT);
        //589,629,630,670
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Brick","Collision");
        setCategoryFilter(MyGdxGame.DESTROYED_BIT);
        getCell().setTile(tileSet.getTile(BLANK_LAND1));
        getCell().setTile(tileSet.getTile(BLANK_LAND2));
        //getCell().setTile(tileSet.getTile(BLANK_LAND3));
        //getCell().setTile(tileSet.getTile(BLANK_LAND4));
        //CurState.curLevelNum = 2;
    }
}