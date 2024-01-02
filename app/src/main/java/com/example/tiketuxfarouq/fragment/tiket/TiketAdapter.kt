package com.example.tiketuxfarouq.fragment.tiket

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repository.repository.remote.response.Departure
import com.example.repository.repository.remote.response.Destination
import com.example.tiketuxfarouq.databinding.ItemTicketBinding


class TiketAdapter(
    private val list: ArrayList<Departure>,
    private val listDestination: ArrayList<Destination>,
) : RecyclerView.Adapter<TiketAdapter.ViewHolder>() {

    private lateinit var context: Context
    private lateinit var adapter: DestinationAdapter

    class ViewHolder(val binding: ItemTicketBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTicketBinding.inflate(layoutInflater, parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvJam.text = item.jamBerangkat
        holder.binding.tvDeparture.text = item.alamat
        var isOpen = false
        adapter = DestinationAdapter(listDestination)
        holder.binding.rvDetail.layoutManager = LinearLayoutManager(context)
        holder.binding.rvDetail.adapter = adapter
        holder.itemView.setOnClickListener {
            isOpen = !isOpen
            holder.binding.rvDetail.isVisible = isOpen
        }
    }

    override fun getItemCount(): Int = list.size
}