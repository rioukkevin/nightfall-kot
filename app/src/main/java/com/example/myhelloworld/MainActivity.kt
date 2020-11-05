package com.example.myhelloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        title = resources.getString(R.string.view_home)
        val homeFragment = HomeFragment.newInstance("pseudo du user", 750f)
        loadFragment(homeFragment!!)

        navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_map -> {
                    title = resources.getString(R.string.view_map)
                    loadFragment(MapFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_home -> {
                    title = resources.getString(R.string.view_home)
                    loadFragment(homeFragment!!)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_share -> {
                    title = resources.getString(R.string.view_share)
                    loadFragment(ShareFragment(activity = this@MainActivity))
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_qr -> {
                    title = resources.getString(R.string.view_qr)
                    loadFragment(QrFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_news -> {
                    title = resources.getString(R.string.view_news)
                    loadFragment(NewsFragment())
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}


