package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.math.Vector2;
import com.sun.org.apache.bcel.internal.util.BCELifier;

public class Weather {
    WeatherSnow[] weatherSnow;
    int snowCnt = 0;
    String weatherState;
    float weatherInterval = 10;
    float particleInterval = 0.05f;
    float particleTime = 0;
    float weatherTime = 0;
    float windPower = 0;
    float windChangeChange;
    float windChange;
    ParticleEffect snowEffect;
    ParticleEffect rainEffect;
    Level level;
    public Weather(Level level)
    {
        this.level = level;
        weatherSnow = new WeatherSnow[1000];
        snowEffect = new ParticleEffect();
        snowEffect.load(Gdx.files.internal("particle/snow.particle"),Gdx.files.internal("particle"));
        snowEffect.start();
        rainEffect= new ParticleEffect();
        rainEffect.load(Gdx.files.internal("particle/rain.particle"),Gdx.files.internal("particle"));
        rainEffect.start();
        weatherState = "DEFAULT";
    }

    public void update(float deltaTime)
    {
        particleTime += deltaTime;
        weatherTime += deltaTime;

        controlWind();
        if(particleTime>particleInterval)
        {
            makeWeather();
            particleTime = 0;
        }
        snowEffect.setPosition(level.curPlayer.getX(),level.curPlayer.getY());
        snowEffect.update(deltaTime);
        rainEffect.setPosition(level.curPlayer.getX(),level.curPlayer.getY());
        rainEffect.update(deltaTime);
        updateObjects(weatherSnow,snowCnt,deltaTime);
    }

    public void draw(Batch batch)
    {
        drawObjects(weatherSnow,snowCnt,batch);
        switch (weatherState)
        {
            case "SNOW":
                snowEffect.draw(batch);
                break;
            case "RAIN":
                rainEffect.draw(batch);
                break;
            default:
                break;
        }
    }

    public void makeWeather()
    {
        float x = level.curPlayer.getX();
        x += Math.random()*4000;
        x -= 2000;
        float y = level.curPlayer.getY() + 720;
        switch (weatherState)
        {
            case "SNOW":
                if(snowCnt>900)
                    snowCnt = 0;
                weatherSnow[snowCnt] = new WeatherSnow(x,y,level);
                weatherSnow[snowCnt].setVelocity(new Vector2(windPower,-200));
                snowCnt++;
                break;
            default:
                break;
        }
    }
    public void controlWind()
    {
        windChangeChange = (float) Math.random()*10-5;
        if(-10<windChangeChange+windChange&&windChangeChange+windChange<10)
            windChange += windChangeChange;
        if(-200<windPower+windChange&&windPower+windChange<200)
            windPower += windChange;

        for(int i = 0;i < snowCnt;i++)
            weatherSnow[i].setVelocity(new Vector2(windPower,-200));

    }

    public void updateObjects(AbstractGameObject[] objects,int cnt,float deltaTime)
    {
        for(int i = 0;i < cnt;i++)
            objects[i].update(deltaTime);
    }
    public void drawObjects(AbstractGameObject[] objects, int cnt, Batch batch)
    {
        for(int i = 0;i < cnt;i++)
            objects[i].draw(batch);
    }
}
