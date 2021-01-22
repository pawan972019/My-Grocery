package com.dev.mygrocery.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dev.mygrocery.fragment.SuggestionFragment
import com.dev.mygrocery.fragment.UserHistoryFragmentList

class MainViewPagerAdapter(fm: FragmentManager?, behavior: Int, private val context: Context) : FragmentPagerAdapter(fm!!, behavior) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        if (position == 0) {
            fragment = SuggestionFragment.newInstance()
        } else if (position == 1) {
            fragment = UserHistoryFragmentList.newInstance()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
       return if (position == 0) {
            "Suggestion"
        } else {
            "History"
        }
    }
}