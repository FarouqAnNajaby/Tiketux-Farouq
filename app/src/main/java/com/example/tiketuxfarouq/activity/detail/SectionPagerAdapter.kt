package com.example.tiketuxfarouq.activity.detail

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tiketuxfarouq.fragment.manifest.ManifestFragment
import com.example.tiketuxfarouq.fragment.paket.PaketFragment
import com.example.tiketuxfarouq.fragment.tiket.TiketFragment

class SectionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = TiketFragment()
            1 -> fragment = TiketFragment()
            2 -> fragment = ManifestFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 3
    }

}