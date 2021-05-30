package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Misaka extends Player{


    public Misaka(float x, float y, Level level)
    {
        super(x,y,level);
        name = "Misaka";
        //属性
        strength = 20;
        agility = 20;
        intelligence = 20;
        init();
    }


    @Override
    public void eventLEFT(int relativeX, int relativeY, int absoluteX, int absoluteY) {
        if(level.magicHelper.misakaQ.casting) {
            //超电磁炮
            int MPLose = 20;
            if (curMP>MPLose)
            {
                if (level.railgunCut > 950)
                    level.railgunCut = 0;

            if (relativeX > 0) {
                level.railgun[level.railgunCut] = new Railgun(getX() - 50, getY() - 50, level, true);
                level.railgun[level.railgunCut].setVelocity(new Vector2(1000, 0));
            } else {
                level.railgun[level.railgunCut] = new Railgun(getX() - 50, getY() - 50, level, false);
                level.railgun[level.railgunCut].setVelocity(new Vector2(-1000, 0));
            }
            level.railgunCut++;
                loseMP(MPLose);
            }
        }

        if(!level.magicHelper.misakaQ.casting)
        {
            //普通子弹
            if(curMP- BulletDangMa.MPConsume>0) {
                Boolean toRight;
                if(relativeX>0)
                    toRight = true;
                else
                    toRight = false;

                if(level.bulletDangMasCnt>900)
                    level.bulletDangMasCnt = 0;
                level.bulletDangMas[level.bulletDangMasCnt] = new BulletDangMa(getX()+width/2, getY()+height,level);
                level.bulletDangMas[level.bulletDangMasCnt].setVelocity(new Vector2(0, 0));
                if(toRight)
                    level.bulletDangMas[level.bulletDangMasCnt].setAcceleration(new Vector2(10, 0));
                else
                    level.bulletDangMas[level.bulletDangMasCnt].setAcceleration(new Vector2(-10, 0));
                level.bulletDangMasCnt++;
                loseMP(BulletDangMa.MPConsume);
            }
        }
    }

    @Override
    public void eventRight(int relativeX,int relativeY,int absoluteX,int absoluteY) {
        if(curMP- BulletDangMa.MPConsume>0) {
            Boolean toRight;
            if(relativeX>0)
                toRight = true;
            else
                toRight = false;

            if(level.bulletDangMasCnt>900)
                level.bulletDangMasCnt = 0;
            level.bulletDangMas[level.bulletDangMasCnt] = new BulletDangMa(getX()+width/2, getY()+height,level);
            level.bulletDangMas[level.bulletDangMasCnt].setVelocity(new Vector2(0, 0));
            if(toRight)
                level.bulletDangMas[level.bulletDangMasCnt].setAcceleration(new Vector2(10, 0));
            else
                level.bulletDangMas[level.bulletDangMasCnt].setAcceleration(new Vector2(-10, 0));
            level.bulletDangMasCnt++;
            loseMP(BulletDangMa.MPConsume);
        }
    }

    @Override
    public void eventQ() {
        if (curMP - level.misakaEskillEffect.MPConsume > 0 && !level.magicHelper.misakaQ.casting&&level.magicHelper.misakaQ.CD<0)
        {
            level.magicHelper.misakaQ.cast();
            imgFace = new TextureRegion(new Texture(Gdx.files.internal("Players/"+"MisakaNB"+"Face.jpg")));
            img = new Texture(Gdx.files.internal("Players/"+"MisakaNB"+"Walk.png"));
            frames = TextureRegion.split(img,48,48);

            walkLeftFrames = new TextureRegion[3];
            for(int i = 0;i < 3;i++)
                walkLeftFrames[i] = frames[1][i];

            walkRightFrames = new TextureRegion[3];
            for(int i = 0;i < 3;i++)
                walkRightFrames[i] = frames[2][i];

            standFrame = new TextureRegion();
            standFrame = frames[0][0];

            curFrame = new TextureRegion();
            curFrame = standFrame;

            walkLeftAni = new Animation(0.2f, walkLeftFrames);
            walkLeftAni.setPlayMode(Animation.PlayMode.LOOP);

            walkRightAni= new Animation(0.2f,walkRightFrames);
            walkRightAni.setPlayMode(Animation.PlayMode.LOOP);
            loseMP(level.misakaEskillEffect.MPConsume);
        }
    }

    @Override
    public void eventE() {
        if (curMP - level.misakaEskillEffect.MPConsume > 0 && !level.magicHelper.misakaE.casting)
        {
            level.magicHelper.misakaE.setCastPositon(getX(),getY()-level.misakaEskillEffect.height/4);
            level.magicHelper.misakaE.cast();
            loseMP(level.misakaEskillEffect.MPConsume);
        }
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}
