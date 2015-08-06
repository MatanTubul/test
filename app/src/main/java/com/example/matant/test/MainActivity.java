package com.example.matant.test;

import android.app.ActionBar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
private ActionBarDrawerToggle actbartoggle;
    private android.support.v7.app.ActionBar actionbar;
    private DrawerLayout drawer;
    private ListView navlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = (DrawerLayout)findViewById(R.id.drawer);
        navlist = (ListView)findViewById(R.id.navlist);
        actbartoggle = new ActionBarDrawerToggle(this,drawer,R.string.opendrawer,R.string.closedrawer);
        drawer.setDrawerListener(actbartoggle);
        actionbar = getSupportActionBar();

        actionbar.setDisplayShowHomeEnabled(true);
        actionbar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actbartoggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        }else if (id == android.R.id.home){
            if(drawer.isDrawerOpen(navlist)){
                drawer.closeDrawer(navlist);
            }else{
                drawer.openDrawer(navlist);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
