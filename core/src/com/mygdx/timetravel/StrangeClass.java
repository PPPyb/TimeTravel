package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StrangeClass {

    SpriteBatch batch;
    Texture tutorial;
    TextureRegion whatisthis;
    int curLevelNum = 0;

    public StrangeClass()
    {
        batch = new SpriteBatch();
        tutorial = new Texture("testMap/Strange.jpg");
        whatisthis = new TextureRegion(tutorial);
    }
    public void setCurLevelNum(int num)
    {
        this.curLevelNum = num;
    }
    public void render()
    {
        MusicManager.playMusic(88);
        batch.begin();
        batch.draw(whatisthis,0,0,1280,720);
        batch.end();
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            CurState.curLevelNum = this.curLevelNum;
    }


}
