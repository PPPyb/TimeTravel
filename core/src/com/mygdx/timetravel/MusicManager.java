package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicManager {

    public static Music[] music;
    public MusicManager()
    {
        music = new Music[100];
        music[90] = Gdx.audio.newMusic(Gdx.files.internal("music/killbill.mp3"));
        music[91] = Gdx.audio.newMusic(Gdx.files.internal("music/failed.mp3"));
        music[92] = Gdx.audio.newMusic(Gdx.files.internal("music/victory.mp3"));
        music[80] = Gdx.audio.newMusic(Gdx.files.internal("music/backgroundMusic.mp3"));
    }
    public static void playMusic(int num)
    {
        for(int i = 0;i < 100;i++)
        {
            if(music[i]!=null) {
                if(music[i].isPlaying()&&i!=num)
                music[i].stop();
            }
        }
        if(!music[num].isPlaying())
            music[num].play();
    }
}
