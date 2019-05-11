package com.ifsp.omdbsearch.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.ifsp.omdbsearch.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        displayScreen(-1)

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)

        }

    }

    fun  displayScreen (id: Int){

        if(id == R.id.git_leo){

            //val webpage: Uri
            val webpage = Uri.parse("https://github.com/firestrings")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            val b = Bundle()
            b.putBoolean("new_window", true)
            intent.putExtras(b)
            startActivity(intent)

        }

        if(id == R.id.git_rafa){

            //val webpage: Uri
            val webpage = Uri.parse("https://github.com/RafaelRodrigues7")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            val b = Bundle()
            b.putBoolean("new_window", true)
            intent.putExtras(b)
            startActivity(intent)

        }

        val fragment = when (id){

            R.id.byName -> {
                SearchByNameActivity ()
            }

            R.id.byId -> {
                SearchByIdActivity ()
            }

            R.id.home -> {
                InicialACtivity ()
            }

            else -> {
                InicialACtivity()
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.relativelayout, fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayScreen(item.itemId)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
