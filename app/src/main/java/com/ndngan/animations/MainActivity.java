package com.ndngan.animations;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Animation.AnimationListener {

    private Animation animation;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.refresh_action) {
            setAnimationToView();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.fade_in_action:
                animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
                setAnimationToView();
                break;
            case R.id.fade_out_action:
                animation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
                setAnimationToView();
                break;
            case R.id.cross_fade_action:
                animation = AnimationUtils.loadAnimation(this, R.anim.cross_fade);
                setAnimationToView();
                break;
            case R.id.blink_action:
                animation = AnimationUtils.loadAnimation(this, R.anim.cross_fade);
                setAnimationToView();
                break;
            case R.id.zoom_in_action:
                animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
                setAnimationToView();
                break;
            case R.id.zoom_out_action:
                animation = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
                setAnimationToView();
                break;
            case R.id.rotate_action:
                animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                setAnimationToView();
                break;
            case R.id.move_action:
                animation = AnimationUtils.loadAnimation(this, R.anim.move);
                setAnimationToView();
                break;
            case R.id.slide_up_action:
                animation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
                setAnimationToView();
                break;
            case R.id.slide_down_action:
                animation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
                setAnimationToView();
                break;
            case R.id.bounce_action:
                animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
                setAnimationToView();
                break;
            case R.id.share_action:
                break;
            case R.id.send_action:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setAnimationToView() {
        if (animation == null) {
            return;
        }
        animation.setAnimationListener(this);
        textView.startAnimation(animation);
        imageView.startAnimation(animation);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
