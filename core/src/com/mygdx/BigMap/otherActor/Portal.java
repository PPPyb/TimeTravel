package com.mygdx.BigMap.otherActor;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.BigMap.MyGdxGame;
import com.mygdx.BigMap.Screen.PlayScreen;


public class Portal extends InteractiveTileObject {
    public Portal(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.DOOR_BIT);
    }

    @Override
    public void onHeadHit() {
        //System.out.println(PlayScreen.PortalCollisionFlag);
        PlayScreen.PortalCollisionFlag=1;
    }
}
