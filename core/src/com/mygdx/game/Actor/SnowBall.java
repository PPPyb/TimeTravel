package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.*;

public class SnowBall extends NPC{
    private float stateTime;
    private Animation SnowBallRun;
    private Array<TextureRegion> frames;
    private boolean Stop=true;
    private boolean back=true;
    public BodyDef bdef;
    public SnowBall(PlayScreen screen, float x, float y) {
        super(screen, 500,500);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getSnowBallAtlas().findRegion("ball"),48*i,96,48,48));
        SnowBallRun=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    public SnowBall(SnowMapScreen screen, float x, float y) {
        super(screen, x,y);
        frames=new Array<TextureRegion>();
        for(int i=6;i<9;i++)
            frames.add(new TextureRegion(screen.getSnowBallAtlas().findRegion("ball"),48*i,96,48,48));
        SnowBallRun=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    public SnowBall(FireMapScreen screen, float x, float y) {
        super(screen, x,y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getSnowBallAtlas().findRegion("ball"),48*i,96,48,48));
        SnowBallRun=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    public SnowBall(GrassMapScreen screen, float x, float y) {
        super(screen, x,y);
        frames=new Array<TextureRegion>();
        for(int i=3;i<6;i++)
            frames.add(new TextureRegion(screen.getSnowBallAtlas().findRegion("ball"),48*i,96,48,48));
        SnowBallRun=new Animation(0.1f,frames);
        frames.clear();
        stateTime=0;
        setBounds(getX(),getY(),24,24);
    }
    public void update(float dt) {
        stateTime += dt;
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
        setRegion((TextureRegion) SnowBallRun.getKeyFrame(stateTime, true));
    }
    @Override
    protected void defineNPC(float x, float y) {
        bdef=new BodyDef();
        //NPC初始位置
        bdef.position.set(x,y);
        if(x<500) {
            bdef.type = BodyDef.BodyType.DynamicBody;
            bdef.linearVelocity.set(10, 0);
        }
        else
            bdef.type=BodyDef.BodyType.StaticBody;//731,199,731,446
        b2body=world.createBody(bdef);
        FixtureDef fdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(8/ MyGdxGame.PPM);
        //NPC分类
        fdef.filter.categoryBits=MyGdxGame.NPC_BIT;
        //NPC可以交互的对象
        fdef.filter.maskBits=MyGdxGame.DOOR_BIT | MyGdxGame.DEFAULT_BIT | MyGdxGame.NPC_BIT | MyGdxGame.Brick_BIT | MyGdxGame.MARIO_BIT;
        fdef.shape=shape;
        fdef.filter.categoryBits=MyGdxGame.NPC_OBJECT_BIT;
        b2body.createFixture(fdef).setUserData(this);
    }
    protected void defineStaticNPC(float x, float y) {
        bdef=new BodyDef();
        //NPC初始位置
        bdef.position.set(x,y);
        bdef.type=BodyDef.BodyType.StaticBody;
        //bdef.linearVelocity.set(10,0);//731,199,731,446
        b2body=world.createBody(bdef);

        FixtureDef fdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(5/ MyGdxGame.PPM);
        //NPC分类
        fdef.filter.categoryBits=MyGdxGame.NPC_BIT;
        //NPC可以交互的对象
        fdef.filter.maskBits=MyGdxGame.DOOR_BIT | MyGdxGame.DEFAULT_BIT | MyGdxGame.NPC_BIT | MyGdxGame.Brick_BIT | MyGdxGame.MARIO_BIT;
        fdef.shape=shape;
        fdef.filter.categoryBits=MyGdxGame.NPC_OBJECT_BIT;
        b2body.createFixture(fdef).setUserData(this);
    }

    @Override
    public void hitOnNPC() {

    }
}
