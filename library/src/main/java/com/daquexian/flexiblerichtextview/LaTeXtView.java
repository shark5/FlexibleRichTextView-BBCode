package com.daquexian.flexiblerichtextview;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

public class LaTeXtView extends TextView {
    public LaTeXtView(Context context) {
        super(context);
    }

    public void setTextWithFormula(TextWithFormula textWithFormula) {
        final SpannableStringBuilder builder = textWithFormula;

        setText(builder);
    }
}
