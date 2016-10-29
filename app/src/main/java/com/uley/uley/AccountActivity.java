package com.uley.uley;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.MapFragment;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.context.IconicsLayoutInflater;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.uley.uley.fragments.FragmentCurrent;
import com.uley.uley.fragments.FragmentVac;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate())); //автоматичкое определение иконок
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);




    final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Anton").withEmail("anton.kostuk.2012@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
                        return false;
                    }
                })
                .build();

        new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                            .withName("Вакансии")
                            .withIcon(FontAwesome.Icon.faw_book)
                            .withIdentifier(1),
                        new SecondaryDrawerItem()
                            .withName("Текущие")
                            .withIcon(FontAwesome.Icon.faw_creative_commons)
                            .withIdentifier(2),
                        new SecondaryDrawerItem()
                            .withName("Сообщения")
                            .withIcon(FontAwesome.Icon.faw_pause),
                        new SecondaryDrawerItem()
                            .withName("Карта")
                            .withIdentifier(4)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        long id = drawerItem.getIdentifier();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentVac FV = new FragmentVac();
                        FragmentCurrent FC = new FragmentCurrent();
                        MapFragment mMapFragment = MapFragment.newInstance();
                        FragmentTransaction fragmentTransaction = new FragmentTransaction() {
                            @Override
                            public FragmentTransaction add(Fragment fragment, String s) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction add(int i, Fragment fragment) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction add(int i, Fragment fragment, String s) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction replace(int i, Fragment fragment) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction replace(int i, Fragment fragment, String s) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction remove(Fragment fragment) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction hide(Fragment fragment) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction show(Fragment fragment) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction detach(Fragment fragment) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction attach(Fragment fragment) {
                                return null;
                            }

                            @Override
                            public boolean isEmpty() {
                                return false;
                            }

                            @Override
                            public FragmentTransaction setCustomAnimations(int i, int i1) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction setCustomAnimations(int i, int i1, int i2, int i3) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction setTransition(int i) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction addSharedElement(View view, String s) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction setTransitionStyle(int i) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction addToBackStack(String s) {
                                return null;
                            }

                            @Override
                            public boolean isAddToBackStackAllowed() {
                                return false;
                            }

                            @Override
                            public FragmentTransaction disallowAddToBackStack() {
                                return null;
                            }

                            @Override
                            public FragmentTransaction setBreadCrumbTitle(int i) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction setBreadCrumbShortTitle(int i) {
                                return null;
                            }

                            @Override
                            public FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
                                return null;
                            }

                            @Override
                            public int commit() {
                                return 0;
                            }

                            @Override
                            public int commitAllowingStateLoss() {
                                return 0;
                            }

                            @Override
                            public void commitNow() {

                            }

                            @Override
                            public void commitNowAllowingStateLoss() {

                            }
                        };



                        if (id == 1){
                            fragmentTransaction.remove(mMapFragment);
                            fragmentManager.beginTransaction().replace(R.id.container, FV).commit();
                            toolbar.setTitle("Vacantion");

                        } else if (id == 2){
                            fragmentTransaction.remove(mMapFragment);
                            fragmentManager.beginTransaction().replace(R.id.container, FC).commit();
                            toolbar.setTitle("Current");


                        } else if(id==4){
                            FragmentTransaction fTransaction =
                                    getFragmentManager().beginTransaction();
                            fTransaction.add(R.id.container, mMapFragment);
                            fTransaction.commit();


                        }
                        /*fragmentManager.beginTransaction().remove();*/
                        return false;
                    }
                })
                .build();


    }

    /*public void onClick(View view)
    {
        Intent intent = new Intent(AccountActivity.this, MapsActivity.class);
        startActivity(intent);

    }*/

}


