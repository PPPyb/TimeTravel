package com.mygdx.timetravel;



//敌人类
public class Enemy extends Creature{

    EnemyAI enemyAI;
    Boolean discovered = false;
    float sight = 300;

    public Enemy(float x,float y,Level level)
    {
        super(x,y,level);
        initAnime();
    }

    @Override
    public void loseHP(float damage) {
        super.loseHP(damage);
        alerted();
    }

    public void alerted()
    {
        discovered = true;
        walkSpeed*=10;
        enemyAI.jumpRate/=10;
        enemyAI.patternInterval = 0;
        enemyAI.jumpInterval = 1;
    }
    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        if(!isAlive)
            return;
        updateAnime();
    }

    public void init(){}
    public void initAnime(){}
    public void updateAnime(){}

    public void attack(){}

}
