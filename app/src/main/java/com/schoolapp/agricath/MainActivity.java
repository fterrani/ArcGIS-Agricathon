package com.schoolapp.agricath;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

//import com.esri.arcgisruntime.mapping.ArcGISMap;
//import com.esri.arcgisruntime.mapping.Basemap;
//import com.esri.arcgisruntime.mapping.view.MapView;


public class MainActivity extends AppCompatActivity {
    //private MapView mMapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*mMapView = findViewById(R.id.mapView);
        ArcGISMap map = new ArcGISMap(Basemap.Type.TOPOGRAPHIC, 46.29, 7.53, 16);
        mMapView.setMap(map);*/
    }

    @Override
    protected void onPause(){
        //mMapView.pause();
        super.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        //mMapView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //mMapView.dispose();
    }
}
