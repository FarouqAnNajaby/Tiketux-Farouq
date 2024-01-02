package com.example.tiketuxfarouq.fragment.armada

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repository.repository.remote.response.ResultItem
import com.example.tiketuxfarouq.databinding.ItemScheduleBinding

class ArmadaAdapter(private val list: ArrayList<ResultItem>)
    : RecyclerView.Adapter<ArmadaAdapter.ViewHolder>() {

    private lateinit var context: Context
    var onDetail: (jadwal: ResultItem) -> Unit = {}

    class ViewHolder(val binding: ItemScheduleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemScheduleBinding.inflate(layoutInflater, parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvTime.text = item.jam
        holder.binding.tvDestination.text = item.rute
        holder.binding.tvType.text = item.layanan
        holder.itemView.setOnClickListener {
            onDetail(item)
        }
    }

    override fun getItemCount(): Int = list.size
}