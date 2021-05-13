package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;

import java.math.*;
public class EnemyAI {
    Enemy enemy;
    float stateTime = 0;
    int patternTime = 3;
    public EnemyAI(Enemy enemy)
    {
        this.enemy = enemy;
    }
    public void act() {
        stateTime += Gdx.graphics.getDeltaTime();
        if((int)(stateTime*1000)%(patternTime*1000)<20)
             pattern();
        enemy.move(enemy.walkSpeed);
        enemy.jump(enemy.walkSpeed);
    }

    public void pattern() {}
}
