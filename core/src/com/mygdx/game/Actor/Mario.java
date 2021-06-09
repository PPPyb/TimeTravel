package com.mygdx.game.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
    public Mario(World world, PlayScreen screen,int x,int y){
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
        defineMario(x,y);//77,53
        setBounds(600,100,24,24);
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
        setBounds(600,100,24,24);
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
        defineMario(246,700);
        setBounds(600,100,24,24);
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
        setBounds(600,100,24,24);
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
        defineMario(993,340);
        setBounds(600,100,24,24);
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
        setBounds(600,100,24,24);
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
        defineMario(971,698);
        setBounds(600,100,24,24);
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
        setBounds(600,100,24,24);
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
        defineMario(253,368);
        setBounds(600,100,24,24);
        setRegion(marioStand);
    }
    public Mario(World world, FireMapScreen screen,int x,int y){
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
        defineMario(x,y);
        setBounds(600,100,24,24);
        setRegion(marioStand);
    }
    public Mario(World world, SnowMapScreen screen,int x,int y){
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
        defineMario(x,y);//217,510
        setBounds(600,100,24,24);
        setRegion(marioStand);
    }
    public Mario(World world, PortalScreen screen){
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
        defineMario(1049,1042);
        setBounds(600,100,24,24);
        setRegion(marioStand);
    }
    public Mario(World world, SnowMapRoomScreen screen){
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
        defineMario(374,13);
        setBounds(600,100,24,24);
        setRegion(marioStand);
    }
    public Mario(World world, FireMapRoomScreen screen){
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
        defineMario(229,14);
        setBounds(600,100,24,24);
        setRegion(marioStand);
    }
    public Mario(World world, GrassMapRoomScreen screen){
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
        defineMario(257,14);
        setBounds(600,100,24,24);
        setRegion(marioStand);
    }
    public Mario(World world, GrassMapScreen screen,int x, int y){
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
        defineMario(x,y);
        setBounds(600,100,24,24);
        setRegion(marioStand);
    }
    public void update(float dt){
        setPosition(b2body.getPosition().x-getWidth()/2,b2body.getPosition().y-getHeight()/2);
        setRegion(getFrame(dt));
        if(Gdx.input.isKeyPressed(Input.Keys.W))
            b2body.applyLinearImpulse(new Vector2(0,20),b2body.getWorldCenter(),true);
        else if(Gdx.input.isKeyPressed(Input.Keys.S))
            b2body.applyLinearImpulse(new Vector2(0,-40),b2body.getWorldCenter(),true);
        else if(Gdx.input.isKeyPressed(Input.Keys.D) ) {
            b2body.applyLinearImpulse(new Vector2(50,0), b2body.getWorldCenter(),true);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.A) ) {
            b2body.applyLinearImpulse(new Vector2(-100,0), b2body.getWorldCenter(),true);
        }
        else
            b2body.setLinearVelocity(0,0);


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
        fdef.filter.maskBits=MyGdxGame.DOOR_BIT | MyGdxGame.DEFAULT_BIT | MyGdxGame.NPC_BIT | MyGdxGame.Brick_BIT | MyGdxGame.NPC_OBJECT_BIT;
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
        fdef.filter.maskBits=MyGdxGame.DOOR_BIT | MyGdxGame.DEFAULT_BIT | MyGdxGame.NPC_BIT | MyGdxGame.Brick_BIT | MyGdxGame.NPC_OBJECT_BIT;
        fdef.shape=shape;
        b2body.createFixture(fdef);
        EdgeShape head=new EdgeShape();
        head.set(new Vector2(-5,-5),new Vector2(5,5));
        fdef.shape=head;
        fdef.isSensor=true;
        b2body.createFixture(fdef).setUserData("head");
    }


}
