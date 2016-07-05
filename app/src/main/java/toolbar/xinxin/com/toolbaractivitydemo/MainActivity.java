package toolbar.xinxin.com.toolbaractivitydemo;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import toolbar.xinxin.com.toolbaractivitydemo.widget.ToolbarActivity;

public class MainActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onCreateFreeToolbar(ViewGroup root) {
        getLayoutInflater().inflate(R.layout.toolbar, root);
        super.onCreateFreeToolbar(root);

        getFreeToolbar().setTitle("Hit me");
        getFreeToolbar().setTitleOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hit me!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected boolean onCreateOverflowMenu(View menuLayout) {
        View layout = getLayoutInflater().inflate(R.layout.toolbar_menu, null);
        return super.onCreateOverflowMenu(layout);
    }

    @Override
    public void onMenuItemSelected(View menuItem) {
        switch (menuItem.getId()) {
            case R.id.menu1:
                Toast.makeText(MainActivity.this, "menu1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(MainActivity.this, "menu2", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
