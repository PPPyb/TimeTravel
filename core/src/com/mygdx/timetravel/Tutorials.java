package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tutorials {

    SpriteBatch batch;
    Texture tutorial;
    int curLevelNum = 0;

    public Tutorials()
    {
        batch = new SpriteBatch();
        tutorial = new Texture("MainTitle/Tutorial.png");
    }
    public void setCurLevelNum(int num)
    {
        this.curLevelNum = num;
    }
    public void render()
    {
        batch.begin();
        batch.draw(tutorial,0,0);
        batch.end();
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            CurState.curLevelNum = this.curLevelNum;
    }


}
