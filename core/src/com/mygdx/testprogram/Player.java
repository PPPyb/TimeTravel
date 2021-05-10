package com.mygdx.testprogram;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.*;

public class Player {
    int x,y;
    int v = 0;
    int v2 = 0;
    int HP = 100;
    int bulnum = 0;
    int bulnum2 = 0;
    int width = 100;
    int height = 150;
    int id;

    boolean shootLock = false;
    boolean alive = true;
    boolean jumping = false;
    Texture img = new Texture("player.png");
    Bullets[] bullet;
    double angel = 15;
    Player(int x,int y,int id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        bullet = new Bullets[105];
        for(int i = 0;i < 105;i++)
            bullet[i] = new Bullets(id);
    }
    public boolean isJumping()
    {
        return jumping;
    }
    public void anpl()
    {if(angel<45)angel+=0.2;}
    public void anmi()
    {if(angel>-15)angel-=0.2;}
    public void startJumping()
    {
        if(!jumping)
            v = 20;
        jumping = true;

    }
    public void jump(int bound)
    {

        if(jumping) {
            this.y += v;
            v--;
            if(this.y <= bound)
            {
                v = 0;
                this.y = bound;
                jumping = false;
            }
        }
    }
    public void breath(Music rag)
    {
        if(HP <= 0)
        {
            setImg(3);
            alive =false;
            bulnum = 0;
            bulnum2 = 0;
            if(!rag.isPlaying())
            {
                rag.play();
            }
        }
        if(HP > 0)
        {
            alive = true;
            setImg(1);
        }
    }
    public void drop(int bound)
    {
        if(jumping)
            return;
        if(this.y>bound)
        {
            v2--;
            this.y += v2;
        }
        else
        {
            y = bound;
            v2 = 0;
        }

    }

    public void setImg(int type)
    {
        if(alive) {
            if (type == 1)
                img = new Texture("player.png");
            if (type == 2)
                img = new Texture("playerf.png");
        }
        if(type==3)
            img = new Texture("playerdd.png");
    }
    public void shoot(int type,Sound biu)
    {
        biu.play();
        if(!shootLock) {
            setImg(type);
            bullet[bulnum].fire(x, y, type, angel,bulnum);
            bulnum++;
            bulnum2 = bulnum;
            if (bulnum >= 24) {

                shootLock = true;
            }
        }
        else
        {
            bulnum2-=3;
            if(bulnum2 <= 0) {
                bulnum = 0;
                shootLock = false;
            }
        }

    }
}
