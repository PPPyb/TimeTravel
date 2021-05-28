package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;

import java.math.*;
public class EnemyAI {
    Enemy enemy;

    float stateTime = 0;

    float patternTime = 0;
    float patternInterval = 3;

    float attackTime = 0;
    float attackInterval = 3;

    float jumpTime = 0;
    float jumpInterval = 3;

    float jumpRate = 10;

    public EnemyAI(Enemy enemy)
    {
        this.enemy = enemy;
    }
    public void act() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        stateTime += deltaTime;
        patternTime += deltaTime;
        attackTime += deltaTime;
        jumpTime += deltaTime;

        discover();

        if(patternTime > patternInterval)
        {
            pattern();;
            patternTime = 0;
        }

        if(attackTime > attackInterval)
        {
            attack();
            attackTime = 0;
        }

        if(jumpTime > jumpInterval)
        {
            jump();
            jumpTime = 0;
        }

        enemy.move(enemy.walkSpeed);

        enemy.jump((int)(enemy.walkSpeed * jumpRate));
        enemy.dash();
        enemy.jumpState = "IDLE";

    }

    public void discover()
    {
        if(!enemy.discovered&&Math.sqrt((enemy.level.curPlayer.getX()-enemy.getX())*(enemy.level.curPlayer.getX()-enemy.getX())+(enemy.level.curPlayer.getY()-enemy.getY())*(enemy.level.curPlayer.getY()-enemy.getY()))<enemy.sight)
        {
            enemy.alerted();
        }
    }
    public void pattern() {} //move pattern
    public void jump() {}
    public void attack() {}
}
