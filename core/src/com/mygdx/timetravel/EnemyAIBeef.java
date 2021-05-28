package com.mygdx.timetravel;

public class EnemyAIBeef extends EnemyAI{
    public EnemyAIBeef(Enemy enemy)
    {
        super(enemy);
        patternInterval = 1;
        attackInterval = 3;
        jumpInterval = 1;
        jumpRate = 1;
    }

    @Override
    public void pattern() {
        if(enemy.getX()-enemy.level.curPlayer.getX()>800)
            enemy.walkState="IDLE";
        if(enemy.getX()>enemy.level.curPlayer.getX())
            enemy.walkState="LEFT";
        else if(enemy.getX()<enemy.level.curPlayer.getX())
            enemy.walkState="RIGHT";
    }

    @Override
    public void jump() {
        int jumpDecision = (int)(Math.random()*5);
        switch (jumpDecision)
        {
            case 0:
                enemy.jumpState = "JUMPING";
                break;
            default:
                enemy.jumpState = "IDLE";
                break;
        }
        if(enemy.level.curPlayer.getY()>enemy.getY())
            enemy.jumpState = "JUMPING";
    }

    @Override
    public void attack() {
         enemy.attack();
    }
}
