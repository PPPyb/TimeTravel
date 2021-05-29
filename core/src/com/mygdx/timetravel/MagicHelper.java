package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class MagicHelper {
    Level level;
    Player player;
    float deltaTime;
    public MagicHelper(Level level)
    {
        this.level = level;
        player = level.curPlayer;
        azunaQ = new Magic(level);
        azunaQ.setMaxCD(30);
        azunaQ.setMusicEffect(94);
        azunaE = new Magic(level);
        azunaE.setMaxCD(5);
        azunaE.setMusicEffect(93);
        kiritoQ = new Magic(level);
        kiritoQ.setMaxCD(20);
        kiritoQ.setMusicEffect(95);
        kiritoE = new Magic(level);
        kiritoE.setMaxCD(2);
        indixQ = new Magic(level);
        indixQ.setMaxCD(10);
        indixQ.setMusicEffect(96);
        indixE = new Magic(level);
        indixE.setMaxCD(5);
        jack = new Magic(level);
        jack.setMaxCD(120);
        jack.setMusicEffect(99);

    }

    Magic azunaQ;
    Magic azunaE;
    public void azunaMagic()
    {

        Azuna azuna = level.azuna;

        azunaQ.CD-=deltaTime;
        azunaE.CD-=deltaTime;

        if(azunaE.casting) {
            level.azunaQskillEffect.setPosition(new Vector2((float) (player.getX()-player.width*2.9), player.getY()-player.height));
            azuna.loseMP(200 * Gdx.graphics.getDeltaTime());
            Constants.myGravatiy = new Vector2(0,10);
            if (azuna.curMP < 10)
                azunaE.stop();
        }
        else
        {
            level.azunaQskillEffect.setPosition(new Vector2(-10000.0f,-10000.0f));
            Constants.myGravatiy = new Vector2(0,-10);
        }

        if(azunaQ.casting)
        {
            Vector2 vec = new Vector2((float) (player.getX()-player.width*1.7), player.getY()-player.height);
            this.level.azunaEskillEffectRecover.setPosition(vec);
            azunaQ.castTime += deltaTime;
            if(azunaQ.castTime > 7) {
                level.musicOccupied = false;
                azunaQ.stop();
                level.azunaEskillEffectRecover.setPosition(new Vector2(-10000,-10000));
            }
        }
    }


    Magic kiritoQ;
    Magic kiritoE;
    public void kiritoMagic()
    {
        Kirito kirito = level.kirito;
        kiritoQ.CD -= deltaTime;
        kiritoE.CD -= deltaTime;
        if (kiritoE.casting) {
                level.bulletFireWall.setPosition(new Vector2(kiritoE.castX,kiritoE.castY));
                kiritoE.castTime += deltaTime;
                System.out.println();
                if(!kiritoE.damageCaused) {
                    level.bulletFireWall.collideEnemy();
                    kiritoE.damageCaused = true;
                }
                if(kiritoE.castTime>1.35)
                    kiritoE.stop();
        }
        else
            level.bulletFireWall.setPosition(new Vector2(-10000.0f, -10000.0f));

        if (kiritoQ.casting) {
            //effect
            level.kiritoQskillEffect.setPosition(new Vector2(player.getX()-80,player.getY()-50));
            player.walkSpeed = 2 * player.originWalkSpeed;
            player.armor = 2 * player.originArmor;
            kiritoQ.castTime += deltaTime;
            player.restoreMP(10000);
            if(kiritoQ.castTime>10)
            {
                kiritoQ.stop();
            }
        }
        else
        {
            level.kiritoQskillEffect.setPosition(new Vector2(-20000,-3000));
            player.armor = player.originArmor;
            player.walkSpeed = player.originWalkSpeed;
        }
    }

    Magic indixQ;
    Magic indixE;
    public void indixMagic()
    {
        indixQ.CD -= deltaTime;
        indixE.CD -= deltaTime;
        if (indixQ.casting) {
            indixQ.castTime+=deltaTime;
            level.indixQskillEffect.setPosition(new Vector2(indixQ.castX,indixQ.castY));
            if(indixQ.castTime>2.4&&!indixQ.damageCaused)
            {
                indixQ.damageCaused = true;
                level.indixQskillEffect.quandoushipaomo();
            }
            if(indixQ.castTime>4)
            {
                indixQ.stop();
            }
        }
        else
        {
            level.indixQskillEffect.setPosition(new Vector2(-20000,-3000));
        }

    }
    Magic jack;
    public void jackMagic()
    {
        jack.CD-=deltaTime;
        if (jack.casting) {

            jack.castTime += deltaTime;
            if(jack.castTime>36)
                jack.stop();
        }
        else
            level.bulletTitanic.setPosition(new Vector2(-10000.0f, -10000.0f));
    }
    public void update(float deltaTime)
    {
        player = level.curPlayer;
        this.deltaTime = deltaTime;
        azunaMagic();
        kiritoMagic();
        indixMagic();
        jackMagic();
    }
}
