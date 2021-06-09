package com.mygdx.BigMap.Door;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.BigMap.otherActor.InteractiveTileObject;
import com.mygdx.BigMap.MyGdxGame;
import com.mygdx.SmallMap.LevelFrame.CurState;
import com.mygdx.SmallMap.LevelFrame.LoadingPage;

public class FireBossDoor extends InteractiveTileObject {
    public FireBossDoor(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.DOOR_BIT);
    }

    @Override
    public void onHeadHit() {
        if(!LoadingPage.isFireLoaded())
            LoadingPage.loadFire();
        else
            CurState.curLevelNum = 3;
        //FireMapScreen.smallFireMapCollisionFlag=1;
    }
}
