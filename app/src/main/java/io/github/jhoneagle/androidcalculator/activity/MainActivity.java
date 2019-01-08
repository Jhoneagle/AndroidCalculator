package io.github.jhoneagle.androidcalculator.activity;

import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import io.github.jhoneagle.androidcalculator.R;
import io.github.jhoneagle.androidcalculator.logic.CalcController;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private CalcController calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        calc = new CalcController((TextView) findViewById(R.id.input_output));

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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer;

        switch (item.getItemId()) {
            case R.id.nav_camera:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                break;
            case R.id.nav_gallery:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                break;
            case R.id.nav_slideshow:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                break;
            case R.id.nav_manage:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                break;
            case R.id.nav_share:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                break;
            case R.id.nav_send:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                break;
            default:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void handleClick(View view) {
        calc.add(view);
    }
}
