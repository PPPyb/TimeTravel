package com.mygdx.testprogram;
import com.badlogic.gdx.graphics.Texture;
import java.math.*;
public class Bullets {
    double x, y;
    double xv, yv;

    int id;
    Texture img;
    Bullets(int id)
    {
        this.id = id;
        x = y = xv = yv = 0;
        if(id==1)
            img = new Texture("Bullets.png");
        else if(id==2)
            img = new Texture("Bullets2.png");
    }
    public void fire(double x1,double y1,int type,double angel,int num)
    {
        x = (int)x1+40;
        y = (int)y1+100;

        if(type == 1) {
            xv = 15 + Math.random()*num/2;
            yv = angel + Math.random()*num/2;
        }
        else if(type == 2){
            xv = -15 - Math.random()*num/2;
            yv = angel + Math.random()*num/2;
        }
    }
    public void move(Player player)
    {
        x += xv;
        y += yv;
        yv-= 0.5;
        if(x+20>=player.x&&y+20>=player.y&&x+20<= player.x+ player.width&&y+20<=player.y+ player.height)
        {
            int damage = 1 + (int)(Math.random()*4);
            if(player.HP>0)
             player.HP -= damage;
             if(Math.random()>0.9) {
                 player.HP += 4 * damage;
             }
            x = -1000;
            y = -1000;
        }
    }
}
