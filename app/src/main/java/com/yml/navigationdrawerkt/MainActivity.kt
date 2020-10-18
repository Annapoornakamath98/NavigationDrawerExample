package com.yml.navigationdrawerkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer: DrawerLayout
    private lateinit var nav: NavigationView
    private lateinit var toolBar: androidx.appcompat.widget.Toolbar
    lateinit var homeFragment: HomeFragment
    lateinit var settingsFragment: SettingsFragment
    lateinit var logoutFragment: LogoutFragment
    lateinit var workFragment: WorkFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav=findViewById(R.id.navigationView)
        drawer=findViewById(R.id.drawerLayout)
        toolBar=findViewById(R.id.toolbar2)
        setSupportActionBar(toolBar)
        val actionBar=supportActionBar
        actionBar?.title= "Navigation drawer"
        val drawerToggle: ActionBarDrawerToggle =object : ActionBarDrawerToggle(
            this,
            drawer,
            toolBar,
            (R.string.open),
            (R.string.close)
        ){

        }
        drawerToggle.isDrawerIndicatorEnabled=true
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav.setNavigationItemSelectedListener(this)
        homeFragment= HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout,homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.home1 ->{
                homeFragment= HomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout,homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.setting ->{
                settingsFragment= SettingsFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout,settingsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.work ->{
                workFragment= WorkFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout,workFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            else ->{

            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressed()
        }
    }
}