package com.example.tiketuxfarouq.fragment.manifest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tiketuxfarouq.databinding.FragmentManifestBinding

class ManifestFragment : Fragment() {

    private lateinit var binding: FragmentManifestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentManifestBinding.inflate(layoutInflater)
        return binding.root
    }

}