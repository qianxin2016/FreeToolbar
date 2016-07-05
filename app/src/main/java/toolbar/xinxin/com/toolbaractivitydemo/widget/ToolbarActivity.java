package toolbar.xinxin.com.toolbaractivitydemo.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ToolbarActivity extends AppCompatActivity
        implements PopupMenu.OnMenuItemSelectedListener {
    private LinearLayout mContentView;
    private FreeToolbar mToolbar;
    private PopupMenu mPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initContentView();
        initToolbar();
    }

    /**
     * Override this if want to add your own handling logic
     * @param menuItem
     */
    @Override
    public void onMenuItemSelected(View menuItem) {
        mPopupMenu.dismiss();
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        setContentView(view);
    }

    @Override
    public void setContentView(View view) {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(view, params);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mContentView.addView(view, params);
        super.setContentView(mContentView);
    }

    public FreeToolbar getFreeToolbar() {
        return mToolbar;
    }

    /**
     * Override this method to attach toolbar layout to the root view
     * @param root root view to attach the toolbar
     */
    protected void onCreateFreeToolbar(ViewGroup root) {
        mToolbar = (FreeToolbar) root.findViewById(FreeToolbar.TOOLBAR_ID);

        if (mToolbar != null) {
            // default back click action
            View navi = mToolbar.findViewById(FreeToolbar.TOOLBAR_NAVIGATION_ID);
            navi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    /**
     * Override this method to generate overflow menu
     * @param menuLayout overflow menu layout
     * @return boolean Indicate whether to show overflow menu or not
     */
    protected boolean onCreateOverflowMenu(View menuLayout) {
        if (menuLayout != null) {
            // initialize popup menu
            mPopupMenu = new PopupMenu((ViewGroup)menuLayout);
            mPopupMenu.setOnMenuItemSelectedListener(this);

            // show or dismiss popup menu when clicked
            final float offsetX = mToolbar.getOverflowMenuOffsetX();
            final float offsetY = mToolbar.getOverflowMenuOffsetY();
            final float menuWidth = mToolbar.getOverflowMenuWidth();
            final View menu = mToolbar.findViewById(FreeToolbar.TOOLBAR_MENU_ID);
            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mPopupMenu.isShowing()) {
                        mPopupMenu.dismiss();
                    } else {
                        // based on bottom-left, need take menu width and menu icon width into account
                        mPopupMenu.show(menu, (int) (menu.getWidth() - offsetX - menuWidth), (int) offsetY);
                    }
                }
            });

            return true;
        }

        return false;
    }

    private void initContentView() {
        mContentView = new LinearLayout(this);
        mContentView.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mContentView.setLayoutParams(params);
    }

    private void initToolbar() {
        // by default no toolbar, need to override this method
        onCreateFreeToolbar(mContentView);

        if (mToolbar != null) {
            // by default no overflow menu, should override this method
            boolean show = onCreateOverflowMenu(null);
            if (show) {
                mToolbar.setOverflowMenuEnabled(true);
            } else {
                mToolbar.setOverflowMenuEnabled(false);
            }
        }
    }
}
