package com.social.eventual.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Behrad on 2016-05-12.
 */
public class SkyView extends View {

    // CONSTRUCTOR
    public SkyView(Context context) {
        super(context);
        init(context);
    }

    public SkyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SkyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }
    private void init(Context context) {
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float radius = 100;
        Paint p = new Paint();
        // smooths
        p.setAntiAlias(true);
        int xPos = (canvas.getWidth() / 2);
        int yPos = (int) ((canvas.getHeight() / 2) - ((p.descent() + p.ascent()) / 2)) - 300;

        DrawSun(canvas, radius, p, yPos, Color.YELLOW, xPos - 200);

        DrawMoon(canvas, radius, p, xPos, yPos);
    }

    private void DrawSun(Canvas canvas, float radius, Paint p, int yPos, int yellow, int cx) {
        p.setColor(yellow);
        p.setStyle(Paint.Style.FILL);
        p.setStrokeWidth(4.5f);
        canvas.drawCircle(cx, yPos, radius, p);
    }

    private void DrawMoon(Canvas canvas, float radius, Paint p, int xPos, int yPos) {
        DrawSun(canvas, radius, p, yPos, Color.BLACK, xPos + 200);
        DrawSun(canvas, radius, p, yPos, Color.WHITE, xPos + 250);
    }


}
