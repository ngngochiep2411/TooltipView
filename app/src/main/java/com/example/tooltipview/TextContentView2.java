package com.example.tooltipview;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TextContentView2 extends FrameLayout {

    View view;
    View viewArrowOnTop;
    View viewArrowOnBottom;
    TextView textContentDescription;

    public TextContentView2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflate(context, R.layout.layout_text_content, this);
        viewArrowOnTop = view.findViewById(R.id.viewArrowOnTop);
        viewArrowOnBottom = view.findViewById(R.id.viewArrowOnBottom);
        textContentDescription = view.findViewById(R.id.textContentDescription);
        textContentDescription.setMovementMethod(new ScrollingMovementMethod());
    }

    public void setContent(String content) {
        textContentDescription.setText(content);
    }
}
