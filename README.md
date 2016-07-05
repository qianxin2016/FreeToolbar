# FreeToolbar

FreeToolbar is a toolbar widget which support flexible customization of toolbar display.

There're 2 kinds of common usages:</br>
1. Include FreeToolbar and PopuMenu widgets in your project and manage them manually</br>
2. Inherit ToolbarActivity for your own activity and override necessary life-cycle methods (preferred)</br>

How to use FreeToolbar:</br>
Step 1: Include below source files in your project</br>
    - widget/*</br>
    - drawable/* (you can replace images by yourself)</br>
    - res/layout/toolbar.xml</br>
    - res/values/attrs.xml</br>
    - res/values/dimens.xml</br>
Step 2: Inherit ToolbarActivity for your own activity</br>
Step 3: Override onCreateFreeToolbar() method and configure toolbar's layout. After that you can use getFreeToolbar() do your own specific configuration then. e.g.:</br>
        @Override</br>
	protected void onCreateFreeToolbar(ViewGroup root) {</br>
	    getLayoutInflater().inflate(R.layout.toolbar, root);</br>
	    super.onCreateFreeToolbar(root);</br>
            // put other initialization here... e.g.:</br>
            getFreeToolbar().setTitle("Hit me");</br>
        }
Step 4: If you need overflow menu on your toolbar, override onCreateOverflowMenu() to configure overflow menu's layout. e.g.:</br>
        @Override</br>
        protected boolean onCreateOverflowMenu(View menuLayout) {</br>
            View layout = getLayoutInflater().inflate(R.layout.toolbar_menu, null);</br>
            return super.onCreateOverflowMenu(layout);</br>
        }</br>

That's all, enjoy it! If you have better suggestions to make this widget more flexible or extendible, feel free to contact me.

