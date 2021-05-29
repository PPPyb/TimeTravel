package com.mygdx.game.Actor;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.FireMapScreen;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.PlayScreen;
import com.mygdx.timetravel.CurState;

public class FireBossDoor extends InteractiveTileObject {
    public FireBossDoor(World world, TiledMap map, Rectangle bounds){
        super(world,map,bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.DOOR_BIT);
    }

    @Override
    public void onHeadHit() {
        CurState.curLevelNum = 2;
        //FireMapScreen.smallFireMapCollisionFlag=1;
    }
}
