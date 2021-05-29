package com.mygdx.timetravel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicManager {

    public static Music[] music;
    public MusicManager()
    {
        music = new Music[100];
        music[10] = Gdx.audio.newMusic(Gdx.files.internal("Music/TitleMusic.mp3"));
        music[90] = Gdx.audio.newMusic(Gdx.files.internal("Music/killbill.mp3"));
        music[91] = Gdx.audio.newMusic(Gdx.files.internal("Music/failed.mp3"));
        music[92] = Gdx.audio.newMusic(Gdx.files.internal("Music/victory.mp3"));
        music[80] = Gdx.audio.newMusic(Gdx.files.internal("Music/backgroundMusic.mp3"));
        music[88] = Gdx.audio.newMusic(Gdx.files.internal("Music/strangemusic.mp3"));
        music[93] = Gdx.audio.newMusic(Gdx.files.internal("Music/tornado.mp3"));
        music[94] = Gdx.audio.newMusic(Gdx.files.internal("Music/extraLive.mp3"));
        music[95] = Gdx.audio.newMusic(Gdx.files.internal("Music/kiritomain.mp3"));
        music[96] = Gdx.audio.newMusic(Gdx.files.internal("Music/bubble.mp3"));
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
