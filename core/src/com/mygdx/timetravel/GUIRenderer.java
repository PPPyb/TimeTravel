package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GUIRenderer {

    Level level;
    TextureRegion imgHP;// = new TextureRegion(new Texture(Gdx.files.internal("GUI/HP.png")));
    TextureRegion imgMP;// = new TextureRegion(new Texture(Gdx.files.internal("GUI/MP.png")));
    TextureRegion imgJP;// = new TextureRegion(new Texture(Gdx.files.internal("GUI/JP.png")));
    TextureRegion imgDP;// = new TextureRegion(new Texture(Gdx.files.internal("GUI/DP.png")));
    Texture victory;
    Texture failed;
    Texture warmheart;
    Texture box;

    BitmapFont myfont;
    public GUIRenderer(Level level)
    {
        this.level = level;
        myfont = new BitmapFont(Gdx.files.internal("myfont.fnt"),false);
        imgHP = new TextureRegion(new Texture(Gdx.files.internal("GUI/HP.png")));
        imgMP = new TextureRegion(new Texture(Gdx.files.internal("GUI/MP.png")));
        imgJP = new TextureRegion(new Texture(Gdx.files.internal("GUI/JP.png")));
        imgDP = new TextureRegion(new Texture(Gdx.files.internal("GUI/DP.png")));
        failed = new Texture(Gdx.files.internal("GUI/failed.png"));
        warmheart = new Texture(Gdx.files.internal("GUI/warmheart.png"));
        victory = new Texture(Gdx.files.internal("GUI/victory.png"));
        box = new Texture(Gdx.files.internal("GUI/box.png"));
    }
    public void render(Batch batch)
    {
        drawPlayerState(batch);
        fpsRender(batch);
    }
    public void fpsRender(Batch batch)
    {
        double fps = Gdx.graphics.getFramesPerSecond();
        myfont.setColor(0,1,0,1);
        myfont.draw(batch,"FPS:"+fps,Constants.WINDOWS_WIDTH-200, Constants.WINDOWS_HEIGHT);
        myfont.setColor(1,1,1,1);
    }
    public void drawPlayerState(Batch batch)
    {
        //
        if(!level.curPlayer.isAlive)
            batch.setColor(1,0,0,1);
        batch.draw(level.curPlayer.imgFace,600,0,80,80);
        batch.setColor(1,1,1,1);
        batch.draw(box,560,0,160,80);
        //
        batch.setColor(0.5f,0.5f,0.5f,0.75f);
        batch.draw(imgHP,160,40,400,40);
        batch.draw(imgJP,160,0,400,40);
        batch.draw(imgMP,720,40,400,40);
        batch.draw(imgDP,720,0,400,40);
        //
        batch.setColor(1,1,1,1);
        batch.draw(imgHP,560-400*level.curPlayer.curHP/level.curPlayer.maxHP,40,400*level.curPlayer.curHP/level.curPlayer.maxHP,40);
        batch.draw(imgJP,560-400*level.curPlayer.curJumpPoint/level.curPlayer.maxJumpPoint,0,400*level.curPlayer.curJumpPoint/level.curPlayer.maxJumpPoint,40);
        batch.draw(imgMP,720,40,400*level.curPlayer.curMP/level.curPlayer.maxMP,40);
        batch.draw(imgDP,720,0,400*level.curPlayer.curDashPoint/level.curPlayer.maxDashPoint,40);
        //
       // myfont.draw(batch,"HP"+(int)level.curPlayer.curHP+"/"+level.curPlayer.maxHP+ " Press T to check Tutorials",0,Constants.WINDOWS_HEIGHT-Constants.HPRECHEIGHT*4);
    }
    public void failedRender(float failedEffect)
    {
        level.guiBatch.setColor(0,0,0,1-failedEffect);
        level.guiBatch.draw(imgHP,0,0,Constants.WINDOWS_WIDTH,Constants.WINDOWS_HEIGHT);
        level.guiBatch.setColor(1,1,1,1);
        level.guiBatch.draw(failed,0,0);
        level.guiBatch.draw(warmheart,0,0);
    }
    public void victoryRender()
    {
        level.guiBatch.draw(victory,0,0);
    }
}
