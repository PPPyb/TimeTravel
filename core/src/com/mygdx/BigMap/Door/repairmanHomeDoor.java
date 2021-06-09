package com.mygdx.BigMap.Door;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.BigMap.Screen.PlayScreen;
import com.mygdx.BigMap.Screen.repairmanHomeScreen;
import com.mygdx.BigMap.otherActor.InteractiveTileObject;
import com.mygdx.BigMap.MyGdxGame;

public class repairmanHomeDoor extends InteractiveTileObject {
    public repairmanHomeDoor(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.DOOR_BIT);
    }

    @Override
    public void onHeadHit() {
        repairmanHomeScreen.changeToMainScreen();
        repairmanHomeScreen.repairmanHomeFlag=1;
        PlayScreen.PlayScreenFlag=0;
    }

}