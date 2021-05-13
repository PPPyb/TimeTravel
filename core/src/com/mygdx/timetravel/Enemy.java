package com.mygdx.timetravel;



//敌人类
public class Enemy extends Creature{

    EnemyAI enemyAI;

    public Enemy(float x,float y,Level level)
    {
        super(x,y,level);
        initAnime();
    }

    @Override
    public void update(float deltaTime) {
        if(!isAlive)
            return;
        super.update(deltaTime);
        updateAnime();
    }

    public void init(){}
    public void initAnime(){}
    public void updateAnime(){}

}
