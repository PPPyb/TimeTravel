package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tutorials {

    SpriteBatch batch;
    Texture tutorial;
    Texture tutorial2;
    int curLevelNum = 0;
    int tCnt = 0;

    public Tutorials()
    {
        batch = new SpriteBatch();
        tutorial = new Texture("MainTitle/Tutorial.jpg");
        tutorial2 = new Texture("MainTitle/Tutorial2.jpg");
    }
    public void setCurLevelNum(int num)
    {
        this.curLevelNum = num;
    }
    public void render()
    {
        batch.begin();
        if(tCnt%2==0)
            batch.draw(tutorial,0,0,1280,720);
        else
            batch.draw(tutorial2,0,0,1280,720);
        batch.end();
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            CurState.curLevelNum = this.curLevelNum;
        if(Gdx.input.isKeyJustPressed(Input.Keys.A))
            tCnt++;
        if(Gdx.input.isKeyJustPressed(Input.Keys.D))
            tCnt++;
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT))
            tCnt++;
    }


}
