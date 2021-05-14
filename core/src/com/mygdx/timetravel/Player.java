package com.mygdx.timetravel;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;

//玩家类
public class Player extends Creature{

    String name;

    public Player(float x,float y,Level level){
        super(x,y,level);
        initAnime();
        initState();

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
    }

    public void initState(){}

    public void initAnime(){}
    public void updateAnime(){}

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
    public void eventE(){}
    public void handlePushQ(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            eventQ();
        }
    }
    public void eventQ(){}
}
