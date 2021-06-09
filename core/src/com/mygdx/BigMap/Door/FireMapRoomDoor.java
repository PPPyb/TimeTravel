package com.mygdx.BigMap.Door;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.BigMap.*;
import com.mygdx.BigMap.Screen.FireMapRoomScreen;
import com.mygdx.BigMap.otherActor.InteractiveTileObject;

public class FireMapRoomDoor extends InteractiveTileObject {
    public FireMapRoomDoor(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.DOOR_BIT);
    }

    @Override
    public void onHeadHit() {
        FireMapRoomScreen.changeToMainScreen();
        //SnowMapRoomScreen.SnowMapRoomFlag=1;
        //FireMapScreen.smallFireMapCollisionFlag=1;
    }
}