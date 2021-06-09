package com.mygdx.SmallMap.LevelFrame;

public class Magic {
    Boolean casting;
    Boolean damageCaused;
    float castTime;
    float CD;
    float maxCD;
    float MPconsume;
    float castX;
    float castY;
    Level level;
    Boolean musicEffect = false;
    int musicNum = 0;

    public void setCastPositon(float castX,float castY) {
        this.castX = castX;
        this.castY = castY;
    }

    public void setMusicEffect(int i)
    {
        musicEffect = true;
        musicNum = i;
    }

    public Magic(Level level)
    {
        this.level = level;
        damageCaused = false;
        casting = false;
        CD = maxCD = 0;
    }
    public void setMaxCD(int a)
    {
        maxCD = a;
    }
    public void cast()
    {
        if(CD<0) {
            casting = true;
            CD = maxCD;
            castTime = 0;
            damageCaused = false;
            if(musicEffect) {
                MusicManager.playMusic(musicNum);
            }
        }
    }
    public void stop()
    {
        damageCaused = false;
        casting = false;
    }
}
