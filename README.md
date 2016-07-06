# FreeToolbar

FreeToolbar is a toolbar widget which support flexible customization of toolbar display.

##There're 2 kinds of common usages:
1. Include FreeToolbar and PopuMenu widgets in your project and manage them manually
2. Inherit ToolbarActivity for your own activity and override necessary life-cycle methods (preferred)

##How to use FreeToolbar?
<b>Step 1:</b> Include below source files in your project
* widget/*
* drawable/* (you can replace images by yourself)
* res/layout/toolbar.xml
* res/values/attrs.xml
* res/values/dimens.xml

<b>Step 2:</b> Inherit ToolbarActivity for your own activity
```Java
    public class XXXActivity extends ToolbarActivity
```

<b>Step 3:</b> Override onCreateFreeToolbar() method and configure toolbar's layout. After that you can use getFreeToolbar() do your own specific configuration then. e.g.:
```Java
    @Override
    protected void onCreateFreeToolbar(ViewGroup root) {
        getLayoutInflater().inflate(R.layout.toolbar, root);
        super.onCreateFreeToolbar(root);
        // put other initialization here... e.g.:
        getFreeToolbar().setTitle("Hit me");
    }
```

<b>Step 4:</b> If you need overflow menu on your toolbar, override onCreateOverflowMenu() to configure overflow menu's layout. e.g.:</br>
```Java
    @Override
    protected boolean onCreateOverflowMenu(View menuLayout) {
        View layout = getLayoutInflater().inflate(R.layout.toolbar_menu, null);
        return super.onCreateOverflowMenu(layout);
    }
```

##How to configure FreeToolbar?
<b>Configure toolbar attributes:</b>
* menu_offset_x: horizontal offset relative to the anchor (note: origin is on bottom-left)
* menu_offset_y: vertical offset relative to the anchor (note: origin is on bottom-left)
* menu_width: menu's width
* menu_height: menu's height
* title_padding_when_no_navi_icon: title's left padding when no navigation button (by default 16dp)

<b>APIs to configure toolbar elements:</b><br/>
You can use getFreeToolbar() to get FreeToolbar object in your activity, and use below APIs to configure it:
* void setTitle(String title)
* String getTitle()
* void setNavigationEnabled(boolean enabled)
* void setOverflowMenuEnabled(boolean enabled)
* void setTitleOnClickListener(View.OnClickListener listener)
* void setNavigationOnClickListener(View.OnClickListener listener)
* float getOverflowMenuWidth()
* void setOverflowMenuWidth(float overflowMenuWidth)
* float getOverflowMenuHeight()
* void setOverflowMenuHeight(float overflowMenuHeight)
* float getOverflowMenuOffsetX()
* void setOverflowMenuOffsetX(float overflowMenuOffsetX)
* float getOverflowMenuOffsetY()
* void setOverflowMenuOffsetY(float overflowMenuOffsetY)
* float getTitlePaddingWhenNoNaviIcon()
* void setTitlePaddingWhenNoNaviIcon(float titlePaddingWhenNoNaviIcon)

That's all, enjoy it! If you have better suggestions to make this widget more flexible or extendible, feel free to contact me.

