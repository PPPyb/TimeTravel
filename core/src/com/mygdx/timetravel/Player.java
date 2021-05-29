package com.mygdx.timetravel;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

//玩家类
public class Player extends Creature{

    String name;
    TextureRegion imgFace;
    TextureRegion imgDie;
    TextureRegion standFrame;
    TextureRegion walkLeftFrames[];
    TextureRegion walkRightFrames[];
    Animation walkLeftAni;
    Animation walkRightAni;
    float originArmor = 0;
    int originWalkSpeed = 0;

    int strength;
    int intelligence;
    int agility;

    public Player(float x,float y,Level level){
        super(x,y,level);
    }
    public void init()
    {
        initState();
        initAnime();
        convertAttribute();
    }

    public void update(float deltaTime) {
        super.update(deltaTime);
        if(!isAlive)
            return;
        updateAnime();
        //walk
        handleWalk();
        //jump
        handleJump();
        //dash
        handleDash();

        handleClickLEFT();
        handleClickRIGHT();

        handlePushE();
        handlePushQ();

        collideHeart();
    }

    public void initState(){
        stateTime = 0;
        this.setAcceleration(Constants.myGravatiy);
    }

    public void initAnime(){

        img = new Texture(Gdx.files.internal("Players/"+name+"Walk.png"));
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

        imgFace = new TextureRegion(new Texture(Gdx.files.internal("Players/"+name+"Face.jpg")));
        imgDie = TextureRegion.split(new Texture(Gdx.files.internal("Players/"+name+"Die.png")),48,48)[0][0];

        setWidth(curFrame.getRegionWidth());
        setHeight(curFrame.getRegionHeight());
    }
    public void updateAnime(){
        if(jumpState=="JUMPING")
            curFrame = standFrame;
        else if (walkState=="RIGHT")
            curFrame = (TextureRegion) walkRightAni.getKeyFrame(stateTime,true);
        else if(walkState=="LEFT")
            curFrame = (TextureRegion) walkLeftAni.getKeyFrame(stateTime,true);
        else
            curFrame = standFrame;
    }

    public void handleWalk()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.A))
            walkState = "LEFT";
        else if(Gdx.input.isKeyPressed(Input.Keys.D))
            walkState = "RIGHT";
        else
            walkState = "IDLE";
        move(walkSpeed);
    }
    public void handleJump()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            float JPConsumed = Constants.JPCONSUMEDRATE * Gdx.graphics.getDeltaTime();
            if(curJumpPoint - JPConsumed > 0) {
                jumpState = "JUMPING";
                loseJP(JPConsumed);
            }
            else
                jumpState = "DROPPING";
        }
        else if(jumpState != "IDLE")
            jumpState = "DROPPING";
        jump(walkSpeed);
    }
    public void handleDash()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            if(curDashPoint > 99) {
                dashState = "DASHING";
                loseDP(100);
            }
        }
        dash();
    }

    public void handleClickLEFT(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            int relativeX = Gdx.input.getX() - Constants.WINDOWS_WIDTH/2;
            int relativeY = Constants.WINDOWS_HEIGHT/2 - Gdx.input.getY();
            int absoluteX = relativeX + (int) getX();
            int absoluteY = relativeY + (int) getY();
            eventLEFT(relativeX,relativeY,absoluteX,absoluteY);
        }
    }
    public void eventLEFT(int relativeX,int relativeY,int absoluteX,int absoluteY){}
    public void handleClickRIGHT(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
            int relativeX = Gdx.input.getX() - Constants.WINDOWS_WIDTH/2;
            int relativeY = Constants.WINDOWS_HEIGHT/2 - Gdx.input.getY();
            int absoluteX = relativeX + (int) getX();
            int absoluteY = relativeY + (int) getY();
            eventRight(relativeX,relativeY,absoluteX,absoluteY);
        }
    }
    public void eventRight(int relativeX,int relativeY,int absoluteX,int absoluteY){}

    public void handlePushE(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            eventE();
        }
    }
    public void eventE(){

    }
    public void handlePushQ(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            eventQ();
        }
    }
    public void eventQ(){}

    public void convertAttribute()
    {
        //strength
        curHP = maxHP = strength * 20;
        DPRestoreRate = strength;

        //agility
        originWalkSpeed = walkSpeed = agility * 30;
        originArmor = armor = 10 * (agility-10);
        curJumpPoint = maxJumpPoint = agility * 5;
        JPRestoreRate = JPRestoreRateOrigin = agility;

        //intelligence
        curMP = maxMP = intelligence * 30f;
        MPRestoreRate = MPRestoreRateOrigin = intelligence * 3;
    }

    @Override
    public void die() {
        curFrame = imgDie;
    }

    public void collideHeart()
    {
        if(level.map.getLayers().get("HP")==null)
            return;
        MapObjects objects =  level.map.getLayers().get("HP").getObjects();
        for(RectangleMapObject recObj: objects.getByType(RectangleMapObject.class))
        {
            Rectangle r1 = new Rectangle(this.getX(),this.getY(),this.width,this.height);
            Rectangle r2 = recObj.getRectangle();
            if(Intersector.overlaps(r1,r2)) {
                restoreHP(10*Gdx.graphics.getDeltaTime());
            }
        }
    }

}
