# FreeToolbar

FreeToolbar is a toolbar widget which support flexible customization of toolbar display.

There're 2 kinds of common usages:
1. Include FreeToolbar and PopuMenu widgets in your project and manage them manually
2. Inherit ToolbarActivity for your own activity and override necessary life-cycle methods (preferred)

How to use FreeToolbar:
Step 1: Include below source files in your project
    - widget/*
    - drawable/* (you can replace images by yourself)
    - res/layout/toolbar.xml
    - res/values/attrs.xml
    - res/values/dimens.xml
Step 2: Inherit ToolbarActivity for your own activity
Step 3: Override onCreateFreeToolbar() method and configure toolbar's layout. After that you can use getFreeToolbar() do your own specific configuration then. e.g.:
        @Override
	protected void onCreateFreeToolbar(ViewGroup root) {
	    getLayoutInflater().inflate(R.layout.toolbar, root);
	    super.onCreateFreeToolbar(root);
            // put other initialization here... e.g.:
            getFreeToolbar().setTitle("Hit me");
        }
Step 4: If you need overflow menu on your toolbar, override onCreateOverflowMenu() to configure overflow menu's layout. e.g.:
        @Override
        protected boolean onCreateOverflowMenu(View menuLayout) {
            View layout = getLayoutInflater().inflate(R.layout.toolbar_menu, null);
            return super.onCreateOverflowMenu(layout);
        }

That's all, enjoy it! If you have better suggestions to make this widget more flexible or extendible, feel free to contact me.
