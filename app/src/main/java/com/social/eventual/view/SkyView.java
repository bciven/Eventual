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

        Paint p = new Paint();
        // smooths
        p.setAntiAlias(true);
        int xPos = (canvas.getWidth() / 2);
        int yPos = (int) ((canvas.getHeight() / 2) - ((p.descent() + p.ascent()) / 2)) - 300;

        //sun
        p.setColor(Color.YELLOW);
        p.setStyle(Paint.Style.FILL);
        p.setStrokeWidth(4.5f);
        // opacity
        //p.setAlpha(0x80); //
        canvas.drawCircle(xPos - 200, yPos, 60, p);

        //moon
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);
        p.setStrokeWidth(4.5f);
        // opacity
        //p.setAlpha(0x80); //
        canvas.drawCircle(xPos + 200, yPos, 60, p);

        p.setColor(Color.WHITE);
        p.setStyle(Paint.Style.FILL);
        p.setStrokeWidth(4.5f);
        // opacity
        // p.setAlpha(0x80); //
        canvas.drawCircle(xPos + 250, yPos, 60, p);
    }

}
