package com.mygdx.SmallMap.LevelFrame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicManager {

    public static Music[] music;
    public MusicManager()
    {
        music = new Music[100];
        music[70] = Gdx.audio.newMusic(Gdx.files.internal("Music/snowmap.mp3"));
        music[71] = Gdx.audio.newMusic(Gdx.files.internal("Music/greenmap.mp3"));
        music[72] = Gdx.audio.newMusic(Gdx.files.internal("Music/firemap.mp3"));
        music[39] = Gdx.audio.newMusic(Gdx.files.internal("Music/miku.mp3"));
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
        music[97] = Gdx.audio.newMusic(Gdx.files.internal("Music/Railgun.mp3"));
        music[99] = Gdx.audio.newMusic(Gdx.files.internal("Music/myheart.mp3"));

        music[2] = Gdx.audio.newMusic(Gdx.files.internal("end/end.mp3"));
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
