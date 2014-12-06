package ccm.theateam.com.cyclonecentermanagement;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;


public class CycloneCenterActivity extends Activity implements ActionBar.TabListener{
    TabHost tabHost;
    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyclone_center);
        init();
    }

    private void init() {
        TabHost tabs = (TabHost)findViewById(R.id.tabHost);

        tabs.setup();

        TabHost.TabSpec tabSpec = tabs.newTabSpec("tag1");
        tabSpec.setContent(R.id.cycloneMap);
        tabSpec.setIndicator(getString(R.string.cyclone_tab_name));
        tabs.addTab(tabSpec);

        tabSpec = tabs.newTabSpec("tab2");
        tabSpec.setContent(R.id.shelterMap);
        tabSpec.setIndicator(getString(R.string.shelter_tab_name));
        tabs.addTab(tabSpec);

        tabSpec = tabs.newTabSpec("tag3");
        tabSpec.setContent(R.id.helpsListView);
        tabSpec.setIndicator(getString(R.string.help_tab_name));
        tabs.addTab(tabSpec);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cyclone_center, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        Toast.makeText(this,tab.getText(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
