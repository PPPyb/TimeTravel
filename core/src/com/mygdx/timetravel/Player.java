package com.mygdx.timetravel;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;

//玩家类
public class Player extends Creature{

    public Player(float x,float y){
        super(x,y);
    }

    public void update(float deltaTime,Level level) {
        super.update(deltaTime,level);
        if(Gdx.input.isKeyPressed(Input.Keys.A))
            walkState = "LEFT";
        else if(Gdx.input.isKeyPressed(Input.Keys.D))
            walkState = "RIGHT";
        else
            walkState = "IDLE";

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
            jumpState = "JUMPING";
        else
            jumpState = "IDLE";
    }
}
