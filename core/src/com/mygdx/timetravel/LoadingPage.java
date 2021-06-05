package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LoadingPage {
    SpriteBatch batch;
    Texture bkg;
    TextureRegion tiao;
    WorldController worldController;
    static String loadingTarget = "";
    double delay = 0;

    float tiaoX = 640;
    float tiaoY = 100;
    float tiaoWidth = 800;
    float tiaoHigh = 40;

    static boolean bigLoaded = false;
    static boolean snowLoaded = false;
    static boolean fireLoaded = false;
    static boolean greenLoaded = false;

    public LoadingPage(WorldController worldController)
    {
        tiao = new TextureRegion(new Texture(Gdx.files.internal("GUI/HP.png")));
        this.worldController = worldController;
        batch = new SpriteBatch();
        bkg = new Texture(Gdx.files.internal("MainTitle/Loading.png"));
    }
    public void render()
    {
        delay += Math.random()/10;
        batch.begin();
        batch.draw(bkg,0,0);

        batch.setColor(0.5f,0.5f,0.5f,0.75f);
        batch.draw(tiao,tiaoX-tiaoWidth/2,tiaoY,tiaoWidth,tiaoHigh);
        batch.setColor(1,1,1,1);
        batch.draw(tiao,tiaoX-tiaoWidth/2,tiaoY,(float)(tiaoWidth*delay),tiaoHigh);

        batch.end();

        if(delay > 1) {
            delay = 0;
            switch (loadingTarget) {
                case "WORLD":
                    WorldController.myGame = new com.mygdx.game.MyGdxGame();
                    WorldController.myGame.create();
                    bigLoaded = true;
                    loadingTarget = "IDLE";
                    CurState.curLevelNum = 1;
                    break;
                case "SNOW":
                    WorldController.snowLand = new Level("SnowLand/SnowLand.tmx", "SnowLand/SnowLandBackGround.tmx");
                    WorldController.snowLand.setWeather("SNOW");
                    snowLoaded = true;
                    loadingTarget = "IDLE";
                    CurState.curLevelNum = 2;
                    break;
                case "FIRE":
                    WorldController.fireMap = new Level("FireMap/fire.tmx", "FireMap/fireBackground.tmx");
                    WorldController.fireMap.setWeather("STONE");
                    fireLoaded = true;
                    loadingTarget = "IDLE";
                    CurState.curLevelNum = 3;
                    break;
                case "GREEN":
                    WorldController.greenMap = new Level("GreenMap/green.tmx", "GreenMap/greenBackground.tmx");
                    WorldController.greenMap.setWeather("RAIN");
                    greenLoaded = true;
                    loadingTarget = "IDLE";
                    CurState.curLevelNum = 4;
                    break;
                default:
                    break;
            }
        }
    }

    public static void loadWorld()
    {
        loadingTarget = "WORLD";
        CurState.curLevelNum = -1;
    }
    public static void loadSnow()
    {
        loadingTarget = "SNOW";
        CurState.curLevelNum = -1;
    }
    public static void loadFire()
    {
        loadingTarget = "FIRE";
        CurState.curLevelNum = -1;
    }
    public static void loadGreen()
    {
        loadingTarget = "GREEN";
        CurState.curLevelNum = -1;
    }

    public static boolean isBigLoaded() {
        return bigLoaded;
    }

    public static boolean isFireLoaded() {
        return fireLoaded;
    }

    public static boolean isGreenLoaded() {
        return greenLoaded;
    }

    public static boolean isSnowLoaded() {
        return snowLoaded;
    }
}
