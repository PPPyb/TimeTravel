package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.*;

public class Mario extends Sprite {
    public enum State{STANDING,PARALLELRUNNING,UPRUNNING,DOWNRUNNING}
    public State currentState;
    public State previousState;
    public World world;
    public Body  b2body;
    private TextureRegion marioStand;
    private Animation marioParallelRun;
    private Animation marioUpRun;
    private Animation marioDownRun;
    private float stateTimer;
    private boolean runningRight;
    public boolean flag=true;
    public Mario(World world, PlayScreen screen){
        super(screen.getAtlas().findRegion("monkey"));
        this.world=world;
        currentState=State.STANDING;
        previousState=State.STANDING;
        stateTimer=0;
        runningRight=true;
        Array<TextureRegion> frame=new Array<TextureRegion>();
        //右跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,98,48,49));
        marioParallelRun=new Animation(0.1f,frame);
        frame.clear();
        //左跑
        //上跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,147,48,49));
        marioUpRun=new Animation(0.1f,frame);
        frame.clear();
        //下跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,0,48,49));
        marioDownRun=new Animation(0.1f,frame);
        frame.clear();
        marioStand=new TextureRegion(getTexture(),0,0,48,49);
        //defineMario(220,711);
        defineMario();
        setBounds(600,100,16,16);
        setRegion(marioStand);
    }
    public Mario(World world, weaponRoomScreen screen){
        super(screen.getAtlas().findRegion("monkey"));
        this.world=world;
        currentState=State.STANDING;
        previousState=State.STANDING;
        stateTimer=0;
        runningRight=true;
        Array<TextureRegion> frame=new Array<TextureRegion>();
        //右跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,98,48,49));
        marioParallelRun=new Animation(0.1f,frame);
        frame.clear();
        //左跑
        //上跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,147,48,49));
        marioUpRun=new Animation(0.1f,frame);
        frame.clear();
        //下跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,0,48,49));
        marioDownRun=new Animation(0.1f,frame);
        frame.clear();
        marioStand=new TextureRegion(getTexture(),0,0,48,49);
        defineMario(175,15);
        setBounds(600,100,16,16);
        setRegion(marioStand);
    }
    public Mario(World world, OutsideweaponRoomScreen screen){
        super(screen.getAtlas().findRegion("monkey"));
        this.world=world;
        currentState=State.STANDING;
        previousState=State.STANDING;
        stateTimer=0;
        runningRight=true;
        Array<TextureRegion> frame=new Array<TextureRegion>();
        //右跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,98,48,49));
        marioParallelRun=new Animation(0.1f,frame);
        frame.clear();
        //左跑
        //上跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,147,48,49));
        marioUpRun=new Animation(0.1f,frame);
        frame.clear();
        //下跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,0,48,49));
        marioDownRun=new Animation(0.1f,frame);
        frame.clear();
        marioStand=new TextureRegion(getTexture(),0,0,48,49);
        defineMario(220,711);
        setBounds(600,100,16,16);
        setRegion(marioStand);
    }
    public Mario(World world, repairmanHomeScreen screen){
        super(screen.getAtlas().findRegion("monkey"));
        this.world=world;
        currentState=State.STANDING;
        previousState=State.STANDING;
        stateTimer=0;
        runningRight=true;
        Array<TextureRegion> frame=new Array<TextureRegion>();
        //右跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,98,48,49));
        marioParallelRun=new Animation(0.1f,frame);
        frame.clear();
        //左跑
        //上跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,147,48,49));
        marioUpRun=new Animation(0.1f,frame);
        frame.clear();
        //下跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,0,48,49));
        marioDownRun=new Animation(0.1f,frame);
        frame.clear();
        marioStand=new TextureRegion(getTexture(),0,0,48,49);
        defineMario(226,25);
        setBounds(600,100,16,16);
        setRegion(marioStand);
    }
    public Mario(World world, OutsiderepairmanHomeScreen screen){
        super(screen.getAtlas().findRegion("monkey"));
        this.world=world;
        currentState=State.STANDING;
        previousState=State.STANDING;
        stateTimer=0;
        runningRight=true;
        Array<TextureRegion> frame=new Array<TextureRegion>();
        //右跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,98,48,49));
        marioParallelRun=new Animation(0.1f,frame);
        frame.clear();
        //左跑
        //上跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,147,48,49));
        marioUpRun=new Animation(0.1f,frame);
        frame.clear();
        //下跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,0,48,49));
        marioDownRun=new Animation(0.1f,frame);
        frame.clear();
        marioStand=new TextureRegion(getTexture(),0,0,48,49);
        defineMario(1015,350);
        setBounds(600,100,16,16);
        setRegion(marioStand);
    }
    public Mario(World world, powerRoomScreen screen){
        super(screen.getAtlas().findRegion("monkey"));
        this.world=world;
        currentState=State.STANDING;
        previousState=State.STANDING;
        stateTimer=0;
        runningRight=true;
        Array<TextureRegion> frame=new Array<TextureRegion>();
        //右跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,98,48,49));
        marioParallelRun=new Animation(0.1f,frame);
        frame.clear();
        //左跑
        //上跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,147,48,49));
        marioUpRun=new Animation(0.1f,frame);
        frame.clear();
        //下跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,0,48,49));
        marioDownRun=new Animation(0.1f,frame);
        frame.clear();
        marioStand=new TextureRegion(getTexture(),0,0,48,49);
        defineMario(217,10);
        setBounds(600,100,16,16);
        setRegion(marioStand);
    }
    public Mario(World world, OutsidepowerRoomScreen screen){
        super(screen.getAtlas().findRegion("monkey"));
        this.world=world;
        currentState=State.STANDING;
        previousState=State.STANDING;
        stateTimer=0;
        runningRight=true;
        Array<TextureRegion> frame=new Array<TextureRegion>();
        //右跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,98,48,49));
        marioParallelRun=new Animation(0.1f,frame);
        frame.clear();
        //左跑
        //上跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,147,48,49));
        marioUpRun=new Animation(0.1f,frame);
        frame.clear();
        //下跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,0,48,49));
        marioDownRun=new Animation(0.1f,frame);
        frame.clear();
        marioStand=new TextureRegion(getTexture(),0,0,48,49);
        defineMario(985,710);
        setBounds(600,100,16,16);
        setRegion(marioStand);
    }
    public Mario(World world, gambleRoomScreen screen){
        super(screen.getAtlas().findRegion("monkey"));
        this.world=world;
        currentState=State.STANDING;
        previousState=State.STANDING;
        stateTimer=0;
        runningRight=true;
        Array<TextureRegion> frame=new Array<TextureRegion>();
        //右跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,98,48,49));
        marioParallelRun=new Animation(0.1f,frame);
        frame.clear();
        //左跑
        //上跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,147,48,49));
        marioUpRun=new Animation(0.1f,frame);
        frame.clear();
        //下跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,0,48,49));
        marioDownRun=new Animation(0.1f,frame);
        frame.clear();
        marioStand=new TextureRegion(getTexture(),0,0,48,49);
        defineMario(460,20);
        setBounds(600,100,16,16);
        setRegion(marioStand);
    }
    public Mario(World world, OutsidegambleRoomScreen screen){
        super(screen.getAtlas().findRegion("monkey"));
        this.world=world;
        currentState=State.STANDING;
        previousState=State.STANDING;
        stateTimer=0;
        runningRight=true;
        Array<TextureRegion> frame=new Array<TextureRegion>();
        //右跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,98,48,49));
        marioParallelRun=new Animation(0.1f,frame);
        frame.clear();
        //左跑
        //上跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,147,48,49));
        marioUpRun=new Animation(0.1f,frame);
        frame.clear();
        //下跑
        for(int i=0;i<3;i++)
            frame.add(new TextureRegion(getTexture(),48*i,0,48,49));
        marioDownRun=new Animation(0.1f,frame);
        frame.clear();
        marioStand=new TextureRegion(getTexture(),0,0,48,49);
        defineMario(273,392);
        setBounds(600,100,16,16);
        setRegion(marioStand);
    }
    public void update(float dt){
//        if(b2body.getPosition().x>171 && b2body.getPosition().x<186 && b2body.getPosition().y<6.70)
//            defineMario(210,711);
//        else
        setPosition(b2body.getPosition().x-getWidth()/2,b2body.getPosition().y-getHeight()/2);
        setRegion(getFrame(dt));
    }
    public TextureRegion getFrame(float dt){
        currentState=getState();
        TextureRegion region;
        switch (currentState){
            case PARALLELRUNNING:
                region= (TextureRegion) marioParallelRun.getKeyFrame(stateTimer,true);
                break;
            case UPRUNNING:
                region= (TextureRegion) marioUpRun.getKeyFrame(stateTimer,true);
                break;
            case DOWNRUNNING:
                region= (TextureRegion) marioDownRun.getKeyFrame(stateTimer,true);
                break;
            case STANDING:
            default:
                region=marioStand;
                break;
        }
        if((b2body.getLinearVelocity().x<0||!runningRight) && !region.isFlipX()){
            region.flip(true,false);
            runningRight=false;
        }
        else  if((b2body.getLinearVelocity().x>0||runningRight)&&region.isFlipX()){
            region.flip(true,false);
            runningRight=true;
        }
        stateTimer=currentState==previousState?stateTimer+dt:0;
        previousState=currentState;
        return region;
    }
    public State getState(){
        if(b2body.getLinearVelocity().x!=0 )
            return State.PARALLELRUNNING;
        else if(b2body.getLinearVelocity().y>0)
            return State.UPRUNNING;
        else if(b2body.getLinearVelocity().y<0)
            return State.DOWNRUNNING;
        else
            return State.STANDING;
    }
    public void defineMario() {
        BodyDef bdef=new BodyDef();
        //主角初始位置
        bdef.position.set(600/ MyGdxGame.PPM,100/MyGdxGame.PPM);
        bdef.type=BodyDef.BodyType.DynamicBody;
        b2body=world.createBody(bdef);
        FixtureDef fdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(5/MyGdxGame.PPM);
        //主角分类
        fdef.filter.categoryBits=MyGdxGame.MARIO_BIT;
        //主角可以交互的对象
        fdef.filter.maskBits=MyGdxGame.DOOR_BIT | MyGdxGame.DEFAULT_BIT | MyGdxGame.NPC_BIT | MyGdxGame.Brick_BIT;
        fdef.shape=shape;
        b2body.createFixture(fdef);
        EdgeShape head=new EdgeShape();
        head.set(new Vector2(-5,5),new Vector2(5,5));
        fdef.shape=head;
        fdef.isSensor=true;
        b2body.createFixture(fdef).setUserData("head");
    }
    public void defineMario(int PositionX, int PositionY) {
        BodyDef bdef=new BodyDef();
        //主角初始位置
        bdef.position.set(PositionX/ MyGdxGame.PPM,PositionY/MyGdxGame.PPM);
        bdef.type=BodyDef.BodyType.DynamicBody;
        b2body=world.createBody(bdef);
        FixtureDef fdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(5/MyGdxGame.PPM);
        //主角分类
        fdef.filter.categoryBits=MyGdxGame.MARIO_BIT;
        //主角可以交互的对象
        fdef.filter.maskBits=MyGdxGame.DOOR_BIT | MyGdxGame.DEFAULT_BIT | MyGdxGame.NPC_BIT | MyGdxGame.Brick_BIT;
        fdef.shape=shape;
        b2body.createFixture(fdef);
        EdgeShape head=new EdgeShape();
        head.set(new Vector2(-5,-5),new Vector2(5,5));
        fdef.shape=head;
        fdef.isSensor=true;
        b2body.createFixture(fdef).setUserData("head");
    }
    public void setXPosition(int xPosition){
        this.b2body.getPosition().x=xPosition;
    }

}
