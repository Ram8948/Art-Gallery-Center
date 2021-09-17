package com.ramosoft.artgallerycenter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by Tubianto on 07/07/2021.
 */
class ViewPagerAdapter(fragment: AppCompatActivity) : FragmentStateAdapter(fragment) {

    /**
     * ViewPager pages to their respective fragments.
     */
    private val fragmentsCreator: Map<Int, () -> Fragment> = mapOf(
        FLUTTER_PAGE_INDEX to { FlutterFragment() },
        KOTLIN_PAGE_INDEX to { KotlinFragment() },
        REACT_PAGE_INDEX to { ReactNativeFragment()}
    )

    override fun getItemCount() = fragmentsCreator.size

    override fun createFragment(position: Int): Fragment {
        return fragmentsCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}

const val FLUTTER_PAGE_INDEX = 0
const val KOTLIN_PAGE_INDEX = 1
const val REACT_PAGE_INDEX = 2