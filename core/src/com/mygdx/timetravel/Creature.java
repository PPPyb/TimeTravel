package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

//生物类，包括，主角，敌人，和人畜无害小动物。
public class Creature extends AbstractGameObject{
    //生物的图像
    Texture img;
    TextureRegion[][] frames;
    TextureRegion curFrame;
    //生物的行走\跳跃状态
    String walkState;
    String jumpState;

    //生物属性
    int maxHP;//最大血量
    int curHP;//当前血量

    Boolean isAlive;
    public Creature(float x,float y)
    {
        super(x,y);
        walkState = new String();
        jumpState = new String();
        isAlive = true;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public void update(float deltaTime,Level level) {
        stateTime += deltaTime;
        //update velocity
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
        //update position
        float xOffset = velocity.x * deltaTime;
        float yOffset = velocity.y * deltaTime;

        if(this.onCollisionWithMap(level,xOffset,0))
            velocity.x = 0;
        else
            position.x += xOffset;

        if(this.onCollisionWithMap(level,0,yOffset))
            velocity.y = 0;
        else
            position.y += yOffset;
        setBounds();
    }
    public void move(int speed)
    {
        switch (walkState)
        {
            case "LEFT":
                this.velocity.x = -speed;
                break;
            case "RIGHT":
                this.velocity.x = speed;
                break;
            case "IDLE":
                this.velocity.x = 0;
                break;
            default:
                break;
        }
    }

    public void jump(int speed)
    {
        switch (jumpState) {
            case "JUMPING":
                this.velocity.y = speed;
                break;
            case "DROPPING":
                break;
            case "IDLE":
                break;
            default:
                break;
        }
    }

    public void loseHP(int HP)
    {
        if(curHP - HP > 0)
            curHP -= HP;
        else
        {
            curHP = 0;
            isAlive = false;//挂了
            die();
        }
    }

    public void restoreHP(int HP)
    {
        if(curHP + HP > maxHP)
            curHP = maxHP;
        else
            curHP += HP;
    }

    public void draw(Batch batch)
    {
        batch.draw(curFrame,this.getX(),this.getY());
    }

    public void die()
    {

    }


}
