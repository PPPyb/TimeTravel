package com.mygdx.game.Actor;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.PlayScreen;
import com.mygdx.game.powerRoomScreen;
import com.mygdx.game.weaponRoomScreen;


public class powerRoomDoor extends InteractiveTileObject {
    public powerRoomDoor(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.DOOR_BIT);
    }

    @Override
    public void onHeadHit() {
        //powerRoomScreen.powerRoomScreenFlag=1;
        PlayScreen.PlayScreenFlag=0;
        powerRoomScreen.changeToMainScreen();
    }

}