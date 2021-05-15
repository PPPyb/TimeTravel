package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/*
-------------------------------------------------------------------------------------------------
测试用主角，工具人，用完就删。
 */
public class Kirito extends Player{

    TextureRegion[] walkFrames;
    TextureRegion[] walkFrames2;
    Animation walkAni;
    Animation walkAni2;


    public Kirito(float x, float y, Level level)
    {
        super(x,y,level);
    }

    @Override
    public void initState() {
        name = "KIRITO";
        stateTime = 0;
        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
        //属性
        strength = 15;
        agility = 15;
        intelligence = 10;
    }

    @Override
    public void initAnime() {
        img = new Texture(Gdx.files.internal("testMap/Kirito.png"));
        frames = TextureRegion.split(img,img.getWidth()/4,img.getHeight()/4);
        walkFrames = new TextureRegion[4];
        for(int i = 0;i < 4;i++)
            walkFrames[i] = frames[2][i];
        walkFrames2 = new TextureRegion[4];
        for(int i = 0;i < 4;i++)
            walkFrames2[i] = frames[1][i];
        curFrame = new TextureRegion();
        curFrame = frames[0][0];
        walkAni = new Animation(0.2f,walkFrames);
        walkAni.setPlayMode(Animation.PlayMode.LOOP);
        walkAni2= new Animation(0.2f,walkFrames2);
        walkAni2.setPlayMode(Animation.PlayMode.LOOP);
        this.setAcceleration(Constants.GRAVITY);

        imgHead = new TextureRegion(new Texture(Gdx.files.internal("testMap/Khead.jpg")));
    }

    @Override
    public void updateAnime() {
        if(jumpState=="JUMPING")
            curFrame =frames[0][0];
        else if (walkState=="RIGHT")
            curFrame = (TextureRegion) walkAni.getKeyFrame(stateTime,true);
        else if(walkState=="LEFT")
            curFrame = (TextureRegion) walkAni2.getKeyFrame(stateTime,true);
        else
            curFrame = frames[0][0];
    }

    @Override
    public void eventLEFT(int relativeX, int relativeY, int absoluteX, int absoluteY) {
        float relativeXY = (float) Math.sqrt(relativeX*relativeX+relativeY*relativeY);
        float sin = relativeX/relativeXY;
        float cos = relativeY/relativeXY;
        float velX = BulletTestPenetrate.speed * sin;
        float velY = BulletTestPenetrate.speed * cos;
        shoot(velX,velY);
    }

    public void shoot(float x, float y)
    {
        if(curMP- BulletTest.MPConsume>0) {
            level.bulletTestPenetrate[level.bulletTestPenetrateCnt] = new BulletTestPenetrate(getX()+width/2, getY()+height/2,level);
            level.bulletTestPenetrate[level.bulletTestPenetrateCnt].setVelocity(new Vector2(x, y));
            level.bulletTestPenetrateCnt++;
            loseMP(BulletTestPenetrate.MPConsume);
        }
    }

    @Override
    public void die() {
        curFrame = new TextureRegion(new Texture(Gdx.files.internal("testMap/die.png")));
    }
}
