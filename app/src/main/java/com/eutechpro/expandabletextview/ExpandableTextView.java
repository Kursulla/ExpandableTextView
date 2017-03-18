package com.eutechpro.expandabletextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ExpandableTextView extends RelativeLayout {
    private TextView contentText;
    private TextView expandToggle;
    private TextView collapseToggle;

    private int    limit;
    private String text;
    private String expandLabel;
    private String collapseLabel;


    public ExpandableTextView(Context context) {
        super(context);
        init();
    }

    public ExpandableTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getCustomAttributes(context, attrs);
        init();
    }

    public ExpandableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getCustomAttributes(context, attrs);
        init();
    }

    private void getCustomAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ExpandableTextView,
                0, 0);

        try {
            text = a.getString(R.styleable.ExpandableTextView_text);
            expandLabel = a.getString(R.styleable.ExpandableTextView_expand_label);
            collapseLabel = a.getString(R.styleable.ExpandableTextView_collapse_label);
            limit = a.getInteger(R.styleable.ExpandableTextView_limit, 0);
        } finally {
            a.recycle();
        }
    }

    @SuppressWarnings("deprecation")
    private void init() {
        inflate(getContext(), R.layout.expandable_textview, this);

        initText();
        initExpandToggle();
        initCollapseToggle();
    }

    private void initText() {
        if (text == null){
            throw new IllegalStateException("You have to set some text!!!");
        }
        contentText = (TextView) findViewById(R.id.content_text);
        if (shouldExpand()){
            contentText.setFilters((new InputFilter[] {new InputFilter.LengthFilter(limit)}));

        }
        contentText.setText(text);
    }

    private void initExpandToggle() {
        if (expandLabel == null){
            throw new IllegalStateException("You have to set expand button label!!!");
        }
        expandToggle = (TextView) findViewById(R.id.expand_toggle);
        if (shouldExpand()){
            expandToggle.setText(expandLabel);
            expandToggle.setOnClickListener(new ExpandListener());
        } else {
            expandToggle.setVisibility(GONE);
        }
    }

    private void initCollapseToggle() {
        if (collapseLabel == null){
            return;
        }
        collapseToggle = (TextView) findViewById(R.id.collapse_toggle);
        collapseToggle.setText(collapseLabel);
        collapseToggle.setOnClickListener(new CollapseListener());
    }

    private class ExpandListener implements OnClickListener {
        @Override
        public void onClick(View view) {
            contentText.setFilters((new InputFilter[] {}));
            contentText.setText(text);
            expandToggle.setVisibility(GONE);
            collapseToggle.setVisibility(VISIBLE);
        }
    }

    private class CollapseListener implements OnClickListener {
        @Override
        public void onClick(View view) {
            contentText.setFilters((new InputFilter[] {new InputFilter.LengthFilter(limit)}));
            contentText.setText(text);
            expandToggle.setVisibility(VISIBLE);
            collapseToggle.setVisibility(GONE);
        }
    }

    private boolean shouldExpand() {
        return limit > 0 && text.length() > limit;
    }
}
