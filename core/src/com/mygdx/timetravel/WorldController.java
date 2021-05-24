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
    MainTitle mainTitle;
    Tutorials tutorials;
    MusicManager musicManager;
    StrangeClass strangeObject;

    public WorldController()
    {
        testMap = new Level("testMap/testMap.tmx","testMap/Background.tmx");
        testWorld = new Level("testMap/testWorld.tmx","testMap/Background.tmx");
        snowLand = new Level("SnowLand/SnowLand.tmx","SnowLand/SnowLandBackGround.tmx");
        curLevel = testMap;
        myGame = new com.mygdx.game.MyGdxGame();
        myGame.create();
        mainTitle = new MainTitle();
        tutorials = new Tutorials();
        strangeObject = new StrangeClass();
        musicManager = new MusicManager();
    }

    public void update()
    {
        levelManager();
        chooseLevel();
    }

    public void render()
    {
        update();
        switch (CurState.curLevelNum)
        {
            case 0:
                mainTitle.render();
                break;
            case 1:
                myGame.render();
                break;
            case 10:
                tutorials.render();
                break;
            case 10086:
                strangeObject.render();
                break;
            default:
                curLevel.render();
        }
    }
    public void chooseLevel()
    {
        switch (CurState.curLevelNum)
        {
            case 2:
                curLevel = snowLand;
                break;
            case 3:
                curLevel = testWorld;
                break;
            default:
                break;
        }
    }
    public void levelManager()
    {
        //tutorial
        if(Gdx.input.isKeyJustPressed(Input.Keys.T)) {
            if(CurState.curLevelNum!=10)
                tutorials.setCurLevelNum(CurState.curLevelNum);
            setCurLevelNum(10);
        }
        //reset
        if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)&&Gdx.input.isKeyJustPressed(Input.Keys.R))
        {
            resetGame();
        }
        //strange
        if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)&&Gdx.input.isKeyJustPressed(Input.Keys.N))
        {
            if(CurState.curLevelNum!=10086)
                strangeObject.setCurLevelNum(CurState.curLevelNum);
            setCurLevelNum(10086);
        }
        //
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
        CurState.curLevelNum = curLevelNum;
    }
    public void resetGame()
    {
        setCurLevelNum(0);
        testMap = new Level("testMap/testMap.tmx","testMap/Background.tmx");
        testWorld = new Level("testMap/testWorld.tmx","testMap/Background.tmx");
        snowLand = new Level("SnowLand/SnowLand.tmx","SnowLand/SnowLandBackGround.tmx");
        curLevel = testMap;
        myGame = new com.mygdx.game.MyGdxGame();
        myGame.create();
    }
}
