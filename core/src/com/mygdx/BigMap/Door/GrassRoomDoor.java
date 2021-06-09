package com.mygdx.BigMap.Door;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.BigMap.*;
import com.mygdx.BigMap.Screen.GrassMapRoomScreen;
import com.mygdx.BigMap.otherActor.InteractiveTileObject;

public class GrassRoomDoor extends InteractiveTileObject {
    public GrassRoomDoor(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.DOOR_BIT);
    }

    @Override
    public void onHeadHit() {
        GrassMapRoomScreen.changeToMainScreen();
        GrassMapRoomScreen.GrassMapRoomFlag=1;
    }
}