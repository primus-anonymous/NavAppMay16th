package com.neocaptainnemo.navappmay16th

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pager: ViewPager2 = view.findViewById(R.id.view_pager)

        pager.adapter = PagerAdapter(this)

        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)

        TabLayoutMediator(tabLayout, pager) { tab, position ->
//            tab.text = "Tab $position"
            tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_android_black_24dp)
            tab.customView = layoutInflater.inflate(R.layout.tab_custom, null).apply {
                findViewById<TextView>(R.id.name).text = "Tab $position"
                findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_android_black_24dp)

            }
        }.attach()

        val dotsIndicator = view.findViewById<DotsIndicator>(R.id.dots_indicator)
        dotsIndicator.attachTo(pager)
    }

    class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = 5

        override fun createFragment(position: Int): Fragment = PageFragment.instance(position)

    }

}
