package com.example.tiketuxfarouq.fragment.paket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tiketuxfarouq.databinding.FragmentPaketBinding

class PaketFragment : Fragment() {

    private lateinit var binding: FragmentPaketBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPaketBinding.inflate(layoutInflater)
        return binding.root
    }

}