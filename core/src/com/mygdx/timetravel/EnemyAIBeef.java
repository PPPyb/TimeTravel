package com.mygdx.timetravel;

public class EnemyAIBeef extends EnemyAI{
    public EnemyAIBeef(Enemy enemy)
    {
        super(enemy);
        patternInterval = 3;
        attackInterval = 1;
        jumpInterval = 2;
        jumpRate = 10;


    }

    @Override
    public void pattern() {
        if(enemy.discovered) {
            if (enemy.getX() - enemy.level.curPlayer.getX() < enemy.width)
                enemy.walkState = "IDLE";
            if (enemy.getX() > enemy.level.curPlayer.getX())
                enemy.walkState = "LEFT";
            else if (enemy.getX() < enemy.level.curPlayer.getX())
                enemy.walkState = "RIGHT";
        }
        else
        {
            int walkDecision = (int)(Math.random()*3);
            switch (walkDecision)
            {
                case 0:
                    enemy.walkState = "LEFT";
                    break;
                case 1:
                    enemy.walkState = "RIGHT";
                    break;
                case 2:
                default:
                    enemy.walkState = "IDLE";
                    break;
            }
        }

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
        if(enemy.discovered) {
            if(enemy.level.curPlayer.getY()>enemy.getY())
                enemy.jumpState = "JUMPING";
        }
    }

    @Override
    public void attack() {
        for(int i = 0;i < 6;i++)
            enemy.attack();
    }
}
