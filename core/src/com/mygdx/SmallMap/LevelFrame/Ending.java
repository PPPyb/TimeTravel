package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Ending {

    SpriteBatch batch;
    WorldController worldController;
    static final int startCnt = 10000;
    static final int endCnt = 11640;
    TextureRegion[] begin;
    Animation beginAni;
    TextureRegion curFrame;
    float stateTime = 0;

    public Ending(WorldController worldController)
    {
        this.worldController = worldController;
        batch = new SpriteBatch();
        initAnime();
    }
    public void initAnime() {

        begin = new TextureRegion[1641];

        for(int i = startCnt;i <= endCnt;i++)
        {
            Texture temp = new Texture(Gdx.files.internal("end/"+i+".png"));
            begin[i-startCnt] = new TextureRegion(temp);
        }

        beginAni = new Animation(0.04f, begin);
        beginAni.setPlayMode(Animation.PlayMode.LOOP);

        curFrame = new TextureRegion();
        curFrame = begin[0];
    }

    public void updateAnime() {
        curFrame = (TextureRegion) beginAni.getKeyFrame(stateTime);
    }

    public void update(float deltaTime) {
        stateTime += deltaTime;
        updateAnime();
    }
    public void render()
    {
        MusicManager.playMusic(2);
        update(Gdx.graphics.getDeltaTime());
        batch.begin();

        batch.draw(curFrame,0,0,1280,720);

        batch.end();
        if(stateTime > 65)
            CurState.curLevelNum = 0;
    }
}
