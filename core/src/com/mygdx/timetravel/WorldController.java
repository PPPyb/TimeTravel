package com.mygdx.timetravel;

import com.badlogic.gdx.*;
import com.mygdx.timetravel.Constants;

/*
下面这个类按理来说应该处理游戏逻辑，实例都放进这个类里边。
但是反正最后我可能还是会瞎放。
*/
public class WorldController {

    Level curLevel;
    int curLevelNum = 1;
    Level testMap;
    Level testWorld;
    public WorldController()
    {
        curLevel = new Level("testMap/testWorld.tmx");
        testMap = new Level("testMap/testMap.tmx");
        testWorld = new Level("testMap/testWorld.tmx");
    }

    public void update()
    {
        levelManager();
        chooseLevel();
    }

    public void render()
    {
        update();
        curLevel.render();
    }
    public void chooseLevel()
    {
        switch (curLevelNum)
        {
            case 1:
                curLevel = testMap;
                break;
            case 2:
                curLevel = testWorld;
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
    }

    public void setCurLevelNum(int curLevelNum) {
        this.curLevelNum = curLevelNum;
    }
}
