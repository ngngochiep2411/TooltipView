package com.example.tooltipview;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class TooltipView extends RelativeLayout {

    public TooltipView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.mylayout, item );
    }


    public void focusToView(View view) {
        int[] location = new int[2];
        this.getLocationOnScreen(location);

        int marginTopOfScreen = location[1];

        view.getLocationOnScreen(location);
        RectF rectClipOfView = new RectF(location[0],
                location[1] - marginTopOfScreen,
                location[0] + view.getWidth(),
                location[1] + view.getHeight()
        );

        int sizeTutorialView = getResources().getDimensionPixelSize(R.dimen.height_tooltip);
        int marginBetweenPathWithContent = getResources().getDimensionPixelSize(R.dimen.default_margin_xxlarge);

        int centerOfBorderView = (int) rectClipOfView.centerX();

        int marginTop = 0;
        boolean tutorialViewIsBottomView;

        if (this.getHeight() - rectClipOfView.bottom > sizeTutorialView + marginBetweenPathWithContent) {
            tutorialViewIsBottomView = true;
            marginTop = (int) (rectClipOfView.bottom + marginBetweenPathWithContent);
        } else {
            tutorialViewIsBottomView = false;
            marginTop = (int) rectClipOfView.top - marginBetweenPathWithContent - sizeTutorialView;
        }

        TextContentView2 textContentView = new TextContentView2(getContext(), null);
        RelativeLayout.LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = marginTop;

        textContentView.setContent(getResources().getString(R.string.data2));

        int coordinateRightTextContent = getContext().getResources().getDisplayMetrics().widthPixels - getResources().getDimensionPixelSize(R.dimen.default_margin_xlarge);
        int coordinateLeftTextContent =
                getResources().getDimensionPixelSize(R.dimen.default_margin_xlarge);

        int marginStartOfArrow =
                centerOfBorderView - getResources().getDimensionPixelSize(R.dimen.default_margin_xlarge) / 2;
        if (tutorialViewIsBottomView) {

            textContentView.viewArrowOnTop.setVisibility(VISIBLE);
            RelativeLayout.LayoutParams lp = (LayoutParams) textContentView.viewArrowOnTop.getLayoutParams();
            lp.setMarginStart(marginStartOfArrow);
        } else {
            textContentView.viewArrowOnBottom.setVisibility(VISIBLE);

            RelativeLayout.LayoutParams lpArrow = (LayoutParams) textContentView.viewArrowOnBottom.getLayoutParams();
            lpArrow.setMarginStart(marginStartOfArrow);
            textContentView.viewArrowOnBottom.setLayoutParams(lpArrow);
        }
        this.addView(textContentView, layoutParams);

    }

}
