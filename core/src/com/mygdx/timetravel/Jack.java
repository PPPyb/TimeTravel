package com.mygdx.timetravel;

import com.badlogic.gdx.math.Vector2;

public class Jack extends Player{


    public Jack(float x, float y, Level level)
    {
        super(x,y,level);
        name = "Jack";
        //属性
        strength = 20;
        agility = 15;
        intelligence = 15;
        init();
    }


    @Override
    public void eventLEFT(int relativeX, int relativeY, int absoluteX, int absoluteY) {
        if(!level.magicHelper.jack.casting) {
            level.bulletTitanic.setPosition(new Vector2(getX(), getY()));
            level.bulletTitanic.setVelocity(new Vector2(100, 0));
        }
        level.magicHelper.jack.cast();
    }

    @Override
    public void eventRight(int relativeX,int relativeY,int absoluteX,int absoluteY) {

    }

    @Override
    public void eventQ() {

    }

    @Override
    public void eventE() {

    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}
