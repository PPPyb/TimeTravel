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
import com.badlogic.gdx.math.Vector2;

//生物类，包括，主角，敌人，和人畜无害小动物。
public class Creature extends AbstractGameObject{
    //生物的图像
    Texture img;
    TextureRegion[][] frames;
    TextureRegion curFrame;
    //生物的行走\跳跃状态\DASH状态
    String walkState;
    String jumpState;
    String dashState;

    //生物属性
    //步速
    int walkSpeed;
    //血量
    float maxHP;//最大血量
    float curHP;//当前血量
    //魔法点
    float maxMP;
    float curMP;
    float MPRestoreRate;
    float MPRestoreRateOrigin;
    //跳跃点
    float maxJumpPoint;
    float curJumpPoint;
    float JPRestoreRate;
    float JPRestoreRateOrigin;
    //Dash点
    float maxDashPoint;
    float curDashPoint;
    float DPRestoreRate;

    Boolean isAlive;
    public Creature(float x,float y,Level level)
    {
        super(x,y,level);
        walkState = new String();
        jumpState = new String();
        dashState = new String();
        isAlive = true;
        curDashPoint = maxDashPoint = 100f;
        stateTime = 0;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public void update(float deltaTime) {
        stateTime += deltaTime;
        //update velocity
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
        //update position
        float xOffset = velocity.x * deltaTime;
        float yOffset = velocity.y * deltaTime;

        if(this.onCollisionWithMap(xOffset,0))
            velocity.x = 0;
        else
            position.x += xOffset;

        if(this.onCollisionWithMap(0,yOffset)) {
            velocity.y = 0;
            dashState = "IDLE";
            jumpState = "IDLE";
        }
        else
            position.y += yOffset;
        setBounds();
    }
    public void restore()
    {
        float deltaTime = Gdx.graphics.getDeltaTime();
        restoreMP(MPRestoreRate * deltaTime);
        if(jumpState=="IDLE"||dashState=="DASHING")
            restoreJP(JPRestoreRate * deltaTime);
        if(dashState=="IDLE")
            restoreDP(DPRestoreRate * deltaTime);
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

    public void dash()
    {
        switch(dashState)
        {
            case "DASHING":
                this.acceleration.y = Constants.GRAVITY.y * Constants.DASHRATE;
                JPRestoreRate = JPRestoreRateOrigin * Constants.DSJPRATE;
                break;
            default:
            case "IDLE":
                this.setAcceleration(Constants.GRAVITY);
                JPRestoreRate = JPRestoreRateOrigin;
                break;
        }
    }

    public void loseHP(float HP)
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

    public void restoreHP(float HP)
    {
        if(curHP + HP > maxHP)
            curHP = maxHP;
        else
            curHP += HP;
    }
    public void loseMP(float MP)
    {
        if(curMP - MP > 0)
            curMP -= MP;
        else
            curMP = 0;
    }

    public void restoreMP(float MP)
    {
        if(curMP + MP > maxMP)
            curMP = maxMP;
        else
            curMP += MP;
    }
    public void loseJP(float JP)
    {
        if(curJumpPoint - JP > 0)
            curJumpPoint -= JP;
        else
            curJumpPoint = 0;
    }

    public void restoreJP(float JP)
    {
        if(curJumpPoint + JP > maxJumpPoint)
            curJumpPoint = maxJumpPoint;
        else
            curJumpPoint += JP;
    }
    public void loseDP(float DP)
    {
        if(curDashPoint - DP > 0)
            curDashPoint -= DP;
        else
            curDashPoint = 0;
    }

    public void restoreDP(float DP)
    {
        if(curDashPoint + DP > maxDashPoint)
            curDashPoint = maxDashPoint;
        else
            curDashPoint += DP;
    }

    public void draw(Batch batch)
    {
        batch.draw(curFrame,this.getX(),this.getY());
    }

    public void die(){}
}
