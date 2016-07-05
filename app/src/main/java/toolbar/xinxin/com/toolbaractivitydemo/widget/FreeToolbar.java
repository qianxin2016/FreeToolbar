package toolbar.xinxin.com.toolbaractivitydemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import toolbar.xinxin.com.toolbaractivitydemo.R;

public class FreeToolbar extends LinearLayout {
    public static final int TOOLBAR_ID = R.id.toolbar;
    public static final int TOOLBAR_MENU_ID = R.id.toolbar_menu;
    public static final int TOOLBAR_NAVIGATION_ID = R.id.toolbar_navi;
    public static final int TOOLBAR_TITLE_ID = R.id.toolbar_title;

    private float mOverflowMenuWidth;
    private float mOverflowMenuHeight;
    private float mOverflowMenuOffsetX;
    private float mOverflowMenuOffsetY;

    private float mTitlePaddingWhenNoNaviIcon;

    public FreeToolbar(Context context) {
        this(context, null);
    }

    public FreeToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FreeToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.FreeToolbar, defStyleAttr, 0);
        for (int i = 0; i < a.getIndexCount(); i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.FreeToolbar_menu_width:
                    mOverflowMenuWidth = a.getDimensionPixelSize(attr, 100);
                    break;
                case R.styleable.FreeToolbar_menu_height:
                    mOverflowMenuHeight = a.getDimensionPixelSize(attr, 40);
                    break;
                case R.styleable.FreeToolbar_menu_offset_x:
                    mOverflowMenuOffsetX = a.getDimensionPixelSize(attr, 20);
                    break;
                case R.styleable.FreeToolbar_menu_offset_y:
                    mOverflowMenuOffsetY = a.getDimensionPixelSize(attr, 20);
                    break;
                case R.styleable.FreeToolbar_title_padding_when_no_navi_icon:
                    mTitlePaddingWhenNoNaviIcon = a.getDimensionPixelSize(attr, 0);
                    break;
            }
        }
        a.recycle();
    }

    public void setNavigationEnabled(boolean enabled) {
        View navi = findViewById(TOOLBAR_NAVIGATION_ID);
        if (navi != null) {
            if (enabled) {
                navi.setVisibility(View.VISIBLE);
            } else {
                navi.setVisibility(View.GONE);
                // adjust title padding when no navi icon
                adjustTitlePadding();
            }
        }
    }

    public void setOverflowMenuEnabled(boolean enabled) {
        View menu = findViewById(TOOLBAR_MENU_ID);
        if (menu != null) {
            if (enabled) {
                menu.setVisibility(View.VISIBLE);
            } else {
                menu.setVisibility(View.GONE);
            }
        }
    }

    public void setTitle(String title) {
        TextView view = (TextView) findViewById(TOOLBAR_TITLE_ID);
        if (view != null) {
            view.setText(title);
        }
    }

    public String getTitle() {
        TextView view = (TextView) findViewById(TOOLBAR_TITLE_ID);
        if (view != null) {
            return view.getText().toString();
        }

        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener listener) {
        View navi = findViewById(TOOLBAR_NAVIGATION_ID);
        if (navi != null) {
            navi.setOnClickListener(listener);
        }
    }

    public void setTitleOnClickListener(View.OnClickListener listener) {
        TextView view = (TextView) findViewById(TOOLBAR_TITLE_ID);
        if (view != null) {
            view.setOnClickListener(listener);
        }
    }

    public float getOverflowMenuWidth() {
        return mOverflowMenuWidth;
    }

    public void setOverflowMenuWidth(float overflowMenuWidth) {
        this.mOverflowMenuWidth = overflowMenuWidth;
    }

    public float getOverflowMenuHeight() {
        return mOverflowMenuHeight;
    }

    public void setOverflowMenuHeight(float overflowMenuHeight) {
        this.mOverflowMenuHeight = overflowMenuHeight;
    }

    public float getOverflowMenuOffsetX() {
        return mOverflowMenuOffsetX;
    }

    public void setOverflowMenuOffsetX(float overflowMenuOffsetX) {
        this.mOverflowMenuOffsetX = overflowMenuOffsetX;
    }

    public float getOverflowMenuOffsetY() {
        return mOverflowMenuOffsetY;
    }

    public void setOverflowMenuOffsetY(float overflowMenuOffsetY) {
        this.mOverflowMenuOffsetY = overflowMenuOffsetY;
    }

    public float getTitlePaddingWhenNoNaviIcon() {
        return mTitlePaddingWhenNoNaviIcon;
    }

    public void setTitlePaddingWhenNoNaviIcon(float titlePaddingWhenNoNaviIcon) {
        this.mTitlePaddingWhenNoNaviIcon = titlePaddingWhenNoNaviIcon;
    }

    private void adjustTitlePadding() {
        TextView view = (TextView) findViewById(TOOLBAR_TITLE_ID);
        view.setPadding((int)mTitlePaddingWhenNoNaviIcon,
                view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }
}
