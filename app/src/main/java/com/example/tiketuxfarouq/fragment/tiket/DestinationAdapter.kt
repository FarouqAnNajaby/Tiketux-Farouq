package com.example.tiketuxfarouq.fragment.tiket

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repository.repository.remote.response.Destination
import com.example.repository.repository.remote.response.ResultItem
import com.example.tiketuxfarouq.databinding.ItemDestinationBinding
import com.example.tiketuxfarouq.databinding.ItemTicketBinding

class DestinationAdapter(
    private val list: ArrayList<Destination>
) : RecyclerView.Adapter<DestinationAdapter.ViewHolder>() {

    private lateinit var context: Context

    class ViewHolder(val binding: ItemDestinationBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDestinationBinding.inflate(layoutInflater, parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvTujuan.text = item.rute
        holder.binding.tvHarga.text = item.tarif.toString()
        holder.binding.tvKursi.text = item.tersedia.toString()
        
    }

    override fun getItemCount(): Int = list.size
}