package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GUIRenderer {
    Level level;
    public GUIRenderer(Level level)
    {
        this.level = level;
    }
    public void render(Batch batch)
    {
        drawPlayerState(batch);
    }
    public void drawPlayerState(Batch batch)
    {
        TextureRegion imgHP = new TextureRegion(new Texture(Gdx.files.internal("GUI/HP.png")));
        TextureRegion imgMP = new TextureRegion(new Texture(Gdx.files.internal("GUI/MP.png")));
        TextureRegion imgJP = new TextureRegion(new Texture(Gdx.files.internal("GUI/JP.png")));
        TextureRegion imgDP = new TextureRegion(new Texture(Gdx.files.internal("GUI/DP.png")));
        batch.draw(imgHP,0,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT,Constants.HPRECWIDTHRATE*level.curPlayer.curHP,Constants.HPRECHEIGHT);
        batch.draw(imgMP,0,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT*2,Constants.HPRECWIDTHRATE*level.curPlayer.curMP,Constants.HPRECHEIGHT);
        batch.draw(imgJP,0,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT*3,Constants.HPRECWIDTHRATE*level.curPlayer.curJumpPoint,Constants.HPRECHEIGHT);
        batch.draw(imgDP,0,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT*4,Constants.HPRECWIDTHRATE*level.curPlayer.curDashPoint,Constants.HPRECHEIGHT);
    }
}
