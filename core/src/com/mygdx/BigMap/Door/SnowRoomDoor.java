package com.mygdx.BigMap.Door;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.BigMap.*;
import com.mygdx.BigMap.Screen.SnowMapRoomScreen;
import com.mygdx.BigMap.otherActor.InteractiveTileObject;

public class SnowRoomDoor extends InteractiveTileObject {
    public SnowRoomDoor(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.DOOR_BIT);
    }

    @Override
    public void onHeadHit() {
        SnowMapRoomScreen.changeToMainScreen();
        SnowMapRoomScreen.SnowMapRoomFlag=1;
        //FireMapScreen.smallFireMapCollisionFlag=1;
    }
}