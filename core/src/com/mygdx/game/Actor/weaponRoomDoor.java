package com.mygdx.game.Actor;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.MyGdxGame;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.PlayScreen;
import com.mygdx.game.weaponRoomScreen;


public class weaponRoomDoor extends InteractiveTileObject {
    public weaponRoomDoor(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.DOOR_BIT);
    }

    @Override
    public void onHeadHit() {
        weaponRoomScreen.changeToMainScreen();
    }

}