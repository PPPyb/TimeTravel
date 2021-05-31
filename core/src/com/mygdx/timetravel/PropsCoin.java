package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PropsCoin extends AbstractGameObject{
    Texture img;
    TextureRegion curFrame;
    //道具被销毁
    Boolean isDestructed = false;
    //收益

    public PropsCoin(float x, float y, Level level) {
        super(x, y, level);
        initAnime();
    }

    public void update(float deltaTime) {
        if (isDestructed)
            return;
        updateAnime();
    }

    public void initAnime(){};
    public void updateAnime(){}

    public void initCoin(){
        img = new Texture(Gdx.files.internal("SnowLand//slice136.png"));
        curFrame = new TextureRegion(img);
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }

    public void draw(Batch batch){
        batch.draw(curFrame,this.getX(),this.getY());
    }

    public void destructed(){
        this.setPosition(new Vector2(-10000,-10000));
        isDestructed = true;
    }


    public void collidePlayer(){
        Player player = level.curPlayer;
        Rectangle r1 = new Rectangle(getX(),getY(),width,height);
        Rectangle r2 = new Rectangle(player.getX(),player.getY(),player.width,player.height);
        if(Intersector.overlaps(r1,r2)){
            this.destructed();
        }
    }



}
