package pl.osp.osptemplate.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.osp.osptemplate.OspApp;
import pl.osp.osptemplate.R;
import pl.osp.osptemplate.data.model.Services;
import pl.osp.osptemplate.di.component.ActivityComponent;
import pl.osp.osptemplate.di.component.DaggerActivityComponent;
import pl.osp.osptemplate.network.IApiService;
import pl.osp.osptemplate.ui.fragment.SampleFragment;
import pl.osp.osptemplate.ui.fragment.ServicesFragment;
import pl.osp.osptemplate.ui.fragment.TimeLineFragment;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    IApiService apiService;

    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;
    @Bind(R.id.nav_view)
    NavigationView navigationView;

    private ActivityComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mComponent = DaggerActivityComponent.builder().appComponent(getApp().getAppComponent()).build();
        mComponent.inject(this);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(v ->
                Snackbar.make(v, "Retrolambda", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show());

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.gray_background));


        Observable<Services> observable2 = apiService.getServices();

        observable2.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .flatMap(servicelist -> Observable.from(servicelist.getServices()))
                .subscribe(serviceItem -> {
                    Timber.d("Service title: %s", serviceItem.getTitle());
                });
    }

    protected OspApp getApp() {
        return (OspApp) getApplicationContext();
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
        Fragment fragment = null;
        if (id == R.id.nav_services) {
            fragment = ServicesFragment.newInstance();
        } else if (id == R.id.nav_history) {
            fragment = TimeLineFragment.newInstance();
        } else if (id == R.id.nav_slideshow) {
            fragment = SampleFragment.newInstance();
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        if (fragment != null)
            setContent(fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Zmienia zawartość strony na zadany Fragment.
     *
     * @param fragment fragment, który ma zostać dodany w miejsce bieżącej zawartości
     */
    public void setContent(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.replace(R.id.content_frame, fragment);
        trans.addToBackStack(null);
        trans.commit();

    }
}
