package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {
    Paint paint = new Paint();
    Path path = new Path();
    String[] date = {"Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo"};
    double[] percent = {5.2, 10.5, 22.9, 26, 30.8, 4.6};
    int ax = 100, ay = 50, bx = 1000, by = 700;
    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画坐标轴
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        canvas.drawLine(ax, ay, ax, by, paint);
        canvas.drawLine(ax, by, bx, by, paint);
        int width = (bx - ax - 20) / date.length;
        int max = 0;
        for (int i = 0; i < date.length; i++) {
            if (percent[i] > percent[max]) max = i;
        }
        int high = (int) ((by - ay - 20) / percent[max]);
        paint.setStrokeWidth(0);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(30);
        for (int i = 0; i < date.length; i++) {
            int sx = ax + width * i + 20;
            //画直方图
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#00a1d6"));
            canvas.drawRect(sx, (int) (by - high * percent[i]), sx + width - 20, by, paint);
            //写字
            paint.setColor(Color.WHITE);
            canvas.drawText(date[i], sx + (width - 20) / 2, by + 40, paint);
        }
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
    }
}
