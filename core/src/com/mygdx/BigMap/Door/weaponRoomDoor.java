package com.mygdx.BigMap.Door;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.BigMap.otherActor.InteractiveTileObject;
import com.mygdx.BigMap.MyGdxGame;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.BigMap.Screen.weaponRoomScreen;


public class weaponRoomDoor extends InteractiveTileObject {
    public weaponRoomDoor(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.DOOR_BIT);
    }

    @Override
    public void onHeadHit() {
        weaponRoomScreen.weaponRoomCollisionFlag=0;
        weaponRoomScreen.changeToMainScreen();
    }

}