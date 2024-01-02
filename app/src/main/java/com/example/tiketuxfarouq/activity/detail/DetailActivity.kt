package com.example.tiketuxfarouq.activity.detail

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.repository.repository.remote.response.ResultItem
import com.example.tiketuxfarouq.R
import com.example.tiketuxfarouq.constanta.Extra
import com.example.tiketuxfarouq.databinding.ActivityDetailBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gson = Gson()
        val strObj = intent.getStringExtra(Extra.DATA)
        val data: ResultItem = gson.fromJson(strObj, ResultItem::class.java)

        val sectionsPagerAdapter = SectionPagerAdapter(this)

        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        binding.tvJadwal.text = "Kamis, 07 Sep 2023"
        binding.tvTime.text = data.jam
        binding.tvDestination.text = data.rute
        binding.tvRute.text = data.layanan
        binding.tvRuteDetail.text = data.detailRute
        binding.btnBack.setOnClickListener { finish() }
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_tiket,
            R.string.tab_paket,
            R.string.tab_manifest
        )
    }
}