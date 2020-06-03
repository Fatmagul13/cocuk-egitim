package com.fatmagulyurtseven.cocukegitim.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fatmagulyurtseven.cocukegitim.Fragment.AnasayfaFragment;
import com.fatmagulyurtseven.cocukegitim.Fragment.IngilizceFragment;
import com.fatmagulyurtseven.cocukegitim.Fragment.TestlerFragment;
import com.fatmagulyurtseven.cocukegitim.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        AnasayfaFragment AnasayfaFragment=new AnasayfaFragment();
        FragmentManager manager=getFragmentManager();
        FragmentTransaction ft=manager.beginTransaction();
        ft.add(R.id.framelayout,AnasayfaFragment);
        ft.commit();

        DrawerLayout drawer = ( DrawerLayout ) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = ( NavigationView ) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed( ) {
        DrawerLayout drawer = ( DrawerLayout ) findViewById(R.id.drawer_layout);
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
        /*if (id == R.id.action_settings) {
            return true;
        }

        <item
        android:id="@+id/action_settings"
        android:orderInCategory="100"
        android:title="@string/action_settings"
        app:showAsAction="never" />*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager manager=getFragmentManager();
        FragmentTransaction ft=manager.beginTransaction();
        if (id == R.id.nav_anasayfa) {
            AnasayfaFragment AnasayfaFragment=new AnasayfaFragment();
            ft.replace(R.id.framelayout,AnasayfaFragment);
            ft.commit();

        } else if (id == R.id.nav_ingilizce) {
            IngilizceFragment ing=new IngilizceFragment();
            ft.replace(R.id.framelayout,ing);
            ft.commit();
        } else if (id == R.id.nav_testler) {
            TestlerFragment test=new TestlerFragment();
            ft.replace(R.id.framelayout,test);
            ft.commit();
        }
        else if (id == R.id.nav_paylas) {
            Intent myIntent=new Intent( (Intent.ACTION_SEND) );
            myIntent.setType( "text/plain" );
            String shareBody ="TestApp";
            String shareSub="Cocuk Eğitim Mobil Uygulaması";
            myIntent.putExtra( Intent.EXTRA_SUBJECT,shareBody );
            myIntent.putExtra( Intent.EXTRA_TEXT,shareSub );
            startActivity( Intent.createChooser( myIntent,"Şununla Paylaş" ) );

        }

        DrawerLayout drawer = ( DrawerLayout ) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
