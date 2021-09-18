package com.ramosoft.artgallerycenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.IndexOutOfBoundsException

class MainActivity : AppCompatActivity() {
    private lateinit var tlTutorial: TabLayout
    private lateinit var vpTutorial: ViewPager2
    private lateinit var toolbar: Toolbar
    private lateinit var launcher_screen: RelativeLayout
    private lateinit var btn_register: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        setupViewPager()
        setTabLayout()
    }

    private fun init() {
        tlTutorial = findViewById(R.id.tl_tutorial)
        vpTutorial = findViewById(R.id.vp_tutorial)
        toolbar = findViewById(R.id.toolbar)
        launcher_screen = findViewById(R.id.launcher_screen)
        launcher_screen.visibility= View.VISIBLE
        btn_register = findViewById(R.id.btn_register)
        btn_register.setOnClickListener { launcher_screen.visibility= View.GONE }

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Important step, we enable button on the left side of the toolbar
        setSupportActionBar(toolbar)
    }

    private fun setupViewPager(){
        val viewPagerAdapter = ViewPagerAdapter(this)
        vpTutorial.adapter = viewPagerAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    private fun setTabLayout() {
        val viewPager = vpTutorial
        val tabLayout = tlTutorial

        // Set TabLayout icons and texts and attach it to ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()
    }

    /**
     * Get TabLayout icons.
     */
    private fun getTabIcon(position: Int): Int {
        return when (position) {
            FLUTTER_PAGE_INDEX -> R.drawable.ic_outline_cloud_upload_24
            KOTLIN_PAGE_INDEX -> R.drawable.ic_outline_image_24
            REACT_PAGE_INDEX -> R.drawable.ic_outline_trending_up_24
            else -> throw IndexOutOfBoundsException()
        }
    }

    /**
     * Get TabLayout titles.
     */
    private fun getTabTitle(position: Int): String {
        return when (position) {
            FLUTTER_PAGE_INDEX -> getString(R.string.uploads)
            KOTLIN_PAGE_INDEX -> getString(R.string.exhibitions)
            REACT_PAGE_INDEX -> getString(R.string.revenue)
            else -> throw IndexOutOfBoundsException()
        }
    }
}