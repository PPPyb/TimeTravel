package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Zeus extends Enemy{

    //frames of animation
    TextureRegion[] idleFrames;
    TextureRegion[] walkLeftFrames;
    TextureRegion[] walkRightFrames;
    TextureRegion[] attackFrames;
    TextureRegion[] attackRFrames;
    TextureRegion[] dieFrames;
    //animation
    Animation idleAni;
    Animation walkLAni;
    Animation walkRAni;
    Animation attackAni;
    Animation attackRAni;
    Animation dieAni;

    float dieTime = 0;
    float attackTime = 0;
    Boolean[] attacked = {false,false,false};


    public Zeus(float x, float y, Level level)
    {
        super(x, y,level);

        init();
    }

    @Override
    public void init() {

        initAnime();
        this.setAcceleration(Constants.myGravatiy);
        curHP = maxHP = 1500f;
        walkSpeed = 50;
        enemyAI = new EnemyAIBeef(this);
    }

    @Override
    public void initAnime() {
        idleFrames = new TextureRegion[20];
        walkLeftFrames = new TextureRegion[20];
        walkRightFrames = new TextureRegion[20];
        attackFrames = new TextureRegion[40];
        attackRFrames = new TextureRegion[40];
        dieFrames = new TextureRegion[50];
        super.init();
        String str = "";
        for(int i = 0;i < 20;i++)
        {
            if(i < 10)
                str = "0";
            else
                str = "";
            Texture temp = new Texture(Gdx.files.internal("Zeus/Idle/Idle_"+str+i+".png"));
            idleFrames[i] = new TextureRegion(temp);
        }
        for(int i = 0;i < 20;i++) {
            if (i < 10)
                str = "0";
            else
                str = "";
            Texture temp = new Texture(Gdx.files.internal("Zeus/Walk/Walk_" + str + i + ".png"));
            walkLeftFrames[i] = new TextureRegion(temp);
            walkRightFrames[i] = new TextureRegion(temp);
            walkRightFrames[i].flip(true, false);
        }
        for(int i = 0;i < 40;i++)
        {
            if(i < 10)
                str = "0";
            else
                str = "";
            Texture temp = new Texture(Gdx.files.internal("Zeus/Attack/Attack_"+str+i+".png"));
            attackFrames[i] = new TextureRegion(temp);
            attackRFrames[i] = new TextureRegion(temp);
            attackRFrames[i].flip(true, false);
        }
        for(int i = 0;i < 50;i++)
        {
            if(i < 10)
                str = "0";
            else
                str = "";
            Texture temp = new Texture(Gdx.files.internal("Zeus/Death/Death_"+str+i+".png"));
            dieFrames[i] = new TextureRegion(temp);
        }

        idleAni = new Animation(0.05f, idleFrames);
        idleAni.setPlayMode(Animation.PlayMode.LOOP);


        walkLAni = new Animation(0.08f, walkLeftFrames);
        walkLAni.setPlayMode(Animation.PlayMode.LOOP);

        walkRAni = new Animation(0.08f, walkRightFrames);
        walkRAni.setPlayMode(Animation.PlayMode.LOOP);

        attackAni = new Animation(0.05f, attackFrames);
        attackAni.setPlayMode(Animation.PlayMode.LOOP);

        attackRAni = new Animation(0.05f, attackRFrames);
        attackRAni.setPlayMode(Animation.PlayMode.LOOP);

        dieAni = new Animation(0.05f, dieFrames);
        dieAni.setPlayMode(Animation.PlayMode.LOOP);

        curFrame = new TextureRegion();
        curFrame = idleFrames[0];
        setWidth(210);
        setHeight(300);
        setBounds();
    }

    @Override
    public void updateAnime() {
        if(!isAlive){
            dieTime += Gdx.graphics.getDeltaTime();
            curFrame = (TextureRegion) dieAni.getKeyFrame(dieTime);
            if(dieTime>2.5)
                curFrame = dieFrames[49];
            return;
        }
        switch (walkState)
        {
            default:
            case "IDLE":
                curFrame = (TextureRegion) idleAni.getKeyFrame(stateTime);
                break;
            case "LEFT":
                curFrame = (TextureRegion) walkLAni.getKeyFrame(stateTime);
                break;
            case "RIGHT":
                curFrame = (TextureRegion) walkRAni.getKeyFrame(stateTime);
                break;
        }
        if(attackTime<2)
        {
            switch (walkState)
            {
                default:
                case "LEFT":
                    curFrame = (TextureRegion) attackAni.getKeyFrame(attackTime);
                    break;
                case "RIGHT":
                    curFrame = (TextureRegion) attackRAni.getKeyFrame(attackTime);
                    break;
            }
        }

        super.updateAnime();
    }

    @Override
    public void update(float deltaTime) {
        attackTime += deltaTime;
        updateAnime();
        super.update(deltaTime);
        if(!isAlive)
            return;
        enemyAI.act();
        if(attackTime>1.25&&!attacked[0]) {
            attacked[0] = true;
            Player player = level.curPlayer;
            Rectangle r1 = new Rectangle(getX(),getY(),width,height);
            Rectangle r2 = new Rectangle(player.getX(),player.getY(),player.width,player.height);
            if(Intersector.overlaps(r1,r2)) {
                player.loseHP(300);
            }

        }
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(curFrame,getX()-190,getY()-100);
        TextureRegion imgHP = new TextureRegion(new Texture(Gdx.files.internal("GUI/HP.png")));
        batch.draw(imgHP,getX(),getY()+height+5,curHP*width/maxHP,5);
    }

    @Override
    public void die() {
        super.die();
//        for(dieTime = 0; dieTime < 35; dieTime++){
//            curFrame = (TextureRegion) dieAni.getKeyFrame(34);
//        }
//        curFrame = (TextureRegion) dieAni.getKeyFrame(stateTime);
    }

    @Override
    public void attack() {
        attackTime = 0;
        for(int i = 0;i < 3;i++)
            attacked[i] = false;
    }
}
