package com.mygdx.SmallMap.LevelFrame;

public class EnemyAIBeef extends EnemyAI{
    public EnemyAIBeef(Enemy enemy)
    {
        super(enemy);
        patternInterval = 2;
        attackInterval = 3;
        jumpInterval = 2;
        jumpRate = 10;


    }

    @Override
    public void pattern() {
        if(enemy.discovered) {
            if (Math.abs(enemy.getX() - enemy.level.curPlayer.getX()) < enemy.width)
                enemy.walkState = "IDLE";
            else if (enemy.getX() > enemy.level.curPlayer.getX())
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
        if(enemy.discovered)
            enemy.attack();
    }
}
