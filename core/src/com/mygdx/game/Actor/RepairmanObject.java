package com.mygdx.game.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.MyGdxGame;
import com.badlogic.gdx.math.Rectangle;



public class RepairmanObject extends InteractiveTileObject {
    public RepairmanObject(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.NPC_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Repairman","Collision");
    }
}
