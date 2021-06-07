package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyTextrue {
    public static TextureRegion doreamon;
    public static TextureRegion ball;
    public static TextureRegion love;
    public static TextureRegion snow;
    public static TextureRegion coin;
    public static TextureRegion hp;
    public static void ini()
    {
        doreamon = TextureRegion.split(new Texture(Gdx.files.internal("testMap/NBbullet.png")),new Texture(Gdx.files.internal("testMap/NBbullet.png")).getWidth()/4,new Texture(Gdx.files.internal("testMap/NBbullet.png")).getHeight()/4)[0][0];
        ball = new TextureRegion(new Texture(Gdx.files.internal("testMap/ballBullet.png")));
        love = new TextureRegion(new Texture(Gdx.files.internal("testMap/love.png")));
        snow = new TextureRegion(new Texture(Gdx.files.internal("Weather/snow.png")));
        coin = new TextureRegion(new Texture(Gdx.files.internal("SnowLand/slice136.png")));
        hp = new TextureRegion(new Texture(Gdx.files.internal("GUI/HP.png")));
    }
}
