package com.example.samsungproject;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Display;
import android.view.SurfaceView;
import android.view.View;

public class Player {
    Bitmap image = BitmapFactory.decodeResource(Game.resources, R.drawable.aboba);
    float jumpCount = 10; // прыжок игрока
    boolean isJump = false; // падать или нет
    float iX, iY;
    float tX, tY;
    double k = 20;
    float dx = 0, dy = 0;
    Paint paint = new Paint();

    public Player(float iX, float iY) {
        this.iX = iX;
        this.iY = iY;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(image, iX, iY, paint);
    }


    public void update() {
//        iX += dx; // Параметры игрока
//        iY += dy; // Параметры игрока
//
//        // Падение
//        if ((jumpCount >= -10) && (isJump)){
//            iY -= jumpCount * Math.abs(jumpCount) *0.5;
//            jumpCount -= 1;
//            delta();
//        }
//
//        else {
//            jumpCount = 10;
//            isJump = false;
//            dx = 0;
//        }
    }

    //расчет смещения картинки по x и y
    void delta(){
        double ro = Math.sqrt((tX- iX)*(tX- iX)+(tY-iY)*(tY-iY));
        dx = (float) (k * (tX - iX)/ro);
        //dy = (float) (k * (tY - iY)/ro);
    }
}
