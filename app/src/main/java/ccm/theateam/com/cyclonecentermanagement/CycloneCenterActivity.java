package ccm.theateam.com.cyclonecentermanagement;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class CycloneCenterActivity extends Activity implements TabHost.OnTabChangeListener {
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

        createMapView(R.id.cycloneMap);

        TabHost.TabSpec tabSpec = tabs.newTabSpec("tag1");
        tabSpec.setContent(R.id.cycloneMap);
        tabSpec.setIndicator(getString(R.string.cyclone_tab_name));
        tabs.addTab(tabSpec);

        tabSpec = tabs.newTabSpec("tag2");
        tabSpec.setContent(R.id.shelterMap);
        tabSpec.setIndicator(getString(R.string.shelter_tab_name));
        tabs.addTab(tabSpec);

        tabSpec = tabs.newTabSpec("tag3");
        tabSpec.setContent(R.id.helpsListView);
        tabSpec.setIndicator(getString(R.string.help_tab_name));
        tabs.addTab(tabSpec);

        tabs.setOnTabChangedListener(this);

    }

    private void createMapView(int id) {
        try{
            if(null==googleMap){
                googleMap = ((MapFragment)getFragmentManager().findFragmentById(id))
                        .getMap();
                // TODO: cyclone location
                setMapMarker(0,0);
            }
        }catch (NullPointerException e){

        }
    }

    private void setMapMarker(double lat,double lon){
        googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(lat,lon))
                        .title(getString(R.string.app_name))
                        .draggable(true)
        );

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
    public void onTabChanged(String s) {
        if(s.equals("tag1")){
            createMapView(R.id.cycloneMap);
            // TODO: add marker
        }else if(s.equals("tag2")){
            createMapView(R.id.shelterMap);
            // TODO: add marker
        }else if(s.equals("tag3")){
            ListView listView = (ListView)findViewById(R.id.helpsListView);
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                    getApplicationContext(),android.R.layout.simple_list_item_1,
                    getResources().getStringArray(R.array.help_list_view)
            );
            listView.setAdapter(stringArrayAdapter);
        }
    }
}
