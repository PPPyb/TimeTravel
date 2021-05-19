package com.mygdx.game.Actor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.*;

public abstract class NPC extends Sprite {
    protected World world;
    protected PlayScreen screen;
    protected OutsidegambleRoomScreen screen1;
    protected OutsideweaponRoomScreen screen2;
    protected OutsidepowerRoomScreen  screen3;
    protected OutsiderepairmanHomeScreen screen4;
    public Body b2body;
    public NPC(PlayScreen screen, float x, float y){
        this.world=screen.getWorld();
        this.screen=screen;
        setPosition(x,y);
        defineNPC();
    }
    public NPC(OutsidegambleRoomScreen screen1, float x, float y){
        this.world=screen1.getWorld();
        this.screen1=screen1;
        setPosition(x,y);
        defineNPC();
    }
    public NPC(OutsideweaponRoomScreen screen2, float x, float y){
        this.world=screen2.getWorld();
        this.screen2=screen2;
        setPosition(x,y);
        defineNPC();
    }
    public NPC(OutsidepowerRoomScreen screen3, float x, float y){
        this.world=screen3.getWorld();
        this.screen3=screen3;
        setPosition(x,y);
        defineNPC();
    }
    public NPC(OutsiderepairmanHomeScreen screen4, float x, float y){
        this.world=screen4.getWorld();
        this.screen4=screen4;
        setPosition(x,y);
        defineNPC();
    }
    protected abstract void defineNPC();
}
