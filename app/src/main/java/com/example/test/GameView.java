package com.example.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.test.R;

public class GameView extends View {
    private float px = 400;
    private float py = 400;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.monkey);
        canvas.drawBitmap(bitmap, px, py, paint);
    }

    public void setPx(float px) {
        if (px >= -50 && px <= 1050) {
            this.px = px;
        }
    }

    public float getPx()
    {
        return px;
    }

    public void setPy(float py) {
        if (py > 0 && py < 1440) ;
        {
            this.py = py;
        }
    }
    public float getPy(){
        return py;
    }
}