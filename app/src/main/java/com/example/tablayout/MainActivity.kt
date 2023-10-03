package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.tablayout.adapter.PagerAdapter
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()
    }

    private fun initial() {
        binding.viewPager.adapter = PagerAdapter(this)
        binding.tabLayout.tabIconTint = null
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {
            tab, pos ->
            when(pos) {
                0 -> {
                    tab.setIcon(R.drawable.baseline_anchor_24)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.white))
                }
                1 -> {
                    tab.setIcon(R.drawable.baseline_architecture_24)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.white))
                    tab.icon?.alpha = 70
                }
                else -> {
                    tab.setIcon(R.drawable.baseline_deck_24)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.white))
                    tab.icon?.alpha = 70
                }
            }
        }.attach()
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 250
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 70
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }
}