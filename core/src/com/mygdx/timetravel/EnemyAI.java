package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;

import java.math.*;
public class EnemyAI {
    Enemy enemy;
    float stateTime = 0;
    int stateCnt = 0;
    int patternTime = 3;
    public EnemyAI(Enemy enemy)
    {
        this.enemy = enemy;
    }
    public void act() {
        stateTime += Gdx.graphics.getDeltaTime();
        stateCnt++;
        //System.out.println((stateTime*1000)%(patternTime*1000));
        if((int)(stateTime*1000)%(patternTime*1000)<50)
             pattern();
        enemy.move(enemy.walkSpeed);
        enemy.jump(enemy.walkSpeed);
    }

    public void pattern() {}
}
