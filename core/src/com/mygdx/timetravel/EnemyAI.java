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

        enemy.jump(enemy.walkSpeed * 10);
        enemy.jumpState = "IDLE";

    }

    public void pattern() {} //move pattern
    public void jump() {}
    public void attack() {}
}
