package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {
    Paint paint = new Paint();
    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(300, 300, 600, 600, -150, 90, true, paint);
        canvas.drawArc(300, 300, 600, 600, 50, 130, false, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(300, 300, 600, 600, -50, 50, false, paint);
//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
    }
}
