package com.mygdx.SmallMap.LevelFrame;

import com.mygdx.SmallMap.LevelFrame.Level;
import com.mygdx.SmallMap.LevelFrame.Player;

public class Miku extends Player {


    public Miku(float x, float y, Level level)
    {
        super(x,y,level);
        name = "Miku";
        //属性
        strength = 100;
        agility = 20;
        intelligence = 100;
        init();
    }


    @Override
    public void eventLEFT(int relativeX, int relativeY, int absoluteX, int absoluteY) {

    }

    @Override
    public void eventRight(int relativeX,int relativeY,int absoluteX,int absoluteY) {

    }

    @Override
    public void eventQ() {
        if(!level.magicHelper.miku.casting) {
            level.azuna.isAlive = true;
            level.azuna.curHP = (level.azuna.maxHP);
            level.kirito.isAlive = true;
            level.kirito.curHP = (level.kirito.maxHP);
            level.indix.isAlive = true;
            level.indix.curHP = (level.indix.maxHP);
            level.misaka.isAlive = true;
            level.misaka.curHP = (level.indix.maxHP);
        }
        level.magicHelper.miku.cast();
    }

    @Override
    public void eventE() {

    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}
