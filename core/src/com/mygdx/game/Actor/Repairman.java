package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.*;


public class Repairman extends NPC {
    private float stateTime;
    private Animation repairmanParallelRun;
    private Array<TextureRegion> frames;
    public Repairman(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,98,48,49));
            repairmanParallelRun=new Animation(0.1f,frames);
            stateTime=0;
            setBounds(getX(),getY(),16,16);
    }
    public Repairman(OutsidegambleRoomScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,98,48,49));
        repairmanParallelRun=new Animation(0.1f,frames);
        stateTime=0;
        setBounds(getX(),getY(),16,16);
    }
    public Repairman(OutsideweaponRoomScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,98,48,49));
        repairmanParallelRun=new Animation(0.1f,frames);
        stateTime=0;
        setBounds(getX(),getY(),16,16);
    }
    public Repairman(OutsidepowerRoomScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,98,48,49));
        repairmanParallelRun=new Animation(0.1f,frames);
        stateTime=0;
        setBounds(getX(),getY(),16,16);
    }
    public Repairman(OutsiderepairmanHomeScreen screen, float x, float y) {
        super(screen, x, y);
        frames=new Array<TextureRegion>();
        for(int i=0;i<3;i++)
            frames.add(new TextureRegion(screen.getRepairmanAtlas().findRegion("repairman"),48*i,98,48,49));
        repairmanParallelRun=new Animation(0.1f,frames);
        stateTime=0;
        setBounds(getX(),getY(),16,16);
    }
    public void update(float dt){
        stateTime+=dt;
        setPosition(b2body.getPosition().x-getWidth()/2,b2body.getPosition().y-getHeight()/2);
        setRegion((TextureRegion) repairmanParallelRun.getKeyFrame(stateTime,true));
    }
    @Override
    protected void defineNPC() {
        BodyDef bdef=new BodyDef();
        //NPC初始位置
        bdef.position.set(600,200);
        bdef.type=BodyDef.BodyType.DynamicBody;
        b2body=world.createBody(bdef);
        FixtureDef fdef=new FixtureDef();
        CircleShape shape=new CircleShape();
        shape.setRadius(5/MyGdxGame.PPM);
        //NPC分类
        fdef.filter.categoryBits=MyGdxGame.NPC_BIT;
        //NPC可以交互的对象
        fdef.filter.maskBits=MyGdxGame.DOOR_BIT | MyGdxGame.DEFAULT_BIT | MyGdxGame.NPC_BIT | MyGdxGame.Brick_BIT | MyGdxGame.MARIO_BIT;
        fdef.shape=shape;
        b2body.createFixture(fdef);
    }
}
