package com.example.samsungproject;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

        public class Joystick {
            float cX, cY, cx, cy, R, r;
            Paint paint = new Paint();
            Paint paint1 = new Paint();
            Context context;
            int color;
            int color1;

            public Joystick(float cX, float cY, float cx, float cy, float R, float r, Context context, int color, int color1) {
                this.cX = cX;
                this.cY = cY;
                this.cx = cx;
                this.cy = cy;
                this.R = R;
                this.r = r;
                this.context = context;
                this.color = color;
                this.color1 = color1;
            }

            public void draw(Canvas canvas){
                paint.setColor(color);
                paint1.setColor(color1);
                canvas.drawCircle(cX, cY, R, paint);
                canvas.drawCircle(cx, cy, r, paint1);
            }
        }
