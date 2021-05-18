package com.mygdx.timetravel;


import com.mygdx.game.*;

import com.badlogic.gdx.*;
import com.mygdx.timetravel.Constants;

/*
下面这个类按理来说应该处理游戏逻辑，实例都放进这个类里边。
但是反正最后我可能还是会瞎放。
*/
public class WorldController {

    Level curLevel;
    Level snowLand;
    Level testMap;
    Level testWorld;
    com.mygdx.game.MyGdxGame myGame;

    public WorldController()
    {
        testMap = new Level("testMap/testMap.tmx","testMap/Background.tmx");
        testWorld = new Level("testMap/testWorld.tmx","testMap/Background.tmx");
        snowLand = new Level("SnowLand/SnowLand.tmx","SnowLand/SnowLandBackGround.tmx");
        curLevel = testMap;
        myGame = new com.mygdx.game.MyGdxGame();
        myGame.create();
    }

    public void update()
    {
        levelManager();
        chooseLevel();
    }

    public void render()
    {
        update();
        if(CurState.curLevelNum == 0)
            myGame.render();
        else
            curLevel.render();
    }
    public void chooseLevel()
    {
        switch (CurState.curLevelNum)
        {
            case 1:
                curLevel = snowLand;
                break;
            case 2:
                curLevel = testWorld;
                break;
            case 0:
                break;
        }
    }
    public void levelManager()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1))
        {
            setCurLevelNum(1);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2))
        {
            setCurLevelNum(2);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_0))
        {
            setCurLevelNum(0);
        }
    }

    public void setCurLevelNum(int curLevelNum) {
        CurState.curLevelNum = curLevelNum;
    }
}
