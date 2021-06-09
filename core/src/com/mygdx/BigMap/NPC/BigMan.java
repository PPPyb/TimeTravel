package com.mygdx.BigMap.NPC;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mygdx.BigMap.*;
import com.mygdx.BigMap.Communication.NpcCommunication;
import com.mygdx.BigMap.Screen.PlayScreen;
import com.mygdx.BigMap.Screen.powerRoomScreen;
import com.mygdx.BigMap.otherActor.NPC;

public class BigMan extends NPC {
    private Animation BigManLeftRun;
    private Animation BigManRightRun;
    private float stateTime;
    private Animation BigManUpRun;
    private Array<TextureRegion> frames;
    private Animation turnAround;
    public BodyDef bdef;
    private boolean back=true;
    public static boolean BigManFlag=false;
    public BigMan(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getAtlasBigMan().findRegion("BigMan"),48*i,147,48,49));
        BigManUpRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getAtlasBigMan().findRegion("BigMan"),48*i,49,48,49));
        BigManLeftRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getAtlasBigMan().findRegion("BigMan"),48*i,98,48,49));
        BigManRightRun=new Animation(0.1f,frames);
        frames.clear();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getAtlasBigMan().findRegion("BigMan"),48*i,0,48,49));
        turnAround=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),50,50);
    }
    @Override
    protected void defineNPC(float x, float y) {
        bdef=new BodyDef();
        //NPC初始位置
        bdef.position.set(x,y);
        bdef.type=BodyDef.BodyType.KinematicBody;
        b2body=world.createBody(bdef);

        FixtureDef fdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(30/ MyGdxGame.PPM);
        //NPC分类
        fdef.filter.categoryBits=MyGdxGame.NPC_BIT;
        //NPC可以交互的对象
        fdef.filter.maskBits=MyGdxGame.DOOR_BIT | MyGdxGame.DEFAULT_BIT | MyGdxGame.NPC_BIT | MyGdxGame.Brick_BIT | MyGdxGame.MARIO_BIT;
        fdef.shape=shape;
        fdef.filter.categoryBits=MyGdxGame.NPC_OBJECT_BIT;
        b2body.createFixture(fdef).setUserData(this);
    }
    public void update(float dt) {
        stateTime += dt;
        if(BigManFlag) {
            b2body.setLinearVelocity(0, 0);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) BigManUpRun.getKeyFrame(stateTime, true));
        }
        if(BigManFlag && powerRoomScreen.powerRoomScreenFlag==0 && NpcCommunication.BigManCount==5){
            b2body.setLinearVelocity(0,50);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) BigManUpRun.getKeyFrame(stateTime, true));
        }
        else {
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion((TextureRegion) turnAround.getKeyFrame(stateTime, true));
        }
    }
    @Override
    public void hitOnNPC() {
        //PlayScreen.collisionFlag=1;
        BigManFlag=true;
    }
}
