package com.mygdx.game.Actor;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.MyGdxGame;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.PlayScreen;
import com.mygdx.game.weaponRoomScreen;
import com.mygdx.game.gambleRoomScreen;

public class gambleRoomDoor extends InteractiveTileObject {
    public gambleRoomDoor(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.DOOR_BIT);
    }

    @Override
    public void onHeadHit() {
        gambleRoomScreen.changeToMainScreen();
    }

}
