package com.daquexian.flexiblerichtextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by panj on 2017/3/21.
 */

public class CodeView extends TextView {
    public CodeView(Context context) {
        super(context);
        init();
    }

    public CodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CodeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setTextColor(getResources().getColor(R.color.code_content));
        setBackgroundColor(getResources().getColor(R.color.code_content_background));
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics());
        setPadding(padding, padding, padding, padding);
    }

    public void setText(String text) {
        super.setText(text);
        Spannable span = new SpannableString(text);
        span.setSpan(new TypefaceSpan("monospace"), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        setText(span);
    }
}
