package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {
    Paint paint = new Paint();
    String[] date = {"Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo"};
    double[] percent = {5.2, 10.5, 22.9, 26, 30.8, 4.6};
    String[] color = {"#2196F3", "#4CAF50", "#ff6699", "#ff9800", "#9C27B0", "#009688"};
    int x = 500, y = 400, r = 200;

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*
     * 画图
     * 二次折线算法还没想出来
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        paint.setTextSize(30);
        paint.setStrokeJoin(Paint.Join.ROUND);
        double start = 0;
        int ax, ay, pos, cx, cy;
        int max = 0;
        for (int i = 0; i < date.length; i++) {
            if (percent[i] > percent[max]) max = i;
        }
        for (int i = 0; i < date.length; i++) {
            paint.setColor(Color.parseColor(color[i]));
            double sweep = percent[i] / 100 * 360;//扫过的角度
            double cen = start + (sweep - 2) / 2;//中心角度
            double center = cen * Math.PI / 180;//中心弧度
            if (i == max) {//最大值偏移
                int a = r / 10;//偏移量
                ax = (int) (a * Math.cos(center));//x偏移
                ay = (int) (a * Math.sin(center));//y偏移
            } else {
                ax = ay = 0;
            }
            //画扇形
            canvas.drawArc(x + ax - r, y + ay - r, x + ax + r, y + ay + r, (float) start, (float) sweep - 2, true, paint);
            int bx = (int) (r * Math.cos(center)) + x + ax;//线起点x
            int by = (int) (r * Math.sin(center)) + y + ay;//线起点y
            if (cen > 90 && cen < 270) {
                pos = -1;//向左画
            } else {
                pos = 1;//向右画
            }
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(5);
            //不是水平,画折线
            if (cen >= 2 && (cen <= 178 || cen >= 182) && cen <= 358) {
                cx = (int) ((r + r / 10) * Math.cos(center)) + x + ax;//拐点x
                cy = (int) ((r + r / 10) * Math.sin(center)) + y + ay;//拐点y
                canvas.drawLine(bx, by, cx, cy, paint);
                bx = cx;
                by = cy;
            }
            cx = bx + r / 3 * pos;//终点x
            cy = by;//终点y
            canvas.drawLine(bx, by, cx, cy, paint);
            paint.setStrokeWidth(0);
            if (pos == 1) {
                paint.setTextAlign(Paint.Align.LEFT);//向左画线就右对齐
                canvas.drawText(date[i], cx + r / 15, cy, paint);
            } else {
                paint.setTextAlign(Paint.Align.RIGHT);//向右画就左对齐
                canvas.drawText(date[i], cx - r / 15, cy, paint);
            }
            start += sweep;
        }
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

    }
}
