package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainTitle {
    SpriteBatch batch;
    Texture bkg;
    Texture anykey;
    Texture timetravel;
    float bkgOffset = 0;
    float stateTime = 0;
    public MainTitle()
    {
        batch = new SpriteBatch();
        bkg = new Texture(Gdx.files.internal("MainTitle/background.jpg"));
        //anykey = new Texture(Gdx.files.internal("MainTitle/anykey.png"));
        timetravel = new Texture(Gdx.files.internal("MainTitle/timetravel.png"));
    }
    public void render()
    {
        MusicManager.playMusic(10);
        float deltaTime = Gdx.graphics.getDeltaTime();
        stateTime += deltaTime;
        bkgOffset += deltaTime * 100;
        if(bkgOffset > Constants.WINDOWS_WIDTH)
            bkgOffset = 0;

        batch.begin();
        batch.draw(bkg,-bkgOffset,0);
        batch.draw(bkg,0,0);
        //batch.draw(timetravel,Constants.WINDOWS_WIDTH/2-timetravel.getWidth()/2,400);
        if(((int)bkgOffset)%100<50)
            batch.draw(anykey,Constants.WINDOWS_WIDTH/2-anykey.getWidth()/2,100);
        batch.end();

        if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)||Gdx.input.isTouched())
            CurState.curLevelNum = 1;
    }
}
