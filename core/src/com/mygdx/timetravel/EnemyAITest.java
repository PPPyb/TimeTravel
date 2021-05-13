package com.mygdx.timetravel;

public class EnemyAITest extends EnemyAI{
    public EnemyAITest(Enemy enemy)
    {
        super(enemy);
        patternTime = 3;
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
        int jumpDecision = (int)(Math.random()*5);
        //System.out.println(jumpDecision);
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
}
