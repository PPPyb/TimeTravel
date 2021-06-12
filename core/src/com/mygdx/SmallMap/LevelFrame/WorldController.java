package com.mygdx.SmallMap.LevelFrame;


import com.badlogic.gdx.*;
import com.badlogic.gdx.math.Vector2;

/*
下面这个类按理来说应该处理游戏逻辑，实例都放进这个类里边。
但是反正最后我可能还是会瞎放。
*/
public class WorldController {

    Level curLevel;
    static Level snowLand;
    static Level fireMap;
    static Level greenMap;
    static com.mygdx.BigMap.MyGdxGame myGame;
    static Ending ending;
    LoadingPage loadingPage;
    MainTitle mainTitle;
    Tutorials tutorials;
    MusicManager musicManager;
    StrangeClass strangeObject;

    public WorldController()
    {
        MyTextrue.ini();
        loadingPage = new LoadingPage(this);
        mainTitle = new MainTitle(this);
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
            case -1:
                loadingPage.render();
                break;
            case -2:
                ending.render();
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
                curLevel = fireMap;
                break;
            case 4:
                curLevel = greenMap;
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
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_0))
        {
            if(!LoadingPage.isBigLoaded())
                LoadingPage.loadWorld();
            else
                setCurLevelNum(1);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_9))
        {
            if(!LoadingPage.isSnowLoaded())
                LoadingPage.loadSnow();
            else
                setCurLevelNum(2);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_8))
        {
            if(!LoadingPage.isFireLoaded())
                LoadingPage.loadFire();
            else
                setCurLevelNum(3);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_7))
        {
            if(!LoadingPage.isGreenLoaded())
                LoadingPage.loadGreen();
            else
                setCurLevelNum(4);
        }
    }

    public void setCurLevelNum(int curLevelNum) {
        CurState.curLevelNum = curLevelNum;
    }
    public void resetGame()
    {
        setCurLevelNum(0);
        snowLand = new Level("SnowLand/SnowLand.tmx","SnowLand/SnowLandBackGround.tmx");
        fireMap = new Level("FireMap/fire.tmx","FireMap/fireBackground.tmx");
        greenMap = new Level("GreenMap/green.tmx","GreenMap/greenBackground.tmx");
        Constants.myGravatiy = new Vector2(0,-10);
        myGame = new com.mygdx.BigMap.MyGdxGame();
        myGame.create();
    }
}