package com.mygdx.game.Actor;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.*;
import com.mygdx.timetravel.CurState;

public class GrassRoomDoor extends InteractiveTileObject {
    public GrassRoomDoor(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.DOOR_BIT);
    }

    @Override
    public void onHeadHit() {
        GrassMapRoomScreen.changeToMainScreen();
        //SnowMapRoomScreen.SnowMapRoomFlag=1;
        //FireMapScreen.smallFireMapCollisionFlag=1;
    }
}