import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.example.weeamcommon.R;

/**
 * Created by Weeam Awad on 5/10/2018.
 */

public class CustomView extends View {
    private String mText;
    private int mTextSize;

    private TextPaint mTextPaint = new TextPaint(TextPaint.ANTI_ALIAS_FLAG);
    private Rect mBounds = new Rect();

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attributeSet, int deStyle) {
        TypedArray styles = context.obtainStyledAttributes(attributeSet, R.styleable.CustomView, deStyle, 0);
        mText = styles.getString(R.styleable.CustomView_text);
        mTextPaint.setColor(styles.getColor(R.styleable.CustomView_color, ContextCompat.getColor(context, R.color.black)));
        styles.recycle();
    }

    public void setText(String text) {
        mText = text;
        invalidate();
    }

    public String getText() {
        return mText;
    }

    public void setTextColor(int color) {
        mTextPaint.setColor(color);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mText != null) {
            final int width = getWidth();
            final int height = getHeight();
            //Draw in the Center of the View
            canvas.drawText(mText, width / 2, height / 2, mTextPaint);
        }
    }
}
