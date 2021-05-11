package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BackGround extends Actor {
    Texture img;
    public BackGround()
    {
        this.setX(0);
        this.setY(0);
        img = new Texture(Gdx.files.internal("testMap/background.png"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(img,this.getX(),this.getY());
    }
}
