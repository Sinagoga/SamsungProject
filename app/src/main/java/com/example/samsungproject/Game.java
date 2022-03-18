package com.example.samsungproject;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class Game extends SurfaceView implements SurfaceHolder.Callback {
    private final Context context;
    private GameLoop gameLoop;
    Player player;
    Joystick joystick;
    static Resources resources;
    float iX, iY;
    float cX, cY, cx, cy, Rad, r;
    boolean isFirstDraw = true;






//    private int[] displayXY(){
//        int arr[] = new int[2];
//        Display display = getDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        int iX = size.x;
//        int iY = size.y;
//        arr[0] = iX;
//        arr[1] = iY;
//        return arr;
//    }

    public Game(Context context) {
        super(context);
        resources = getResources();

        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);


        this.context = context;
        gameLoop = new GameLoop(this, surfaceHolder);


        setFocusable(true);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (isFirstDraw){
            iX = getWidth()/2;
            iY = getHeight()/2;
            player = new Player(iX, iY);
            cX = getWidth()-getWidth() + getWidth()/10 ;
            cY = getHeight() - getWidth()/10;
            cx = cX;
            cy = cY;
            Rad = getHeight()/10;
            r = Rad-(Rad-50);
            joystick = new Joystick(cX, cY, cx, cy, Rad, r, context, ContextCompat.getColor(context, R.color.white), ContextCompat.getColor(context, R.color.teal_200));
            isFirstDraw = false;
        }
        drawUPS(canvas);
        drawFPS(canvas);
        player.draw(canvas);
        joystick.draw(canvas);
//        update();

    }


    public void drawUPS(Canvas canvas){
        String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, R.color.white));
        paint.setTextSize(50);
        canvas.drawText("UPS: " + averageUPS, 100, 100, paint);
    }
    public void drawFPS(Canvas canvas){
        String averageUPS = Double.toString(gameLoop.getAverageFPS());
        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, R.color.white));
        paint.setTextSize(50);
        canvas.drawText("FPS: " + averageUPS, 100, 200, paint);
    }

    public void update() {
//        player.update();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            joystick.cx = event.getX();
            joystick.cy = event.getY();
        }
        return super.onTouchEvent(event);
    }
}
