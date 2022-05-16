package com.neocaptainnemo.navappmay16th

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.badge.BadgeDrawable.TOP_START
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, InputValueFragment())
                .commit()
        }

        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav)

        bottomNavView.getOrCreateBadge(R.id.action_message)

        val badge = bottomNavView.getBadge(R.id.action_message)

        badge?.number = 150
        badge?.maxCharacterCount = 2
        badge?.badgeGravity = TOP_START

        badge?.clearNumber()

        bottomNavView.removeBadge(R.id.action_message)

        bottomNavView.setOnItemReselectedListener {

        }

        bottomNavView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.action_message -> InputValueFragment()
                R.id.action_pager -> ViewPagerFragment()
                R.id.action_tab -> TabHostFragment()
                else -> null
            }?.also { fragment ->
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
            }

            true
        }

    }
}