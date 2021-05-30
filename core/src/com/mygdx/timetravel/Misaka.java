package com.mygdx.timetravel;

public class Misaka extends Player{


    public Misaka(float x, float y, Level level)
    {
        super(x,y,level);
        name = "Misaka";
        //属性
        strength = 20;
        agility = 20;
        intelligence = 20;
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

    }

    @Override
    public void eventE() {
        if (curMP - level.misakaEskillEffect.MPConsume > 0 && !level.magicHelper.misakaE.casting)
        {
            level.magicHelper.misakaE.setCastPositon(getX(),getY()-level.misakaEskillEffect.height/4);
            level.magicHelper.misakaE.cast();
            loseMP(level.misakaEskillEffect.MPConsume);
        }
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}
