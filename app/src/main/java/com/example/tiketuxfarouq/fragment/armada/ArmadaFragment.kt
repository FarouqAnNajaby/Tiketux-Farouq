package com.example.tiketuxfarouq.fragment.armada

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repository.repository.remote.Resource
import com.example.repository.repository.remote.response.ResultItem
import com.example.tiketuxfarouq.activity.detail.DetailActivity
import com.example.tiketuxfarouq.activity.main.MainViewModel
import com.example.tiketuxfarouq.constanta.Extra
import com.example.tiketuxfarouq.databinding.FragmentArmadaBinding
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ArmadaFragment : Fragment() {

    private lateinit var binding: FragmentArmadaBinding
    private val viewModel by sharedViewModel<MainViewModel>()
    private val scheduleList = arrayListOf<ResultItem>()
    private val filteredList = arrayListOf<ResultItem>()
    private val adapter = ArmadaAdapter(filteredList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArmadaBinding.inflate(layoutInflater)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnJadwal.text = "Kamis 07 Sept 2023"
        viewModel.getArmada().observe(viewLifecycleOwner) {
            binding.loadingView.isVisible = it is Resource.Loading
            if (it is Resource.Error) {
                Log.i("error", "onCreate: ${it.message}")
            }
            else if (it is Resource.Success){
                scheduleList.clear()
                filteredList.clear()
                if (it.data?.isNotEmpty() == true){
                    it.data?.forEach {
                        scheduleList.add(it!!)
                    }
                    scheduleList.sortBy { it.jam }
                    filteredList.addAll(scheduleList)
                    showData()
                }
            }
        }

        binding.filterSearch.setSubmitListener { query ->
            if (query.isNotBlank()) {
                filteredList.clear()
                filteredList.addAll(scheduleList.filter {
                    it.jam!!.contains(query, true) ||
                            it.rute!!.contains(query, true)
                })
                adapter.notifyDataSetChanged()
            }
        }
        binding.filterSearch.setChangeListener {
            if (it.isBlank()) {
                filteredList.clear()
                filteredList.addAll(scheduleList)
                showData()
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun showData() {
        binding.rvRute.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRute.adapter = adapter
        adapter.onDetail = {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            val json = Gson().toJson(it)
            intent.putExtra(Extra.DATA, json)
            startActivity(intent)
        }
    }
}