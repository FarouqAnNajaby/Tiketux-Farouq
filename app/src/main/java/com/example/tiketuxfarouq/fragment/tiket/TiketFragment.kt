package com.example.tiketuxfarouq.fragment.tiket

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repository.repository.remote.Resource
import com.example.repository.repository.remote.response.Departure
import com.example.repository.repository.remote.response.Destination
import com.example.tiketuxfarouq.activity.detail.DetailViewModel
import com.example.tiketuxfarouq.databinding.FragmentTiketBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class TiketFragment : Fragment() {

    private lateinit var binding: FragmentTiketBinding
    private val viewModel by sharedViewModel<DetailViewModel>()
    private val scheduleList = arrayListOf<Departure>()
    private val destinationList = arrayListOf<Destination>()
    private var adapter = TiketAdapter(scheduleList,destinationList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTiketBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDeparture().observe(viewLifecycleOwner) {
            binding.loadingView.isVisible = it is Resource.Loading
            if (it is Resource.Error) {
                Log.i("error", "onCreate: ${it.message}")
            }
            else if (it is Resource.Success){
                scheduleList.clear()
                if (it.data?.isNotEmpty() == true){
                    it.data?.forEach {
                        scheduleList.add(it!!)
                    }
                    getDataDestination()
                }
            }
        }
    }

    private fun showData() {
        binding.rvPickup.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPickup.adapter = adapter
    }

    private fun getDataDestination(){
        viewModel.getDestination().observe(viewLifecycleOwner) {
            if (it is Resource.Error) {
                Log.i("error", "onCreate: ${it.message}")
            }
            else if (it is Resource.Success){
                destinationList.clear()
                if (it.data?.isNotEmpty() == true){
                    it.data?.forEach {
                        destinationList.add(it!!)
                    }
                    showData()
                }
            }
        }
    }

}