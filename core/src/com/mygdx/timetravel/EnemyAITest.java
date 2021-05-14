package com.mygdx.timetravel;

public class EnemyAITest extends EnemyAI{
    public EnemyAITest(Enemy enemy)
    {
        super(enemy);
        patternInterval = 3;
        attackInterval = 1;
        jumpInterval = 2;
    }

    @Override
    public void pattern() {
        int walkDecision = (int) (Math.random() * 3);
        switch (walkDecision) {
            case 0:
                enemy.walkState = "LEFT";
                break;
            case 1:
                enemy.walkState = "RIGHT";
                break;
            case 2:
                enemy.walkState = "IDLE";
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
    }

    @Override
    public void attack() {
        for(int i = 0;i < 6;i++)
         enemy.attack();
    }
}
