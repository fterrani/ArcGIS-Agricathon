package com.schoolapp.agricath;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.esri.android.map.FeatureLayer;
import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.MapView;
import com.esri.android.map.event.OnSingleTapListener;
import com.esri.android.map.event.OnStatusChangedListener;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.PointCollection;
import com.esri.arcgisruntime.geometry.SpatialReferences;
import com.esri.core.geodatabase.ShapefileFeatureTable;
//import com.esri.core.geometry.Point;

import com.esri.core.geometry.Polygon;
import com.esri.core.map.Graphic;
import com.esri.core.renderer.SimpleRenderer;
import com.esri.core.symbol.SimpleFillSymbol;
import com.esri.core.symbol.SimpleLineSymbol;
import com.esri.core.symbol.SimpleMarkerSymbol;

import java.io.FileNotFoundException;


public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    MapView mMapView;
    FeatureLayer featureLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // after the content of this activity is set
        // the map can be accessed from the layout
        mMapView = (MapView)findViewById(R.id.mapView);

        ShapefileFeatureTable shapefileFeatureTable = null;
        try {

            shapefileFeatureTable = new ShapefileFeatureTable(Environment.getExternalStorageDirectory().getPath()+"/ArcGIS/samples/HelloWorld/shapefiletest.shp");
            featureLayer = new FeatureLayer(shapefileFeatureTable);
            featureLayer.setRenderer(new SimpleRenderer(new SimpleMarkerSymbol(
                    getResources().getColor(android.R.color.holo_blue_bright),
                    28, SimpleMarkerSymbol.STYLE.CIRCLE)));

            mMapView.addLayer(featureLayer);
            GraphicsLayer graphicsLayer = new GraphicsLayer();
            SimpleLineSymbol polygonOutline = new SimpleLineSymbol(Color.DKGRAY, 2, SimpleLineSymbol.STYLE.SOLID);

// create the polygon symbol
// if an outline is not needed put "null" instead of "polygonOutline"
            SimpleFillSymbol fillSymbol = new SimpleFillSymbol(Color.GREEN, SimpleFillSymbol.STYLE.SOLID);
            fillSymbol.setOutline(polygonOutline);

// create the geometry for a polygon
            Polygon polygonGeometry = new Polygon();
            polygonGeometry.startPath(-290012, 7596957);
            polygonGeometry.lineTo(-287760, 7596957);
            polygonGeometry.lineTo(-287760, 7598669);
            polygonGeometry.lineTo(-290012, 7598669);


            PointCollection points = new PointCollection(SpatialReferences.getWebMercator());

// create and add points to the point collection
            points.add(new Point(-2.6425, 56.0784));
            points.add(new Point(-2.6430, 56.0763));
            points.add(new Point(-2.6410, 56.0759));
            points.add(new Point(-2.6380, 56.0765));
            points.add(new Point(-2.6380, 56.0784));
            points.add(new Point(-2.6410, 56.0786));

// create the polyline from the point collection

            //Polygon polygon = new Polygon(points);

// create the graphic
            Graphic polygonGraphic = new Graphic(polygonGeometry, fillSymbol);

// add the graphic to the graphics layer
            graphicsLayer.addGraphic(polygonGraphic);
            mMapView.addLayer(graphicsLayer);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //ArcGISMap map = new ArcGISMap(Basemap.Type.TOPOGRAPHIC, 46.29, 7.53, 16);
        //mMapView.setMap(map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
