package com.example.tooltipview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TooltipView tooltipView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tooltipView = findViewById(R.id.tooltipView);
        textView =  findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tooltipView.focusToView(textView);
            }
        });

    }

    public void OKKK(View view) {
        tooltipView.focusToView(view);
    }
}